package co.com.sofka.ventas.empleados.comandos;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.ventas.empleados.objetosvalor.Horario;
import co.com.sofka.ventas.empleados.objetosvalor.LaborID;
import co.com.sofka.ventas.empleados.objetosvalor.Tipo;

public class AgregarLabor extends Command {

    private final LaborID laborID;
    private final Tipo tipo;
    private final Horario horario;

    public AgregarLabor(LaborID laborID, Tipo tipo, Horario horario) {
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
