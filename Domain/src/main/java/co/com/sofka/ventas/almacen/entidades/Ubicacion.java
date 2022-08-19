package co.com.sofka.ventas.almacen.entidades;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.ventas.almacen.objetosvalor.Ciudad;
import co.com.sofka.ventas.almacen.objetosvalor.Direccion;
import co.com.sofka.ventas.almacen.objetosvalor.UbicacionID;

public class Ubicacion extends Entity<UbicacionID> {

    private final Direccion direccion;
    private final Ciudad ciudad;

    public Ubicacion(UbicacionID entityId, UbicacionID ubicacionID, Direccion direccion, Ciudad ciudad) {
        super(entityId);
        this.direccion = direccion;
        this.ciudad = ciudad;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }
}
