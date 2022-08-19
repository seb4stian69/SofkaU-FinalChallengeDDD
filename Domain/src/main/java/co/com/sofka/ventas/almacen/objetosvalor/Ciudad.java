package co.com.sofka.ventas.almacen.objetosvalor;

import co.com.sofka.domain.generic.ValueObject;
import java.util.Objects;

public class Ciudad implements ValueObject<Ciudad.Props> {

    private final String nombreCiudad;
    private final String nombreDepartamento;

    public Ciudad(String NombreCiudad, String NombreDepartamento) {

        this.nombreCiudad = Objects.requireNonNull(NombreCiudad);
        this.nombreDepartamento = Objects.requireNonNull(NombreDepartamento);

        if(this.nombreDepartamento.isEmpty() || this.nombreDepartamento.isBlank()){
            throw new IllegalArgumentException("NombreDepartamento  must not be empty or null");
        }

        if(this.nombreCiudad.isEmpty() || this.nombreCiudad.isBlank()){
            throw new IllegalArgumentException("NombreCiudad  must not be empty or null");
        }

    }

    @Override
    public Props value() {
        return new Props(){
            @Override
            public String NombreCiudad() {
                return nombreCiudad;
            }
            @Override
            public String NombreDepartamento() {
                return nombreDepartamento;
            }
        };
    }

    public interface Props {
        String NombreCiudad();
        String NombreDepartamento();
    }
}
