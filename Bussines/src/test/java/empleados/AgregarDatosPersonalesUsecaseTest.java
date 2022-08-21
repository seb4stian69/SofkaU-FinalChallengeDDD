package empleados;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.ventas.empleados.comandos.AgregarDatosPersonales;
import co.com.sofka.ventas.empleados.eventos.DatosPersonalesAgregados;
import co.com.sofka.ventas.empleados.eventos.EmpleadoAgregado;
import co.com.sofka.ventas.empleados.objetosvalor.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
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
        var empleadoID = EmpleadoID.of("idEmpleadoTwo");
        var datosPersonalesID = DatosPersonalesID.of("idDatosPersonalesOne");
        var nombre = new Nombre("Nombre", "Apellido");
        var medioPago = MedioPago.of(MedioPago.Tipo.Efectivo);
        var salario = new Salario(10000);
        var command = new AgregarDatosPersonales(empleadoID,datosPersonalesID,nombre,medioPago,salario);

        when(repository.getEventsBy("idEmpleadoTwo")).thenReturn(history());
        useCase.addRepository(repository);

        // Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getEmpleadoId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        // Assert
        var event = (DatosPersonalesAgregados) events.get(0);
        Assertions.assertEquals("Nombre", event.getNombre().value().nombre());
        Assertions.assertEquals("Apellido", event.getNombre().value().apellido());
        Assertions.assertEquals(MedioPago.Tipo.Efectivo, event.getMedioPago().value());


    }

    private List<DomainEvent> history(){

        var almacen = new Almacen("Almacen muebles");
        var event = new EmpleadoAgregado(almacen);
        event.setAggregateRootId("xxxx");

        return List.of(event);

    }

}
