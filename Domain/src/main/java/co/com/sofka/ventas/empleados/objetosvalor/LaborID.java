package co.com.sofka.ventas.empleados.objetosvalor;

import co.com.sofka.domain.generic.Identity;

public class LaborID extends Identity {

    public LaborID (String id) {
        super(id);
    }

    public static LaborID of (String id) {
        return new LaborID(id);
    }

}
