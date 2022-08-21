package empleados;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.ventas.empleados.comandos.AgregarEmpleados;
import co.com.sofka.ventas.empleados.eventos.EmpleadoAgregado;
import co.com.sofka.ventas.empleados.objetosvalor.Almacen;
import co.com.sofka.ventas.empleados.objetosvalor.EmpleadoID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;


class AgregarEmpleadosUsecaseTest {

    @InjectMocks
    AgregarEmpleadosUsecase useCase;

    @BeforeEach
    public void setup() {
        useCase = new AgregarEmpleadosUsecase();
    }

    @Test
    void AgregarEmpleados(){

        // Arrange
        var empleadoID = EmpleadoID.of("idEmpleadoOne");
        var almacen = new Almacen("Almacen muebles");
        var command = new AgregarEmpleados(empleadoID, almacen);

        // Act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        // Assert
        var event = (EmpleadoAgregado) events.get(0);
        Assertions.assertEquals("Almacen muebles", event.getAlmacen().value());

    }

}