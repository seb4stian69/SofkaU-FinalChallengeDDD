package co.com.sofka.ventas.empleados.comandos;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.ventas.empleados.objetosvalor.Almacen;

public class AgregarEmpleados extends Command {

    private final EmpeladoID empleadoID;
    private final Almacen almacen;

    public AgregarEmpleados(EmpeladoID empleadoID, Almacen almacen) {
        this.empleadoID = empleadoID;
        this.almacen = almacen;
    }

    public EmpeladoID getEmpleadoID() {
        return empleadoID;
    }

    public Almacen getAlmacen() {
        return almacen;
    }
}
