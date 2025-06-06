package co.com.sofka.ventas.almacen.comandos;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.ventas.almacen.objetosvalor.AlmacenID;
import co.com.sofka.ventas.almacen.objetosvalor.Ciudad;
import co.com.sofka.ventas.almacen.objetosvalor.Direccion;
import co.com.sofka.ventas.almacen.objetosvalor.UbicacionID;

public class AgregarUbicacion extends Command {

    private final AlmacenID almacenID;
    private final UbicacionID ubicacionID;
    private final Direccion direccion;
    private final Ciudad ciudad;

    public AgregarUbicacion(AlmacenID almacenID,UbicacionID ubicacionID, Direccion direccion, Ciudad ciudad) {
        this.almacenID = almacenID;
        this.ubicacionID = ubicacionID;
        this.direccion = direccion;
        this.ciudad = ciudad;
    }

    public AlmacenID getAlmacenID() {
        return almacenID;
    }

    public UbicacionID getUbicacionID() {
        return ubicacionID;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

}
