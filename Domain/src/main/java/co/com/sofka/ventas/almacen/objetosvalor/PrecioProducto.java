package co.com.sofka.ventas.almacen.objetosvalor;

import co.com.sofka.domain.generic.ValueObject;

import java.math.BigDecimal;
import java.util.Objects;

public class PrecioProducto implements ValueObject<PrecioProducto.Props> {

    private final Double valorProducto;
    private final Double descuentoProducto;

    public PrecioProducto(Double ValorProducto, Double DescuentoProducto) {

        this.valorProducto = Objects.requireNonNull(ValorProducto);
        this.descuentoProducto = Objects.requireNonNull(DescuentoProducto);

        if(this.valorProducto.equals(0.0)){
            throw new IllegalArgumentException("valorProducto must not be empty or null");
        }

        if(this.descuentoProducto == 0.0){
            throw new IllegalArgumentException("descuentoProducto must not be empty or null");
        }

    }

    @Override
    public PrecioProducto.Props value() {
        return new Props() {
            @Override
            public Double ValorProducto() {
                return valorProducto;
            }
            @Override
            public Double DescuentoProducto() {
                return descuentoProducto;
            }
        };
    }

    public interface Props {
        Double ValorProducto();
        Double DescuentoProducto();
    }
}
