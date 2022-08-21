package almacen;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.ventas.almacen.Almacen;
import co.com.sofka.ventas.almacen.comandos.AgregarUbicacion;

public class AgregarUbicacionUsecase  extends UseCase<RequestCommand<AgregarUbicacion>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarUbicacion> agregarUbicacionRequestCommand) {

        var command = agregarUbicacionRequestCommand.getCommand();
        var almacen = Almacen.from(command.getAlmacenID(), repository().getEventsBy(command.getAlmacenID().value()));

        almacen.agregarUbicaciones(
            command.getUbicacionID(),
            command.getDireccion(),
            command.getCiudad()
        );

        emit().onResponse(new ResponseEvents(almacen.getUncommittedChanges()));

    }
}
