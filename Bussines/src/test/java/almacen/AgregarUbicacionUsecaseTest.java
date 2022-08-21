package almacen;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.ventas.almacen.comandos.AgregarUbicacion;
import co.com.sofka.ventas.almacen.eventos.AlmacenCreado;
import co.com.sofka.ventas.almacen.eventos.UbicacionAgregada;
import co.com.sofka.ventas.almacen.objetosvalor.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class AgregarUbicacionUsecaseTest {

    @InjectMocks
    AgregarUbicacionUsecase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void AgregarUbicacion(){

        // Arrange
        var almacenID = AlmacenID.of("idAlmacenTwo");
        var ubicacionID = UbicacionID.of("idUbicacionOne");
        var direccion = new Direccion("Carrera","Calle","Descripcion");
        var ciudad = new Ciudad("NombreCiudad","NombreDepartamento");
        var command = new AgregarUbicacion(almacenID,ubicacionID,direccion,ciudad);

        when(repository.getEventsBy("idAlmacenTwo")).thenReturn(history());
        useCase.addRepository(repository);

        // Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getAlmacenID().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        // Assert
        var event = (UbicacionAgregada) events.get(0);
        Assertions.assertEquals("Carrera",event.getDireccion().value().Carrera());
        Assertions.assertEquals("Calle",event.getDireccion().value().Calle());
        Assertions.assertEquals("Descripcion",event.getDireccion().value().Descripcion());
        Assertions.assertEquals("NombreCiudad",event.getCiudad().value().NombreCiudad());
        Assertions.assertEquals("NombreDepartamento",event.getCiudad().value().NombreDepartamento());

    }

    private List<DomainEvent> history(){

        var especializacion = new Especializacion(Especializacion.Tipo.Muebles);
        var event = new AlmacenCreado(especializacion);
        event.setAggregateRootId("xxxx");

        return List.of(event);

    }
}