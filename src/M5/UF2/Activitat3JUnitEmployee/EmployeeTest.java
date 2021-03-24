package M5.UF2.Activitat3JUnitEmployee;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {
    @Test
    public void empleados_iguales() {
        Employee t1 = new Employee(1, "Raul", 5000);
        Employee t2 = new Employee(1, "Raul", 5000);
        assertTrue(t1.equals(t2));
    }

    @Test
    public void empleados_iguales_ignora_mayusculas_y_minusculas(){
        Employee t1 = new Employee(1, "Raul", 5000);
        Employee t2 = new Employee(1, "raul", 5000);
        assertTrue(t1.equals(t2));
    }

    @Test
    public void nombre_diferente() {
        Employee t1 = new Employee(1, "Raul", 5000);
        Employee t2 = new Employee(1, "Ramon", 5000);
        assertFalse(t1.equals(t2));
    }

    @Test
    public void salario_diferente() {
        Employee t1 = new Employee(1, "Raul", 5000);
        Employee t2 = new Employee(1, "Raul", 500);
        assertFalse(t1.equals(t2));
    }

    @Test
    public void id_diferente() {
        Employee t1 = new Employee(1, "Raul", 100);
        Employee t2 = new Employee(2, "Raul", 100);
        assertFalse(t1.equals(t2));
    }
}

