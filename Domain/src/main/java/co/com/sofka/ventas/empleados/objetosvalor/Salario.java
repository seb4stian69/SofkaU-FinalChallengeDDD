package co.com.sofka.ventas.empleados.objetosvalor;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Salario implements ValueObject<Integer> {

    private final Integer totalSalario;

    public Salario(Integer totalSalario) {

        this.totalSalario = Objects.requireNonNull(totalSalario);

        if (this.totalSalario <= 0) {
            throw new IllegalArgumentException("Debe agregar correctamente un Salario");
        }

    }

    public static Salario of(Integer totalSalario) {
        return new Salario(totalSalario);
    }

    @Override
    public Integer value() {
        return totalSalario;
    }

}
