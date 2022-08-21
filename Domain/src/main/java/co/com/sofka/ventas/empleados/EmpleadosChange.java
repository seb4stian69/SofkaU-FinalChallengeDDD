package co.com.sofka.ventas.empleados;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.ventas.empleados.entidades.DatosPersonales;
import co.com.sofka.ventas.empleados.entidades.Labor;
import co.com.sofka.ventas.empleados.eventos.*;

public class EmpleadosChange extends EventChange {

    public EmpleadosChange(Empleados empleados) {

        apply((EmpleadoAgregado event)->{
            empleados.almacen = event.getAlmacen();
        });

        apply((DatosPersonalesAgregados event)->{
            empleados.datosPersonales = new DatosPersonales(event.getDatosPersonalesId(),event.getNombre(),event.getMedioPago(),event.getSalario());
        });

        apply((DatosPersonalesActualizados event)->{
            empleados.datosPersonales = new DatosPersonales(event.getDatosPersonalesId(),event.getNombre(),event.getMedioPago(),event.getSalario());
        });

        apply((LaborAgregada event)->{
            empleados.labor = new Labor(event.getLaborID(),event.getTipo(),event.getHorario());
        });

        apply((LaborActualizada event)->{
            empleados.labor = new Labor(event.getLaborID(),event.getTipo(),event.getHorario());
        });

    }

}
