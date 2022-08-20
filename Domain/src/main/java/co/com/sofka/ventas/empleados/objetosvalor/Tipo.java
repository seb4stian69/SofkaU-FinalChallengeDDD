package co.com.sofka.ventas.empleados.objetosvalor;

import co.com.sofka.domain.generic.ValueObject;
import java.util.Objects;

public class Tipo implements ValueObject<String> {

    private final String tipo;

    public Tipo(String tipo) {

        this.tipo = Objects.requireNonNull(tipo);

        if (this.tipo.isBlank() || this.tipo.isEmpty()) {
            throw new IllegalArgumentException("Debe agregar correctamente un tipo");
        }

    }

    public static Tipo of(String tipo) {
        return new Tipo(tipo);
    }

    @Override
    public String value() {
        return tipo;
    }

}
