package co.com.sofka.ventas.clientes;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.ventas.clientes.entidades.DatosPersonales;
import co.com.sofka.ventas.clientes.entidades.TipoCliente;
import co.com.sofka.ventas.clientes.eventos.ClienteAgregado;
import co.com.sofka.ventas.clientes.eventos.CompraRealizada;
import co.com.sofka.ventas.clientes.eventos.DatosPersonalesAgregados;
import co.com.sofka.ventas.clientes.eventos.TipoClienteAgregado;

public class ClientesChange extends EventChange {

    public ClientesChange(Clientes cliente){

        apply((ClienteAgregado event) ->{
            cliente.fechaCompra = event.getFechaCompra();
        });

        apply((DatosPersonalesAgregados event)->{
            cliente.datosPersonales = new DatosPersonales(event.getDatosPersonalesId(),event.getNombre(),event.getNumeroTelefono());
        });

        apply((TipoClienteAgregado event)->{
            cliente.tipoCliente = new TipoCliente(event.getTipoClienteID(),event.getTipo());
        });

    }

}
