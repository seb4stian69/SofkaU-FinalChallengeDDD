package co.com.sofka.ventas.almacen.entidades;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.ventas.almacen.objetosvalor.PrecioProducto;
import co.com.sofka.ventas.almacen.objetosvalor.ProductoID;
import co.com.sofka.ventas.almacen.objetosvalor.TipoProducto;

public class Productos extends Entity<ProductoID> {

    private final TipoProducto  tipoProducto;
    private final PrecioProducto precioProducto;

    public Productos(ProductoID entityId, TipoProducto tipoProducto, PrecioProducto precioProducto) {
        super(entityId);
        this.tipoProducto = tipoProducto;
        this.precioProducto = precioProducto;
    }

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public PrecioProducto getPrecioProducto() {
        return precioProducto;
    }
}
