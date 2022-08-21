package co.com.sofka.ventas.empleados.comandos;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.ventas.empleados.objetosvalor.*;

public class AgregarDatosPersonales extends Command {

    private final EmpleadoID empleadoId;
    private final DatosPersonalesID datosPersonalesId;
    private final Nombre nombre;
    private final MedioPago medioPago;
    private final Salario salario;

    public AgregarDatosPersonales(EmpleadoID empleadosID,DatosPersonalesID datosPersonalesId, Nombre nombre, MedioPago medioPago, Salario salario) {
        this.empleadoId = empleadosID;
        this.datosPersonalesId = datosPersonalesId;
        this.nombre = nombre;
        this.medioPago = medioPago;
        this.salario = salario;
    }

    public EmpleadoID getEmpleadoId() {
        return empleadoId;
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
