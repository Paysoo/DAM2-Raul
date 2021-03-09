package M5.UF2.ActivitatTDD;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CuentaTest {

    @Test
    public void crear_cuenta(){
        Cuenta cuenta = new Cuenta();
        assertEquals(0, cuenta.saldo());
    }
    @Test
    public void ingresar_100_compteBuit() {
        Cuenta cuenta = new Cuenta();
        cuenta.ingresar(100);
        assertEquals(100, cuenta.saldo());
    }
    @Test
    public void ingressar_3000_compteBuit(){
        Cuenta cuenta = new Cuenta();
        cuenta.ingresar(3000);
        assertEquals(3000, cuenta.saldo());
    }
    @Test
    public void ingressar_3000_compteAmb100(){
        Cuenta cuenta = new Cuenta();
        cuenta.ingresar(100);
        cuenta.ingresar(3000);
        assertEquals(3100, cuenta.saldo());
    }
    @Test
    public void ingressar_100Negativo_compteBuit(){
        Cuenta cuenta = new Cuenta();
        cuenta.ingresar(-100);
        assertEquals(0, cuenta.saldo());
    }
    @Test
    public void ingressar_100coma45_compteBuit(){
        Cuenta cuenta = new Cuenta();
        cuenta.ingresar(100.45);
        assertEquals(100.45, cuenta.saldo());
    }
    @Test
    public void ingressar_100coma457_compteBuit(){
        Cuenta cuenta = new Cuenta();
        cuenta.ingresar(100.457);
        assertEquals(0, cuenta.saldo());
    }
}