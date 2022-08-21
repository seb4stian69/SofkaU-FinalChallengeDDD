package co.com.sofka.ventas.empleados.eventos;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.ventas.empleados.objetosvalor.Almacen;

public class EmpleadoAgregado extends DomainEvent {

    private final Almacen almacen;

    public EmpleadoAgregado(Almacen almacen){
        super("co.com.sofka.ventas.EmpleadoAgregado");
        this.almacen = almacen;
    }

    public Almacen getAlmacen() {
        return almacen;
    }

}
