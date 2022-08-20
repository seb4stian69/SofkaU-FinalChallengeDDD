package co.com.sofka.ventas.clientes.eventos;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.ventas.clientes.objetosvalor.ClienteID;
import co.com.sofka.ventas.clientes.objetosvalor.Tipo;
import co.com.sofka.ventas.clientes.objetosvalor.TipoClienteID;

public class TipoClienteAgregado extends DomainEvent {

    private final TipoClienteID tipoClienteID;
    private final Tipo tipo;

    public TipoClienteAgregado(TipoClienteID clienteId ,Tipo tipo) {
        super("co.com.sofka.ventas.TipoClienteAgregado");
        this.tipoClienteID = clienteId;
        this.tipo = tipo;
    }

    public TipoClienteID getTipoClienteID() {
        return tipoClienteID;
    }

    public Tipo getTipo() {
        return tipo;
    }

}
