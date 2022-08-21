package clientes;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.ventas.clientes.comandos.AgregarTipoCliente;
import co.com.sofka.ventas.clientes.eventos.ClienteAgregado;
import co.com.sofka.ventas.clientes.eventos.TipoClienteAgregado;
import co.com.sofka.ventas.clientes.objetosvalor.ClienteID;
import co.com.sofka.ventas.clientes.objetosvalor.FechaCompra;
import co.com.sofka.ventas.clientes.objetosvalor.Tipo;
import co.com.sofka.ventas.clientes.objetosvalor.TipoClienteID;
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
class AgregarTipoClienteUsecaseTest {

    @InjectMocks
    AgregarTipoClienteUsecase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void AgregarTipoCliente(){

        // Arrange
        var clienteID = ClienteID.of("idClienteThree");
        var tipoClienteID = TipoClienteID.of("idTipoClientOne");
        var tipoCliente = new Tipo("Al por mayor");
        var command = new AgregarTipoCliente(clienteID, tipoClienteID, tipoCliente);

        when(repository.getEventsBy("idClienteThree")).thenReturn(history());
        useCase.addRepository(repository);

        // Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getClienteid().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        // Assert
        var event = (TipoClienteAgregado) events.get(0);
        Assertions.assertEquals("Al por mayor", event.getTipo().value());

    }

    private List<DomainEvent> history(){

        var fecha = Date.from(Instant.now());
        var fechaCompra = new FechaCompra(fecha);
        var event = new ClienteAgregado(fechaCompra);
        event.setAggregateRootId("xxxx");

        return List.of(event);

    }

}