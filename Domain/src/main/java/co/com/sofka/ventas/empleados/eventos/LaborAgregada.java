package co.com.sofka.ventas.empleados.eventos;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.ventas.empleados.objetosvalor.Horario;
import co.com.sofka.ventas.empleados.objetosvalor.LaborID;
import co.com.sofka.ventas.empleados.objetosvalor.Tipo;

public class LaborAgregada extends DomainEvent {

    private final LaborID laborID;
    private final Tipo tipo;
    private final Horario horario;

    public LaborAgregada(LaborID laborID, Tipo tipo, Horario horario) {
        super("co.com.sofka.ventas.LaborAgregada");
        this.laborID = laborID;
        this.tipo = tipo;
        this.horario = horario;
    }

    public LaborID getLaborID() {
        return laborID;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public Horario getHorario() {
        return horario;
    }

}
