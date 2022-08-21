package almacen;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.ventas.almacen.Almacen;
import co.com.sofka.ventas.almacen.comandos.CrearAlmacen;

public class CrearAlmacenUsecase extends UseCase<RequestCommand<CrearAlmacen>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearAlmacen> crearAlmacenRequestCommand) {

        var command = crearAlmacenRequestCommand.getCommand();
        var almacen = new Almacen(
            command.getAlmacenID(),
            command.getEspecializacion()
        );

        emit().onResponse(new ResponseEvents(almacen.getUncommittedChanges()));

    }
}
