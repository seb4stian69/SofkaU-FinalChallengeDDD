package co.com.sofka.ventas.empleados.entidades;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.ventas.clientes.objetosvalor.Nombre;
import co.com.sofka.ventas.empleados.objetosvalor.DatosPersonalesID;
import co.com.sofka.ventas.empleados.objetosvalor.MedioPago;
import co.com.sofka.ventas.empleados.objetosvalor.Salario;

public class DatosPersonales extends Entity<DatosPersonalesID> {

    private final Nombre nombre;
    private final MedioPago medioPago;
    private final Salario salario;

    public DatosPersonales(DatosPersonalesID entityId, Nombre nombre, MedioPago medioPago, Salario salario) {
        super(entityId);
        this.nombre = nombre;
        this.medioPago = medioPago;
        this.salario = salario;
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
