package co.com.sofka.ventas.almacen.objetosvalor;

import co.com.sofka.domain.generic.ValueObject;

public class TipoProducto implements ValueObject<TipoProducto.Tipo> {

    private final TipoProducto.Tipo tipo;

    public TipoProducto(TipoProducto.Tipo tipo) {
        this.tipo = tipo;
        if(String.valueOf(this.tipo).isBlank()){
            throw new IllegalArgumentException("Tipo producto is blank");
        }
    }

    public static TipoProducto of(Tipo tipo){
        return new TipoProducto(tipo);
    }

    @Override
    public TipoProducto.Tipo value() {
        return tipo;
    }

    public enum Tipo {
        Mueble, Colchon
    }
}
