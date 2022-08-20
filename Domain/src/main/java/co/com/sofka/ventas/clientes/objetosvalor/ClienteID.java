package co.com.sofka.ventas.clientes.objetosvalor;

import co.com.sofka.domain.generic.Identity;

public class ClienteID extends Identity {

    public ClienteID (String id) {
        super(id);
    }

    public static ClienteID of (String id) {
        return new ClienteID(id);
    }

}
