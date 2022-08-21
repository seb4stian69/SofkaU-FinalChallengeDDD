package co.com.sofka.ventas.clientes.comandos;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.ventas.clientes.objetosvalor.ClienteID;
import co.com.sofka.ventas.clientes.objetosvalor.Tipo;
import co.com.sofka.ventas.clientes.objetosvalor.TipoClienteID;

public class AgregarTipoCliente extends Command {

    private final ClienteID clienteid;
    private final TipoClienteID tipoClienteID;
    private final Tipo tipo;

    public AgregarTipoCliente(ClienteID clienteid,TipoClienteID tipoClienteID,Tipo tipo) {
        this.clienteid = clienteid;
        this.tipoClienteID = tipoClienteID;
        this.tipo = tipo;
    }

    public ClienteID getClienteid() {
        return clienteid;
    }

    public TipoClienteID getTipoClienteID() {
        return tipoClienteID;
    }

    public Tipo getTipo() {
        return tipo;
    }

}
