package co.com.sofka.ventas.almacen;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.ventas.almacen.entidades.Productos;
import co.com.sofka.ventas.almacen.entidades.Ubicacion;
import co.com.sofka.ventas.almacen.eventos.AlmacenCreado;
import co.com.sofka.ventas.almacen.eventos.ProductoAgregado;
import co.com.sofka.ventas.almacen.eventos.UbicacionAgregada;

public class AlmacenChange extends EventChange {
    public AlmacenChange(Almacen almacen){

        apply((AlmacenCreado event)->{
            almacen.especializacion = event.getEspecializacion();
        });

        apply((ProductoAgregado event)->{
           almacen.productos.add(new Productos(event.getProductoId(),event.getTipoProducto(), event.getPrecioProducto()));
        });

        apply((UbicacionAgregada event)->{
           almacen.ubicacion = new Ubicacion(event.getUbicacionID(),event.getDireccion(),event.getCiudad());
        });

    }

}
