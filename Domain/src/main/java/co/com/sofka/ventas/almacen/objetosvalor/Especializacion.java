package co.com.sofka.ventas.almacen.objetosvalor;

import co.com.sofka.domain.generic.ValueObject;

public class Especializacion implements ValueObject<Especializacion.Tipo> {

    private final Especializacion.Tipo tipo;

    public Especializacion(Especializacion.Tipo tipo) {
        this.tipo = tipo;
        if(String.valueOf(this.tipo).isBlank()){
            throw new IllegalArgumentException("Tipo producto is blank");
        }
    }

    public static Especializacion of(Especializacion.Tipo tipo){
        return new Especializacion(tipo);
    }

    @Override
    public Especializacion.Tipo value() {
        return tipo;
    }

    public enum Tipo {
        Muebles, Colchones, MueblesYcolchones
    }

}
