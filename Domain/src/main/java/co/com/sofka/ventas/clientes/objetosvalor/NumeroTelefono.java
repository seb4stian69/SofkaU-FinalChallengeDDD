package co.com.sofka.ventas.clientes.objetosvalor;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Date;
import java.util.Objects;

public class NumeroTelefono implements ValueObject<Integer> {

    private final Integer numero;

    public NumeroTelefono(Integer numero) {
        this.numero = Objects.requireNonNull(numero);

        if (this.numero <= 0) {
            throw new IllegalArgumentException("Debe agregar correctamente un numero de telefono");
        }

    }

    public static NumeroTelefono of(Integer numero) {
        return new NumeroTelefono(numero);
    }

    @Override
    public Integer value() {
        return numero;
    }

}
