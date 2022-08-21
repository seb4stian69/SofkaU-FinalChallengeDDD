package empleados;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.ventas.empleados.comandos.ActualizarLabor;
import co.com.sofka.ventas.empleados.eventos.EmpleadoAgregado;
import co.com.sofka.ventas.empleados.eventos.LaborActualizada;
import co.com.sofka.ventas.empleados.objetosvalor.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Time;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ActualizarLaborUsecaseTest {

    @InjectMocks
    ActualizarLaborUsecase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void ActualizarLabor(){

        // Arrange
        var empleadoID = EmpleadoID.of("idEmpleadoThree");
        var laborID = LaborID.of("idLaborOne");
        var tipo = Tipo.of("Vendedor de muebles");
        var hora = new Time(12,47,56);
        var fecha = Date.from(Instant.now());
        var horario = new Horario(hora,fecha);
        var command = new ActualizarLabor(empleadoID,laborID,tipo,horario);

        when(repository.getEventsBy("idEmpleadoThree")).thenReturn(history());
        useCase.addRepository(repository);

        // Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getEmpleadoId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        // Assert
        var event = (LaborActualizada) events.get(0);
        Assertions.assertEquals("Vendedor de muebles", event.getTipo().value());
        Assertions.assertEquals(new Time(12,47,56), event.getHorario().value().Hora());
        Assertions.assertEquals( Date.from(Instant.now()).getDate() , event.getHorario().value().Fecha().getDate());

    }

    private List<DomainEvent> history(){

        var almacen = new Almacen("Almacen muebles");
        var event = new EmpleadoAgregado(almacen);
        event.setAggregateRootId("xxxx");

        var event2 = new EmpleadoAgregado(almacen);

        return List.of(event,event2);

    }

}