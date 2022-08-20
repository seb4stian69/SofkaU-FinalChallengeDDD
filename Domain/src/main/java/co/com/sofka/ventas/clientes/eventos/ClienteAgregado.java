package co.com.sofka.ventas.clientes.eventos;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.ventas.clientes.objetosvalor.FechaCompra;

public class ClienteAgregado extends DomainEvent {

    private final FechaCompra fechaCompra;

    public ClienteAgregado(FechaCompra fechaCompra) {
        super("co.com.sofka.ventas.ClienteAgregado");
        this.fechaCompra = fechaCompra;
    }

    public FechaCompra getFechaCompra() {
        return fechaCompra;
    }

}
