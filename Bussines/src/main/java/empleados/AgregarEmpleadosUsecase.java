package empleados;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.ventas.empleados.Empleados;
import co.com.sofka.ventas.empleados.comandos.AgregarEmpleados;

public class AgregarEmpleadosUsecase extends UseCase<RequestCommand<AgregarEmpleados>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarEmpleados> agregarEmpleadosRequestCommand) {

        var command = agregarEmpleadosRequestCommand.getCommand();

        var empleado = new Empleados(
            command.getEmpleadoID(),
            command.getAlmacen()
        );

        emit().onResponse(new ResponseEvents(empleado.getUncommittedChanges()));

    }
}
