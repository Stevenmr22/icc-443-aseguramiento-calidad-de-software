package org.example.services;

import org.example.enums.TipoEmpleado;
import org.example.model.Empleado;
import org.example.exception.SalarioExcedidoException;

import java.util.List;

import static java.lang.Math.min;

public class ServicioNomina {

    private float calcularHorasExtras(Empleado empleado) {
        if (empleado.getHorasTrabajadas() <= 40 || empleado.getTipoEmpleado() == TipoEmpleado.PART_TIME) {
            return 0.0f;
        }
        float horasExtras = empleado.getHorasTrabajadas() - 40;
        return horasExtras * empleado.getTarifa() * 1.5f;
    }

    private float calcularBono (Empleado empleado) {
        if (empleado.getTipoEmpleado() == TipoEmpleado.FULL_TIME && empleado.getHorasTrabajadas() > 38) {
            return 500.0f;
        }
        return 0.0f;
    }

    private float calcularSalarioBase(Empleado empleado) {
        if (empleado.getTipoEmpleado() == TipoEmpleado.PART_TIME) {
            return empleado.getTarifa() * empleado.getHorasTrabajadas();
        }
        return empleado.getTarifa() * min(empleado.getHorasTrabajadas(), 40);
    }

    public float calculoNomina (List<Empleado> empleados){

        float totalNomina = 0.0f;

        for (Empleado empleado : empleados) {
            if (empleado == null) {
                throw new IllegalArgumentException("Empleado no puede ser nulo");
            }
            if (empleado.getHorasTrabajadas() < 0) {
                throw new IllegalArgumentException("Las horas trabajadas no pueden ser negativas");
            }

            float horasExtras = calcularHorasExtras(empleado);
            float salarioBase = calcularSalarioBase(empleado);
            float bono = calcularBono(empleado);

            float salarioTotal = salarioBase + bono + horasExtras;

            if (salarioTotal > 20000.0f) {
                throw new SalarioExcedidoException ("El salario total no puede ser mayor a 20,000");
            }
            totalNomina += salarioBase + bono + horasExtras;
        }

        return totalNomina;

    }

}
