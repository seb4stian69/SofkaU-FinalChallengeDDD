package empleados;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.ventas.empleados.Empleados;
import co.com.sofka.ventas.empleados.comandos.AgregarDatosPersonales;

public class AgregarDatosPersonalesUsecase extends UseCase<RequestCommand<AgregarDatosPersonales>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarDatosPersonales> agregarDatosPersonalesRequestCommand) {

        var command = agregarDatosPersonalesRequestCommand.getCommand();
        var empleado = Empleados.from(command.getEmpleadoId(), repository().getEventsBy(command.getEmpleadoId().value()));

        empleado.AgregarDatosPersonales(
                command.getDatosPersonalesId(),
                command.getNombre(),
                command.getMedioPago(),
                command.getSalario()
        );

    }
}
