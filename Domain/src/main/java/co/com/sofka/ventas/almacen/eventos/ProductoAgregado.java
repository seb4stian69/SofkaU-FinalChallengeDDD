package co.com.sofka.ventas.almacen.eventos;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.ventas.almacen.objetosvalor.PrecioProducto;
import co.com.sofka.ventas.almacen.objetosvalor.ProductoID;
import co.com.sofka.ventas.almacen.objetosvalor.TipoProducto;

public class ProductoAgregado extends DomainEvent {

    private final ProductoID productoId;
    private final TipoProducto tipoProducto;
    private final PrecioProducto precioProducto;

    public ProductoAgregado(ProductoID productoId, TipoProducto tipoProducto, PrecioProducto precioProducto) {
        super("co.com.sofka.ventas.ProductoAgregado");
        this.productoId = productoId;
        this.tipoProducto = tipoProducto;
        this.precioProducto = precioProducto;
    }

    public ProductoID getProductoId() {
        return productoId;
    }

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public PrecioProducto getPrecioProducto() {
        return precioProducto;
    }

}
