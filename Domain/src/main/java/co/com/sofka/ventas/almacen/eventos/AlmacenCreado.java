package co.com.sofka.ventas.almacen.eventos;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.ventas.almacen.objetosvalor.AlmacenID;
import co.com.sofka.ventas.almacen.objetosvalor.Especializacion;

public class AlmacenCreado extends DomainEvent {

    private final Especializacion especializacion;

    public AlmacenCreado(Especializacion especializacion) {
        super("co.com.sofka.ventas.AlmacenCreado");
        this.especializacion = especializacion;
    }

    public Especializacion getEspecializacion() {
        return especializacion;
    }

}
