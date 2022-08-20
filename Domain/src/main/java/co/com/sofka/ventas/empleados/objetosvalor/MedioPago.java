package co.com.sofka.ventas.empleados.objetosvalor;

import co.com.sofka.domain.generic.ValueObject;

public class MedioPago implements ValueObject<MedioPago.Tipo> {
    private final MedioPago.Tipo tipo;
    public MedioPago(MedioPago.Tipo tipo) {
        this.tipo = tipo;
        if(String.valueOf(this.tipo).isBlank()){
            throw new IllegalArgumentException("Tipo MedioPago is blank");
        }
    }

    public static MedioPago of(MedioPago.Tipo tipo){
        return new MedioPago(tipo);
    }

    @Override
    public MedioPago.Tipo value() {
        return tipo;
    }

    public enum Tipo {
        Efectivo, TarjetaCredito
    }

}
