package co.com.sofka.ventas.almacen.objetosvalor;

import co.com.sofka.domain.generic.Identity;

public class AlmacenID extends Identity {

    public AlmacenID (String id) {
        super(id);
    }

    public static AlmacenID of (String id) {
        return new AlmacenID(id);
    }

}
