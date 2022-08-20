package co.com.sofka.ventas.clientes.eventos;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.ventas.clientes.objetosvalor.ClienteID;
import co.com.sofka.ventas.clientes.objetosvalor.Nombre;
import co.com.sofka.ventas.clientes.objetosvalor.NumeroTelefono;

public class DatosPersonalesAgregados extends DomainEvent {

    private final ClienteID clienteId;
    private final Nombre nombre;
    private final NumeroTelefono numeroTelefono;

    public DatosPersonalesAgregados(ClienteID clienteId ,Nombre nombre, NumeroTelefono numeroTelefono) {
        super("co.com.sofka.ventas.DatosPersonalesAgregados");
        this.clienteId = clienteId;
        this.nombre = nombre;
        this.numeroTelefono = numeroTelefono;
    }

    public ClienteID getClienteId() {
        return clienteId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public NumeroTelefono getNumeroTelefono() {
        return numeroTelefono;
    }

}

