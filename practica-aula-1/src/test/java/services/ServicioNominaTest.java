package services;

import org.example.enums.TipoEmpleado;
import org.example.model.Empleado;
import org.example.services.ServicioNomina;
import org.junit.jupiter.api.*;
import org.example.exception.SalarioExcedidoException;

import java.util.List;

import static java.lang.Math.min;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ServicioNominaTest {

    static List<Empleado> empleados;

    @BeforeEach
    void setUpEmpleados(TestInfo testInfo) {
        if(testInfo.getDisplayName().equals("testCalcularNominaSinHorasExtras()")) {
            empleados = List.of(
                    new Empleado("Juan", "Pérez", 20.0f, 40, TipoEmpleado.FULL_TIME),
                    new Empleado("Ana", "Gómez", 15.0f, 30, TipoEmpleado.FULL_TIME),
                    new Empleado("Luis", "Martínez", 25.0f, 35, TipoEmpleado.FULL_TIME)
            );
        } else if(testInfo.getDisplayName().equals("testCalcularNominaConHorasExtras()")) {
            empleados = List.of(
                    new Empleado("Juan", "Pérez", 20.0f, 40, TipoEmpleado.FULL_TIME),
                    new Empleado("Ana", "Gómez", 15.0f, 45, TipoEmpleado.PART_TIME),
                    new Empleado("Luis", "Martínez", 25.0f, 50, TipoEmpleado.FULL_TIME)
            );
        } else if (testInfo.getDisplayName().equals("testCalcularNominaPartTime()")) {
            empleados = List.of(
                    new Empleado("Juan", "Pérez", 20.0f, 42, TipoEmpleado.PART_TIME),
                    new Empleado("Ana", "Gómez", 15.0f, 45, TipoEmpleado.PART_TIME),
                    new Empleado("Luis", "Martínez", 25.0f, 30, TipoEmpleado.PART_TIME)
            );
        } else if (testInfo.getDisplayName().equals("testHorasNegativas()")) {
            empleados = List.of(
                    new Empleado("Juan", "Pérez", 20.0f, 5, TipoEmpleado.FULL_TIME),
                    new Empleado("Ana", "Gómez", 15.0f, 10, TipoEmpleado.PART_TIME),
                    new Empleado("Luis", "Martínez", 25.0f, -3, TipoEmpleado.FULL_TIME)
            );
        } else if (testInfo.getDisplayName().equals("testValidarEmpleadoNulo()")) {
            empleados = List.of(
                    new Empleado("Juan", "Pérez", 20.0f, 40, TipoEmpleado.FULL_TIME),
                    new Empleado("Ana", "Gómez", 15.0f, 30, TipoEmpleado.PART_TIME),
                    null
            );
        } else if (testInfo.getDisplayName().equals("testValidarSalarioLimite()")) {
            empleados = List.of(
                    new Empleado("Juan", "Pérez", 20.0f, 40, TipoEmpleado.FULL_TIME),
                    new Empleado("Ana", "Gómez", 15.0f, 30, TipoEmpleado.PART_TIME),
                    new Empleado("Luis", "Martínez", 1000000.0f, 35, TipoEmpleado.FULL_TIME)
            );
        }
    }

    private long empleadosConBono (List<Empleado> empleados) {

        return empleados.stream()
                .filter(empleado -> empleado.getHorasTrabajadas() > 38 && empleado.getTipoEmpleado() == TipoEmpleado.FULL_TIME)
                .count();
    }

    private float calculoNomina (List<Empleado> empleados){
        return empleados.stream()
                .map(empleado -> {
                    if (empleado.getTipoEmpleado() == TipoEmpleado.PART_TIME) {
                        return empleado.getTarifa() * empleado.getHorasTrabajadas();
                    }
                    return empleado.getTarifa() * min(empleado.getHorasTrabajadas(), 40);
                } )
                .reduce(0.0f, Float::sum);
    }

    @Test
    void testCalcularNominaSinHorasExtras() {

        ServicioNomina servicioNomina = new ServicioNomina();

        long empleadosConBono = empleadosConBono(empleados);

        float totalNomina = calculoNomina (empleados) + (empleadosConBono * 500.0f);

        Assertions.assertEquals (totalNomina, servicioNomina.calculoNomina(empleados));
    }

    @Test
    void testCalcularNominaConHorasExtras() {

        ServicioNomina servicioNomina = new ServicioNomina();

        float calculoHorasExtras = empleados.stream()
                .filter(empleado -> empleado.getHorasTrabajadas() > 40 && empleado.getTipoEmpleado() == TipoEmpleado.FULL_TIME)
                .map(empleado -> (empleado.getHorasTrabajadas() - 40) * empleado.getTarifa() * 1.5f)
                .reduce(0.0f, Float::sum);

        long empleadosConBono = empleadosConBono(empleados);

        float totalNomina = calculoNomina (empleados) + (calculoHorasExtras) + (empleadosConBono * 500.0f);

        Assertions.assertEquals(totalNomina, servicioNomina.calculoNomina(empleados));
    }

    @Test
    void testCalcularNominaPartTime(){

        ServicioNomina servicioNomina = new ServicioNomina();

        float totalNomina = calculoNomina (empleados);

        Assertions.assertEquals(totalNomina, servicioNomina.calculoNomina(empleados));

    }

    @Test
    void testHorasNegativas(){

        ServicioNomina servicioNomina = new ServicioNomina();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            servicioNomina.calculoNomina(empleados);
        });

        Assertions.assertEquals("Las horas trabajadas no pueden ser negativas", exception.getMessage());
    }

    @Test
    void testValidarEmpleadoNulo(){

        ServicioNomina servicioNomina = new ServicioNomina();

        Exception exception = assertThrows(NullPointerException.class, () -> {
            servicioNomina.calculoNomina (empleados);
        });

        Assertions.assertEquals("El empleado no puede ser nulo", exception.getMessage());
    }

    @Test
    void testValidarSalarioLimite(){

        ServicioNomina servicioNomina = new ServicioNomina();

        Exception exception = assertThrows(SalarioExcedidoException.class, () -> {
            servicioNomina.calculoNomina(empleados);
        });

        Assertions.assertEquals("El salario total no puede ser mayor a 20,000", exception.getMessage());

    }


}
