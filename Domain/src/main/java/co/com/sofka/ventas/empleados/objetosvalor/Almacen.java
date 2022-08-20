package co.com.sofka.ventas.empleados.objetosvalor;

import co.com.sofka.domain.generic.ValueObject;
import java.util.Objects;

public class Almacen implements ValueObject<String> {

    private final String nombre;

    public Almacen(String nombre) {

        this.nombre = Objects.requireNonNull(nombre);

        if (this.nombre.isBlank() || this.nombre.isEmpty()) {
            throw new IllegalArgumentException("Debe agregar correctamente un nombre");
        }

    }

    public static Almacen of(String nombre) {
        return new Almacen(nombre);
    }

    @Override
    public String value() {
        return nombre;
    }

}
