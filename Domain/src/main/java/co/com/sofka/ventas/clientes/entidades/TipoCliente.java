package co.com.sofka.ventas.clientes.entidades;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.ventas.clientes.objetosvalor.Tipo;
import co.com.sofka.ventas.clientes.objetosvalor.TipoClienteID;

public class TipoCliente extends Entity<TipoClienteID> {

    private final Tipo tipo;

    public TipoCliente(TipoClienteID entityId, Tipo tipo) {
        super(entityId);
        this.tipo = tipo;
    }

    public Tipo getTipo() {
        return tipo;
    }

}
