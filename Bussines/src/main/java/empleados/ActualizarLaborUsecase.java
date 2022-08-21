package empleados;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.ventas.empleados.Empleados;
import co.com.sofka.ventas.empleados.comandos.ActualizarLabor;

public class ActualizarLaborUsecase extends UseCase<RequestCommand<ActualizarLabor>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarLabor> actualizarLaborRequestCommand) {

        var command = actualizarLaborRequestCommand.getCommand();
        var empleado = Empleados.from(command.getEmpleadoId(), repository().getEventsBy(command.getEmpleadoId().value()));

        empleado.ActualizarLabor(
            command.getLaborID(),
            command.getTipo(),
            command.getHorario()
        );

        emit().onResponse(new ResponseEvents(empleado.getUncommittedChanges()));

    }
}
