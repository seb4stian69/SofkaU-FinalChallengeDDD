package co.com.sofka.ventas.clientes.comandos;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.ventas.clientes.objetosvalor.ClienteID;
import co.com.sofka.ventas.clientes.objetosvalor.Tipo;
import co.com.sofka.ventas.clientes.objetosvalor.TipoClienteID;

public class AgregarTipoCliente extends Command {

    private final TipoClienteID tipoClienteID;
    private final ClienteID clienteId;
    private final Tipo tipo;

    public AgregarTipoCliente(TipoClienteID tipoClienteID,ClienteID clienteId ,Tipo tipo) {
        this.clienteId = clienteId;
        this.tipoClienteID = tipoClienteID;
        this.tipo = tipo;
    }

    public TipoClienteID getTipoClienteID() {
        return tipoClienteID;
    }

    public ClienteID getClienteId() {
        return clienteId;
    }

    public Tipo getTipo() {
        return tipo;
    }

}
