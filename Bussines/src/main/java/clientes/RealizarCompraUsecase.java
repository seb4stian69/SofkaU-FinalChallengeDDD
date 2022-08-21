package clientes;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.ventas.clientes.Clientes;
import co.com.sofka.ventas.clientes.comandos.RealizarCompra;

public class RealizarCompraUsecase extends UseCase<RequestCommand<RealizarCompra>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<RealizarCompra> realizarCompraRequestCommand) {

        var command = realizarCompraRequestCommand.getCommand();
        var cliente = Clientes.from(command.getClienteId(),repository().getEventsBy(command.getClienteId().value()));

        cliente.RealizarCompra(
            command.getClienteId(),
            command.getFechaCompra(),
            command.getAlmacenID(),
            command.getProductoId()
        );

    }
}
