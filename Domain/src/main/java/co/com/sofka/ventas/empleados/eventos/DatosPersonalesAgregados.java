package co.com.sofka.ventas.empleados.eventos;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.ventas.empleados.objetosvalor.DatosPersonalesID;
import co.com.sofka.ventas.empleados.objetosvalor.MedioPago;
import co.com.sofka.ventas.empleados.objetosvalor.Nombre;
import co.com.sofka.ventas.empleados.objetosvalor.Salario;

public class DatosPersonalesAgregados extends DomainEvent {

    private final DatosPersonalesID datosPersonalesId;
    private final Nombre nombre;
    private final MedioPago medioPago;
    private final Salario salario;

    public DatosPersonalesAgregados(DatosPersonalesID datosPersonalesId, Nombre nombre, MedioPago medioPago, Salario salario) {
        super("co.com.sofka.ventas.DatosPersonalesAgregados");
        this.datosPersonalesId = datosPersonalesId;
        this.nombre = nombre;
        this.medioPago = medioPago;
        this.salario = salario;
    }

    public DatosPersonalesID getDatosPersonalesId() {
        return datosPersonalesId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public MedioPago getMedioPago() {
        return medioPago;
    }

    public Salario getSalario() {
        return salario;
    }

}
