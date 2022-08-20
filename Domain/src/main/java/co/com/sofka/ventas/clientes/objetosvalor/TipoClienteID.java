package co.com.sofka.ventas.clientes.objetosvalor;

import co.com.sofka.domain.generic.Identity;

public class TipoClienteID extends Identity {

    public TipoClienteID (String id) {
        super(id);
    }

    public static TipoClienteID of (String id) {
        return new TipoClienteID(id);
    }

}
