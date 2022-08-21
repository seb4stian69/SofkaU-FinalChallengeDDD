package almacen;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.ventas.almacen.comandos.CrearAlmacen;
import co.com.sofka.ventas.almacen.eventos.AlmacenCreado;
import co.com.sofka.ventas.almacen.objetosvalor.AlmacenID;
import co.com.sofka.ventas.almacen.objetosvalor.Especializacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CrearAlmacenUsecaseTest {

    private CrearAlmacenUsecase useCase;

    @BeforeEach
    public void setup() {
        useCase = new CrearAlmacenUsecase();
    }

    @Test
    void CrearAlmacen(){

        // Arrange
        var almacenID = AlmacenID.of("idAlmacenThree");
        var especializacion = new Especializacion(Especializacion.Tipo.Muebles);
        var command = new CrearAlmacen(almacenID,especializacion);

        // Act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        // Assert
        var event = (AlmacenCreado) events.get(0);
        Assertions.assertEquals(Especializacion.Tipo.Muebles, event.getEspecializacion().value());

    }

}