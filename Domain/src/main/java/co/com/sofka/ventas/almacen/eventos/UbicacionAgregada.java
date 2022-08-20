package co.com.sofka.ventas.almacen.eventos;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.ventas.almacen.objetosvalor.Ciudad;
import co.com.sofka.ventas.almacen.objetosvalor.Direccion;
import co.com.sofka.ventas.almacen.objetosvalor.UbicacionID;

public class UbicacionAgregada extends DomainEvent {

    private final Direccion direccion;
    private final Ciudad ciudad;

    public UbicacionAgregada(UbicacionID ubicacionID, Direccion direccion, Ciudad ciudad) {
        super("co.com.sofka.ventas.UbicacionAgregada");
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
