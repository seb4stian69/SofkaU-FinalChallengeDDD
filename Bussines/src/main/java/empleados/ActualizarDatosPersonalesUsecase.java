package empleados;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.ventas.empleados.Empleados;
import co.com.sofka.ventas.empleados.comandos.ActualizarDatosPersonales;

public class ActualizarDatosPersonalesUsecase extends UseCase<RequestCommand<ActualizarDatosPersonales>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarDatosPersonales> actualizarDatosPersonalesRequestCommand) {

        var command = actualizarDatosPersonalesRequestCommand.getCommand();
        var empleado = Empleados.from(command.getEmpleadoId(), repository().getEventsBy(command.getEmpleadoId().value()));

        empleado.ActualizarDatosPersonales(
            command.getDatosPersonalesId(),
            command.getNombre(),
            command.getMedioPago(),
            command.getSalario()
        );

        emit().onResponse(new ResponseEvents(empleado.getUncommittedChanges()));

    }
}
