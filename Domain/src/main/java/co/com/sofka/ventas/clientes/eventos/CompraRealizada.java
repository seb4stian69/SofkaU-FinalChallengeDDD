package co.com.sofka.ventas.clientes.eventos;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.ventas.almacen.objetosvalor.AlmacenID;
import co.com.sofka.ventas.almacen.objetosvalor.ProductoID;
import co.com.sofka.ventas.clientes.objetosvalor.ClienteID;
import co.com.sofka.ventas.clientes.objetosvalor.FechaCompra;

public class CompraRealizada extends DomainEvent {

    private final ClienteID clienteId;
    private final FechaCompra fechaCompra;
    private final AlmacenID almacenID;
    private final ProductoID productoId;

    public CompraRealizada(ClienteID clienteId, FechaCompra fechaCompra, AlmacenID almacenID, ProductoID productoId) {
        super("co.com.sofka.ventas.CompraRealizada");
        this.clienteId = clienteId;
        this.fechaCompra = fechaCompra;
        this.almacenID = almacenID;
        this.productoId = productoId;
    }

    public ClienteID getClienteId() {
        return clienteId;
    }

    public FechaCompra getFechaCompra() {
        return fechaCompra;
    }

    public AlmacenID getAlmacenID() {
        return almacenID;
    }

    public ProductoID getProductoId() {
        return productoId;
    }

}
