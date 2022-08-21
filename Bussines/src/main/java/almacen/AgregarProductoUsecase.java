package almacen;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.ventas.almacen.Almacen;
import co.com.sofka.ventas.almacen.comandos.AgregoProducto;

public class AgregarProductoUsecase extends UseCase<RequestCommand<AgregoProducto>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregoProducto> agregoProductoRequestCommand) {

        var command = agregoProductoRequestCommand.getCommand();
        var almacen = Almacen.from(command.getAlmacenID(), repository().getEventsBy(command.getAlmacenID().value()));

        almacen.agregarProducto(
            command.getProductoId(),
            command.getTipoProducto(),
            command.getPrecioProducto()
        );

        emit().onResponse(new ResponseEvents(almacen.getUncommittedChanges()));

    }
}
