package co.com.sofka.ventas.empleados.comandos;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.ventas.empleados.objetosvalor.Almacen;
import co.com.sofka.ventas.empleados.objetosvalor.EmpleadoID;

public class AgregarEmpleados extends Command {

    private final EmpleadoID empleadoID;
    private final Almacen almacen;

    public AgregarEmpleados(EmpleadoID empleadoID, Almacen almacen) {
        this.empleadoID = empleadoID;
        this.almacen = almacen;
    }

    public EmpleadoID getEmpleadoID() {
        return empleadoID;
    }

    public Almacen getAlmacen() {
        return almacen;
    }
}
