package clientes;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.ventas.clientes.comandos.AgregarDatosPersonales;
import co.com.sofka.ventas.clientes.eventos.ClienteAgregado;
import co.com.sofka.ventas.clientes.eventos.DatosPersonalesAgregados;
import co.com.sofka.ventas.clientes.objetosvalor.*;
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
class AgregarDatosPersonalesUsecaseTest {

    @InjectMocks
    AgregarDatosPersonalesUsecase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void AgregarDatosPersonales(){

        // Arrange
        var clienteID = ClienteID.of("idClienteTwo");
        var datosPersonalesID = DatosPersonalesID.of("idDatosPersonalesIne");
        var nombre = new Nombre("Nombre", "Apellido");
        var numeroTelefono = new NumeroTelefono(300010120);
        var command = new AgregarDatosPersonales(clienteID,datosPersonalesID,nombre,numeroTelefono);

        when(repository.getEventsBy("idClienteTwo")).thenReturn(history());
        useCase.addRepository(repository);

        // Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getClienteId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();


        // Assert
        var event = (DatosPersonalesAgregados) events.get(0);
        Assertions.assertEquals("Nombre", event.getNombre().value().nombre());
        Assertions.assertEquals("Apellido", event.getNombre().value().apellido());
        Assertions.assertEquals(300010120, event.getNumeroTelefono().value());

    }

    private List<DomainEvent> history(){

        var fecha = Date.from(Instant.now());
        var fechaCompra = new FechaCompra(fecha);
        var event = new ClienteAgregado(fechaCompra);
        event.setAggregateRootId("xxxx");

        return List.of(event);

    }

}