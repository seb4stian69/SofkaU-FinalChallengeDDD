package co.com.sofka.ventas.almacen.eventos;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.ventas.almacen.objetosvalor.AlmacenID;
import co.com.sofka.ventas.almacen.objetosvalor.Especializacion;

public class AlmacenCreado extends DomainEvent {

    private final AlmacenID almacenID;
    private final Especializacion especializacion;

    public AlmacenCreado(AlmacenID almacenID, Especializacion especializacion) {
        super("co.com.sofka.ventas.AlmacenCreado");
        this.almacenID = almacenID;
        this.especializacion = especializacion;
    }

    public AlmacenID getAlmacenID() {
        return almacenID;
    }

    public Especializacion getEspecializacion() {
        return especializacion;
    }

}
