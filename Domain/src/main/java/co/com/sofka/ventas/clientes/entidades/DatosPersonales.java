package co.com.sofka.ventas.clientes.entidades;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.ventas.clientes.objetosvalor.DatosPersonalesID;
import co.com.sofka.ventas.clientes.objetosvalor.Nombre;
import co.com.sofka.ventas.clientes.objetosvalor.NumeroTelefono;

public class DatosPersonales extends Entity<DatosPersonalesID> {

    private final Nombre nombre;
    private final NumeroTelefono numeroTelefono;

    public DatosPersonales(DatosPersonalesID entityId, Nombre nombre, NumeroTelefono numeroTelefono) {
        super(entityId);
        this.nombre = nombre;
        this.numeroTelefono = numeroTelefono;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public NumeroTelefono getNumeroTelefono() {
        return numeroTelefono;
    }
}
