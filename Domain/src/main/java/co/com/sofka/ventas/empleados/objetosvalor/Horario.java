package co.com.sofka.ventas.empleados.objetosvalor;

import co.com.sofka.domain.generic.ValueObject;

import java.sql.Time;
import java.util.Date;

public class Horario implements ValueObject<Horario.Props> {
    private final Time Hora;
    private final Date Fecha;

    public Horario(Time Hora, Date Fecha) {
        this.Hora = Hora;
        this.Fecha = Fecha;
    }

    @Override
    public Props value() {
        return new Props(){
            @Override
            public Time Hora() {
                return Hora;
            }

            @Override
            public Date Fecha() {
                return Fecha;
            }
        };
    }

    public interface Props {
        Time Hora();
        Date Fecha();
    }

}
