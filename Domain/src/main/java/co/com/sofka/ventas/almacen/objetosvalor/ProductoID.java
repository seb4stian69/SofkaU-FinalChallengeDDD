package co.com.sofka.ventas.almacen.objetosvalor;

import co.com.sofka.domain.generic.Identity;

public class ProductoID extends Identity {
    public ProductoID (String id) {
        super(id);
    }

    public static ProductoID of(String id){
        return new ProductoID(id);
    }

}
