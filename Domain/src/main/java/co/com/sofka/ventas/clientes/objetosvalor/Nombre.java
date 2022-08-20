package co.com.sofka.ventas.clientes.objetosvalor;

import co.com.sofka.domain.generic.ValueObject;

public class Nombre implements ValueObject<Nombre.Props> {

    private final String nombre;
    private final String apellido;

    public Nombre(String nombre, String apellido) {

        this.nombre = nombre;
        this.apellido = apellido;

        if(this.nombre.isEmpty() || this.nombre.isBlank()){
            throw new IllegalArgumentException("nombre  must not be empty or null");
        }

        if(this.apellido.isEmpty() || this.apellido.isBlank()){
            throw new IllegalArgumentException("apellido  must not be empty or null");
        }

    }

    @Override
    public Props value() {
        return new Props(){
            @Override
            public String nombre() {
                return nombre;
            }

            @Override
            public String apellido() {
                return apellido;
            }
        };
    }

    public interface Props {
        String nombre();
        String apellido();
    }
}
