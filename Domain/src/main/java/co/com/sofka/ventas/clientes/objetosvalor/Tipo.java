package co.com.sofka.ventas.clientes.objetosvalor;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Tipo implements ValueObject<String> {

    private final String tipoCliente;

    public Tipo(String tipoCliente) {
        this.tipoCliente = Objects.requireNonNull(tipoCliente);

        if (this.tipoCliente.isEmpty() || this.tipoCliente.isBlank()) {
            throw new IllegalArgumentException("Debe agregar correctamente un numero de telefono");
        }

    }

    public static Tipo of(String tipoCliente) {
        return new Tipo(tipoCliente);
    }

    @Override
    public String value() {
        return tipoCliente;
    }

}
