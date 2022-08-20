package co.com.sofka.ventas.clientes.eventos;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.ventas.clientes.objetosvalor.ClienteID;
import co.com.sofka.ventas.clientes.objetosvalor.Tipo;
import co.com.sofka.ventas.clientes.objetosvalor.TipoClienteID;

public class TipoClienteAgregado extends DomainEvent {

    private final ClienteID clienteId;
    private final Tipo tipo;

    public TipoClienteAgregado(ClienteID clienteId ,Tipo tipo) {
        super("co.com.sofka.ventas.TipoClienteAgregado");
        this.clienteId = clienteId;
        this.tipo = tipo;
    }

    public ClienteID getClienteId() {
        return clienteId;
    }

    public Tipo getTipo() {
        return tipo;
    }

}
