package co.com.sofka.ventas.clientes.objetosvalor;

import co.com.sofka.domain.generic.ValueObject;
import java.util.Date;
import java.util.Objects;

public class FechaCompra implements ValueObject<Date> {

    private final Date fechaCompra;

    public FechaCompra(Date fechaCompra) {
        this.fechaCompra = Objects.requireNonNull(fechaCompra);

        if (this.fechaCompra.getTime() <= 0) {
            throw new IllegalArgumentException("Debe agregar correctamente una fecha");
        }

    }

    public static FechaCompra of(Date fechaCompra) {
        return new FechaCompra(fechaCompra);
    }

    @Override
    public Date value() {
        return fechaCompra;
    }

}
