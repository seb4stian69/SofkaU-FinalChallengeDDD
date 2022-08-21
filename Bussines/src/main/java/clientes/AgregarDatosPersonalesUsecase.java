package clientes;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.ventas.clientes.Clientes;
import co.com.sofka.ventas.clientes.comandos.AgregarDatosPersonales;

public class AgregarDatosPersonalesUsecase extends UseCase<RequestCommand<AgregarDatosPersonales>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarDatosPersonales> agregarDatosPersonalesRequestCommand) {

        var command = agregarDatosPersonalesRequestCommand.getCommand();
        var cliente = Clientes.from(command.getClienteId(),repository().getEventsBy(command.getClienteId().value()));

        cliente.AgregarDatosPersonales(
            command.getDatosPersonalesId(),
            command.getNombre(),
            command.getNumeroTelefono()
        );

        emit().onResponse(new ResponseEvents(cliente.getUncommittedChanges()));

    }
}
