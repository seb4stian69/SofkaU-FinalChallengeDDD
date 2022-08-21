package clientes;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.ventas.clientes.Clientes;
import co.com.sofka.ventas.clientes.comandos.AgregarTipoCliente;

public class AgregarTipoClienteUsecase extends UseCase<RequestCommand<AgregarTipoCliente>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarTipoCliente> agregarTipoClienteRequestCommand) {

        var command = agregarTipoClienteRequestCommand.getCommand();
        var cliente = Clientes.from(command.getClienteid(),repository().getEventsBy(command.getClienteid().value()));

        cliente.AgregarTipoCliente(
            command.getTipoClienteID(),
            command.getTipo()
        );

    }
}
