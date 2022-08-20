package co.com.sofka.ventas.empleados.comandos;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.ventas.empleados.objetosvalor.DatosPersonalesID;
import co.com.sofka.ventas.empleados.objetosvalor.MedioPago;
import co.com.sofka.ventas.empleados.objetosvalor.Nombre;
import co.com.sofka.ventas.empleados.objetosvalor.Salario;

public class AgregarDatosPersonales extends Command {

    private final DatosPersonalesID datosPersonalesId;
    private final Nombre nombre;
    private final MedioPago medioPago;
    private final Salario salario;

    public AgregarDatosPersonales(DatosPersonalesID datosPersonalesId, Nombre nombre, MedioPago medioPago, Salario salario) {
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
