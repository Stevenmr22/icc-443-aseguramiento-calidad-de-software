package services;

import org.example.enums.TipoEmpleado;
import org.example.model.Empleado;
import org.junit.jupiter.api.*;

import java.util.List;

import static java.lang.Math.min;

public class ServicioNominaTest {

    static List<Empleado> empleados;

    @BeforeEach
    void setUpEmpleados(TestInfo testInfo) {
        if(testInfo.getDisplayName().equals("testCalcularNominaSinHorasExtras")) {
            empleados = List.of(
                    new Empleado("Juan", "Pérez", 20.0f, 40, TipoEmpleado.FULL_TIME),
                    new Empleado("Ana", "Gómez", 15.0f, 30, TipoEmpleado.FULL_TIME),
                    new Empleado("Luis", "Martínez", 25.0f, 35, TipoEmpleado.FULL_TIME)
            );
        } else if(testInfo.getDisplayName().equals("testCalcularNominaConHorasExtras")) {
            empleados = List.of(
                    new Empleado("Juan", "Pérez", 20.0f, 40, TipoEmpleado.FULL_TIME),
                    new Empleado("Ana", "Gómez", 15.0f, 45, TipoEmpleado.PART_TIME),
                    new Empleado("Luis", "Martínez", 25.0f, 50, TipoEmpleado.FULL_TIME)
            );
        } else {
            empleados = List.of(
                    new Empleado("Juan", "Pérez", 20.0f, 42, TipoEmpleado.PART_TIME),
                    new Empleado("Ana", "Gómez", 15.0f, 45, TipoEmpleado.PART_TIME),
                    new Empleado("Luis", "Martínez", 25.0f, 30, TipoEmpleado.PART_TIME)
            );
        }
    }

    private long empleadosConBono (List<Empleado> empleados) {

        return empleados.stream()
                .filter(empleado -> empleado.getHorasTrabajadas() > 38 && empleado.getTipoEmpleado() == TipoEmpleado.FULL_TIME)
                .count();
    }

    @Test
    void testCalcularNominaSinHorasExtras() {

        long empleadosConBono = empleadosConBono(empleados);

        float totalNomina = empleados.stream()
                .map(empleado -> empleado.getTarifa() * empleado.getHorasTrabajadas())
                .reduce(0.0f, Float::sum);

        totalNomina += empleadosConBono * 500.0f;

        Assertions.assertEquals (totalNomina,  );
    }

    @Test

    void testCalcularNominaConHorasExtras() {

        float calculoHorasExtras = empleados.stream()
                .filter(empleado -> empleado.getHorasTrabajadas() > 40 && empleado.getTipoEmpleado() == TipoEmpleado.FULL_TIME)
                .map(empleado -> (empleado.getHorasTrabajadas() - 40) * empleado.getTarifa() * 1.5f)
                .reduce(0.0f, Float::sum);

        long empleadosConBono = empleadosConBono(empleados);

        float totalNomina = empleados.stream()
                .map(empleado -> empleado.getTarifa() * min(empleado.getHorasTrabajadas(), 40))
                .reduce(0.0f, Float::sum);

        totalNomina += (empleadosConBono * 500.0f) + calculoHorasExtras;

        Assertions.assertEquals(totalNomina,  );
    }


}
