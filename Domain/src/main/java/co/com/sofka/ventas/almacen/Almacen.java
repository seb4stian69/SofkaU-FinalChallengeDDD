package co.com.sofka.ventas.almacen;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.ventas.almacen.entidades.Productos;
import co.com.sofka.ventas.almacen.entidades.Ubicacion;
import co.com.sofka.ventas.almacen.eventos.AlmacenCreado;
import co.com.sofka.ventas.almacen.eventos.ProductoAgregado;
import co.com.sofka.ventas.almacen.eventos.UbicacionAgregada;
import co.com.sofka.ventas.almacen.objetosvalor.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Almacen extends AggregateEvent<AlmacenID> {

    protected Especializacion especializacion;
    protected Ubicacion ubicacion;
    protected Set<Productos> productos;

    public Almacen(AlmacenID almacenID, Especializacion especializacion) {
        super(almacenID);
        appendChange(new AlmacenCreado(especializacion));
    }

    private Almacen(AlmacenID almacenID){
        super(almacenID);
        subscribe(new AlmacenChange(this));
    }

    public static Almacen from(AlmacenID almacenID, List<DomainEvent> events){
        var almacen= new Almacen(almacenID);
        events.forEach(almacen::applyEvent);
        return almacen;
    }

    // Comportamientos
    public void agregarUbicaciones(UbicacionID ubicacionID, Direccion direccion, Ciudad ciudad){
        Objects.requireNonNull(ubicacionID);
        Objects.requireNonNull(direccion);
        Objects.requireNonNull(ciudad);
        appendChange(new UbicacionAgregada(ubicacionID, direccion, ciudad));
    }

    public void agregarProducto(ProductoID productoID, TipoProducto tipoProducto, PrecioProducto precioProducto){
        Objects.requireNonNull(productoID);
        Objects.requireNonNull(tipoProducto);
        Objects.requireNonNull(precioProducto);
        appendChange(new ProductoAgregado(productoID,tipoProducto,precioProducto));
    }

}
