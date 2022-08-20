package co.com.sofka.ventas.almacen.comandos;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.ventas.almacen.objetosvalor.AlmacenID;
import co.com.sofka.ventas.almacen.objetosvalor.Especializacion;

public class CrearAlmacen extends Command {

    private final AlmacenID almacenID;
    private final Especializacion especializacion;

    public CrearAlmacen(AlmacenID almacenID, Especializacion especializacion) {
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
