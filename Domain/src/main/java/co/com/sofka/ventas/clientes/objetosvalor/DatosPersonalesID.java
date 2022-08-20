package co.com.sofka.ventas.clientes.objetosvalor;

import co.com.sofka.domain.generic.Identity;

public class DatosPersonalesID extends Identity {

    public DatosPersonalesID (String id) {
        super(id);
    }

    public static DatosPersonalesID of (String id) {
        return new DatosPersonalesID(id);
    }

}
