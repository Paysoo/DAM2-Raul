package M5.UF2.ActivitatTDD;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CuentaTest {

    @Test
    public void crear_cuenta(){
        Cuenta cuenta = new Cuenta();
        assertEquals(0, cuenta.saldo());
    }

}