package co.com.sofka.ventas.clientes.comandos;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.ventas.clientes.objetosvalor.ClienteID;
import co.com.sofka.ventas.clientes.objetosvalor.DatosPersonalesID;
import co.com.sofka.ventas.clientes.objetosvalor.Nombre;
import co.com.sofka.ventas.clientes.objetosvalor.NumeroTelefono;

public class AgregarDatosPersonales extends Command {

    private final ClienteID clienteId;
    private final DatosPersonalesID datosPersonalesId;
    private final Nombre nombre;
    private final NumeroTelefono numeroTelefono;

    public AgregarDatosPersonales(ClienteID clienteId,DatosPersonalesID datosPersonalesId,Nombre nombre, NumeroTelefono numeroTelefono) {
        this.clienteId = clienteId;
        this.datosPersonalesId = datosPersonalesId;
        this.nombre = nombre;
        this.numeroTelefono = numeroTelefono;
    }

    public ClienteID getClienteId() {
        return clienteId;
    }

    public DatosPersonalesID getDatosPersonalesId() {
        return datosPersonalesId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public NumeroTelefono getNumeroTelefono() {
        return numeroTelefono;
    }

}
