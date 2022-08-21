package clientes;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.ventas.clientes.comandos.AgregarCliente;
import co.com.sofka.ventas.clientes.eventos.ClienteAgregado;
import co.com.sofka.ventas.clientes.objetosvalor.ClienteID;
import co.com.sofka.ventas.clientes.objetosvalor.FechaCompra;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.Instant;
import java.util.Date;

class AgregarClienteUsecaseTest {

    private AgregarClienteUsecase useCase;

    @BeforeEach
    public void setup() {
        useCase = new AgregarClienteUsecase();
    }

    @Test
    void AgregarCliente(){

        // Arrange
        var clienteID = ClienteID.of("idClienteOne");
        var fecha = Date.from(Instant.now());
        var fechaCompra = new FechaCompra(fecha);
        var command = new AgregarCliente(fechaCompra,clienteID);

        // Act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        // Assert
        var event = (ClienteAgregado) events.get(0);
        Assertions.assertEquals(Date.from(Instant.now()).getDate(), event.getFechaCompra().value().getDate());

    }

}