package co.com.sofka.ventas.almacen.comandos;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.ventas.almacen.objetosvalor.PrecioProducto;
import co.com.sofka.ventas.almacen.objetosvalor.ProductoID;
import co.com.sofka.ventas.almacen.objetosvalor.TipoProducto;

public class AgregoProducto extends Command {

    private final ProductoID productoId;
    private final TipoProducto tipoProducto;
    private final PrecioProducto precioProducto;

    public AgregoProducto(ProductoID productoId, TipoProducto tipoProducto, PrecioProducto precioProducto) {
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
