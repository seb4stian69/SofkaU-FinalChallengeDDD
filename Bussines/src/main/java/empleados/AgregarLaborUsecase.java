package empleados;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.ventas.empleados.Empleados;
import co.com.sofka.ventas.empleados.comandos.AgregarLabor;

public class AgregarLaborUsecase extends UseCase<RequestCommand<AgregarLabor>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarLabor> agregarLaborUsecaseRequestCommand) {

        var command = agregarLaborUsecaseRequestCommand.getCommand();
        var empleado = Empleados.from(command.getEmpleadoId(), repository().getEventsBy(command.getEmpleadoId().value()));

        empleado.AgregarLabor(
                command.getLaborID(),
                command.getTipo(),
                command.getHorario()
        );

    }
}
