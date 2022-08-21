package clientes;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.ventas.almacen.objetosvalor.AlmacenID;
import co.com.sofka.ventas.almacen.objetosvalor.ProductoID;
import co.com.sofka.ventas.clientes.comandos.RealizarCompra;
import co.com.sofka.ventas.clientes.eventos.ClienteAgregado;
import co.com.sofka.ventas.clientes.eventos.CompraRealizada;
import co.com.sofka.ventas.clientes.objetosvalor.ClienteID;
import co.com.sofka.ventas.clientes.objetosvalor.FechaCompra;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

class RealizarCompraUsecaseTest {

    @InjectMocks
    RealizarCompraUsecase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void RealizarCompra(){

        // Arrange
        var clienteID = ClienteID.of("idClienteFour");
        var fechaCompra = new FechaCompra(Date.from(Instant.now()));
        var almacenID = AlmacenID.of("idAlmacenOne");
        var productoID = ProductoID.of("idProductoOne");
        var command = new RealizarCompra(clienteID,fechaCompra,almacenID,productoID);

        when(repository.getEventsBy("idClienteFour")).thenReturn(history());
        useCase.addRepository(repository);

        // Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getClienteId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        // Assert
        var event = (CompraRealizada) events.get(0);
        Assertions.assertEquals(Date.from(Instant.now()).getDate(), event.getFechaCompra().value().getDate());
        Assertions.assertEquals("idAlmacenOne", event.getAlmacenID().value());
        Assertions.assertEquals("idProductoOne", event.getProductoId().value());


    }

    private List<DomainEvent> history(){

        var fecha = Date.from(Instant.now());
        var fechaCompra = new FechaCompra(fecha);
        var event = new ClienteAgregado(fechaCompra);
        event.setAggregateRootId("xxxx");

        return List.of(event);

    }

}