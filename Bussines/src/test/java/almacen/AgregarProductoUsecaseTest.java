package almacen;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.ventas.almacen.comandos.AgregoProducto;
import co.com.sofka.ventas.almacen.eventos.AlmacenCreado;
import co.com.sofka.ventas.almacen.eventos.ProductoAgregado;
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
class AgregarProductoUsecaseTest {

    @InjectMocks
    AgregarProductoUsecase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void AgregarProducto(){

        // Arrange
        var almacenID = AlmacenID.of("idAlmacenOne");
        var productoID = ProductoID.of("idProductoOne");
        var tipoProducto = TipoProducto.of(TipoProducto.Tipo.Mueble);
        var precioProducto = new PrecioProducto(6.00, 1.5);
        var command = new AgregoProducto(almacenID, productoID,tipoProducto,precioProducto);

        when(repository.getEventsBy("idAlmacenOne")).thenReturn(history());
        useCase.addRepository(repository);

        // Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getAlmacenID().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        // Assert
        var event = (ProductoAgregado) events.get(0);
        Assertions.assertEquals(TipoProducto.Tipo.Mueble, event.getTipoProducto().value());
        Assertions.assertEquals(6.00, event.getPrecioProducto().value().ValorProducto());
        Assertions.assertEquals(1.5, event.getPrecioProducto().value().DescuentoProducto());

    }

    private List<DomainEvent> history(){

        var especializacion = new Especializacion(Especializacion.Tipo.Muebles);
        var event = new AlmacenCreado(especializacion);
        event.setAggregateRootId("almacenID");

        return List.of(event);

    }

}