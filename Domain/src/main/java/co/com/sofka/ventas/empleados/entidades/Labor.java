package co.com.sofka.ventas.empleados.entidades;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.ventas.empleados.objetosvalor.Horario;
import co.com.sofka.ventas.empleados.objetosvalor.LaborID;
import co.com.sofka.ventas.empleados.objetosvalor.Tipo;

public class Labor extends Entity<LaborID> {

    private final Tipo tipo;
    private final Horario horario;

    public Labor(LaborID entityId, Tipo tipo, Horario horario) {
        super(entityId);
        this.tipo = tipo;
        this.horario = horario;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public Horario getHorario() {
        return horario;
    }

}
