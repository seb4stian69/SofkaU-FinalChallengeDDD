package co.com.sofka.ventas.almacen.objetosvalor;

import co.com.sofka.domain.generic.ValueObject;
import java.util.Objects;

public class Direccion implements ValueObject<Direccion.Props> {

    private final String carrera;
    private final String calle;
    private final String descripcion;

    public Direccion(String carrera, String calle, String descripcion) {

        this.carrera = Objects.requireNonNull(carrera);
        this.calle = Objects.requireNonNull(calle);
        this.descripcion = Objects.requireNonNull(descripcion);

        if(this.carrera.isBlank() || this.carrera.isEmpty()) {
            throw new IllegalArgumentException("Carrera must not be empty or blank");
        }

        if(this.calle.isBlank() || this.calle.isEmpty()) {
            throw new IllegalArgumentException("Calle must not be empty or blank");
        }

        if(this.descripcion.isBlank() || this.descripcion.isEmpty()) {
            throw new IllegalArgumentException("Descripcion must not be empty or blank");
        }

    }

    @Override
    public Props value() {
        return new Props(){
            @Override
            public String Carrera() {
                return carrera;
            }

            @Override
            public String Calle() {
                return calle;
            }

            @Override
            public String Descripcion() {
                return descripcion;
            }
        };
    }

    public interface Props {
        String Carrera();
        String Calle();
        String Descripcion();
    }
}
