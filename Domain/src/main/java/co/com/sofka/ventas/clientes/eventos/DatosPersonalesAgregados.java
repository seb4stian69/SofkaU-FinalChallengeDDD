package co.com.sofka.ventas.clientes.eventos;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.ventas.clientes.objetosvalor.ClienteID;
import co.com.sofka.ventas.clientes.objetosvalor.DatosPersonalesID;
import co.com.sofka.ventas.clientes.objetosvalor.Nombre;
import co.com.sofka.ventas.clientes.objetosvalor.NumeroTelefono;

public class DatosPersonalesAgregados extends DomainEvent {

    private final DatosPersonalesID datosPersonalesId;
    private final Nombre nombre;
    private final NumeroTelefono numeroTelefono;

    public DatosPersonalesAgregados(DatosPersonalesID datosPersonalesId,Nombre nombre, NumeroTelefono numeroTelefono) {
        super("co.com.sofka.ventas.DatosPersonalesAgregados");
        this.datosPersonalesId = datosPersonalesId;
        this.nombre = nombre;
        this.numeroTelefono = numeroTelefono;
    }

    public DatosPersonalesID getDatosPersonalesId() {
        return datosPersonalesId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public NumeroTelefono getNumeroTelefono() {
        return numeroTelefono;
    }

}

