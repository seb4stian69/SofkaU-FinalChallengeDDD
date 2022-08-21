package clientes;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.ventas.clientes.Clientes;
import co.com.sofka.ventas.clientes.comandos.AgregarCliente;

public class AgregarClienteUsecase extends UseCase<RequestCommand<AgregarCliente>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarCliente> agregarClienteRequestCommand) {

        var command = agregarClienteRequestCommand.getCommand();
        var cliente = new Clientes(
            command.getClienteid(),
            command.getFechaCompra()
        );

        emit().onResponse(new ResponseEvents(cliente.getUncommittedChanges()));

    }
}
