package co.com.sofka.ventas.almacen.entidades;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.ventas.almacen.objetosvalor.PrecioProducto;
import co.com.sofka.ventas.almacen.objetosvalor.ProductoID;
import co.com.sofka.ventas.almacen.objetosvalor.TipoProducto;

public class Productos extends Entity<ProductoID> {

    private final ProductoID productoID;
    private final TipoProducto  tipoProducto;
    private final PrecioProducto precioProducto;

    public Productos(ProductoID entityId, ProductoID productoID, TipoProducto tipoProducto, PrecioProducto precioProducto) {
        super(entityId);
        this.productoID = productoID;
        this.tipoProducto = tipoProducto;
        this.precioProducto = precioProducto;
    }

    public ProductoID getProductoID() {
        return productoID;
    }

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public PrecioProducto getPrecioProducto() {
        return precioProducto;
    }
}
