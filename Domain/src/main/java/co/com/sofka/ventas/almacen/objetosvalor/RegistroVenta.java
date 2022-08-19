package co.com.sofka.ventas.almacen.objetosvalor;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class RegistroVenta implements ValueObject<RegistroVenta.Props> {

    private final ProductoID producto;
    private Integer cantidad;

    public RegistroVenta(ProductoID producto, Integer cantidad) {
        this.producto = Objects.requireNonNull(producto);
        this.cantidad = Objects.requireNonNull(cantidad);

        if(this.producto.value() == null) {
            throw new IllegalArgumentException("Producto ID cannot be null");
        }

        if(this.cantidad == null) {
            throw new IllegalArgumentException("Cantidad cannot be null");
        }
    }

    @Override
    public RegistroVenta.Props value() {
        return new Props(){
            @Override
            public ProductoID producto() {
                return producto;
            }
            @Override
            public Integer cantidad() {
                return cantidad;
            }
        };
    }

    public interface Props {
        ProductoID producto();
        Integer cantidad();
    }
}
