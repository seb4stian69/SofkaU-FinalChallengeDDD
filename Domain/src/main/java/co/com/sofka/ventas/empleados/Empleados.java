package co.com.sofka.ventas.empleados;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.ventas.empleados.entidades.DatosPersonales;
import co.com.sofka.ventas.empleados.entidades.Labor;
import co.com.sofka.ventas.empleados.eventos.*;
import co.com.sofka.ventas.empleados.objetosvalor.*;

import java.util.List;
import java.util.Optional;

public class Empleados extends AggregateEvent<EmpleadoID> {

    protected DatosPersonales datosPersonales;
    protected Labor labor;
    protected Salario salario;
    protected Almacen almacen;

    public Empleados(EmpleadoID empleadosID, Almacen almacen) {
        super(empleadosID);
        appendChange(new EmpleadoAgregado(almacen));
    }

    private Empleados(EmpleadoID empleadosID){
        super(empleadosID);
        subscribe(new EmpleadosChange(this));
    }

    public static Empleados from(EmpleadoID empleadosID, List<DomainEvent> events){
        var empleados = new Empleados(empleadosID);
        events.forEach(empleados::applyEvent);
        return empleados;
    }

    // Comportamientos

    public void AgregarDatosPersonales(DatosPersonalesID datosPersonalesId, Nombre nombre, MedioPago medioPago, Salario salario){
        appendChange(new DatosPersonalesAgregados(datosPersonalesId,nombre,medioPago,salario));
    }

    public void AgregarLabor(LaborID laborID, Tipo tipo, Horario horario){
        appendChange(new LaborAgregada(laborID,tipo,horario));
    }

    public void ActualizarDatosPersonales(DatosPersonalesID datosPersonalesId, Nombre nombre, MedioPago medioPago, Salario salario){
        appendChange(new DatosPersonalesActualizados(datosPersonalesId,nombre,medioPago,salario));
    }

    public void ActualizarLabor(LaborID laborID, Tipo tipo, Horario horario){
        appendChange(new LaborActualizada(laborID,tipo,horario));
    }

}
