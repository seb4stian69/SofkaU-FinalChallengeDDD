package co.com.sofka.ventas.clientes;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.ventas.almacen.objetosvalor.AlmacenID;
import co.com.sofka.ventas.almacen.objetosvalor.ProductoID;
import co.com.sofka.ventas.clientes.entidades.DatosPersonales;
import co.com.sofka.ventas.clientes.entidades.TipoCliente;
import co.com.sofka.ventas.clientes.eventos.ClienteAgregado;
import co.com.sofka.ventas.clientes.eventos.CompraRealizada;
import co.com.sofka.ventas.clientes.eventos.DatosPersonalesAgregados;
import co.com.sofka.ventas.clientes.eventos.TipoClienteAgregado;
import co.com.sofka.ventas.clientes.objetosvalor.*;

import java.util.List;
import java.util.Objects;

public class Clientes extends AggregateEvent<ClienteID> {

    protected FechaCompra fechaCompra;
    protected DatosPersonales datosPersonales;
    protected TipoCliente tipoCliente;

    public Clientes(ClienteID clienteID, FechaCompra fechaCompra) {
        super(clienteID);
        appendChange(new ClienteAgregado(fechaCompra));
    }

    private Clientes(ClienteID clienteID){
        super(clienteID);
        subscribe(new ClientesChange(this));
    }

    public static Clientes from(ClienteID clienteID, List<DomainEvent> events){
        var cliente = new Clientes(clienteID);
        events.forEach(cliente::applyEvent);
        return cliente;
    }

    // Comportamientos
    public void AgregarDatosPersonales(DatosPersonalesID datosPersonalesId, Nombre nombre, NumeroTelefono numeroTelefono){
        Objects.requireNonNull(datosPersonalesId);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(numeroTelefono);
        appendChange(new DatosPersonalesAgregados(datosPersonalesId,nombre,numeroTelefono));
    }

    public void AgregarTipoCliente(TipoClienteID tipoClienteID,Tipo tipo){
        Objects.requireNonNull(tipoClienteID);
        Objects.requireNonNull(tipo);
        appendChange(new TipoClienteAgregado(tipoClienteID,tipo));
    }

    public void RealizarCompra(ClienteID clienteId, FechaCompra fechaCompra, AlmacenID almacenID, ProductoID productoId){
        Objects.requireNonNull(clienteId);
        Objects.requireNonNull(fechaCompra);
        Objects.requireNonNull(almacenID);
        Objects.requireNonNull(productoId);
        appendChange(new CompraRealizada(clienteId,fechaCompra,almacenID,productoId));
    }

}
