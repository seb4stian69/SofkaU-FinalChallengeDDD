package co.com.sofka.ventas.clientes.objetosvalor;

import java.security.Identity;

public class ClienteID extends Identity {

    public ClienteID (String id) {
        super(id);
    }

    public static ClienteID of (String id) {
        return new ClienteID(id);
    }

}
