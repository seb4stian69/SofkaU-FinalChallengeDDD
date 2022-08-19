package co.com.sofka.ventas.almacen.objetosvalor;

import co.com.sofka.domain.generic.Identity;

public class UbicacionID extends Identity {

    public UbicacionID(String id) {
        super(id);
    }

    public static UbicacionID of(String id) {
        return new UbicacionID(id);
    }

}
