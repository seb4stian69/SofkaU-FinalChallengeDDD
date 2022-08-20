package co.com.sofka.ventas.clientes.comandos;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.ventas.clientes.objetosvalor.ClienteID;
import co.com.sofka.ventas.clientes.objetosvalor.FechaCompra;

public class AgregarCliente extends Command {

    private ClienteID clienteid;
    private final FechaCompra fechaCompra;

    public AgregarCliente(FechaCompra fechaCompra, ClienteID clienteid) {
        this.clienteid = clienteid;
        this.fechaCompra = fechaCompra;
    }

    public ClienteID getClienteid() {
        return clienteid;
    }

    public FechaCompra getFechaCompra() {
        return fechaCompra;
    }

}
