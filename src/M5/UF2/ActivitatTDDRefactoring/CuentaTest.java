package M5.UF2.ActivitatTDDRefactoring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CuentaTest {

    @Test
    public void crear_cuenta(){
        Cuenta cuenta = new Cuenta();
        assertEquals(0, cuenta.saldo());
    }

    // INGRESAR
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
    @Test
    public void ingressar_6000_compteBuit(){
        Cuenta cuenta = new Cuenta();
        cuenta.ingresar(6000);
        assertEquals(6000, cuenta.saldo());
    }
    @Test
    public void ingressar_6000coma01_compteBuit(){
        Cuenta cuenta = new Cuenta();
        cuenta.ingresar(6000.01);
        assertEquals(0, cuenta.saldo());
    }

    // RETIRAR
    @Test
    public void retirar_100_compte_amb_500(){
        Cuenta cuenta = new Cuenta();
        cuenta.ingresar(500);
        cuenta.retirar(100);
        assertEquals(400, cuenta.saldo());
    }
    @Test
    public void retirar_500_compte_amb_200(){
        Cuenta cuenta = new Cuenta();
        cuenta.ingresar(200);
        cuenta.retirar(500);
        assertEquals(200, cuenta.saldo());
    }
    @Test
    public void retirar_100negatiu_compte_amb_500(){
        Cuenta cuenta = new Cuenta();
        cuenta.ingresar(500);
        cuenta.retirar(-100);
        assertEquals(500, cuenta.saldo());
    }
    @Test
    public void retirar_100coma45_compte_amb_500(){
        Cuenta cuenta = new Cuenta();
        cuenta.ingresar(500);
        cuenta.retirar(100.45);
        assertEquals(399.55, cuenta.saldo());
    }
    @Test
    public void retirar_100coma457_compte_amb_500(){
        Cuenta cuenta = new Cuenta();
        cuenta.ingresar(500);
        cuenta.retirar(100.457);
        assertEquals(500, cuenta.saldo());
    }
    @Test
    public void retirar_6000_compte_amb_7000(){
        Cuenta cuenta = new Cuenta();
        cuenta.ingresar(3000);
        cuenta.ingresar(4000);
        cuenta.retirar(6000);
        assertEquals(1000, cuenta.saldo());
    }
    @Test
    public void retirar_6000coma01_compte_amb_7000(){
        Cuenta cuenta = new Cuenta();
        cuenta.ingresar(3000);
        cuenta.ingresar(4000);
        cuenta.retirar(6000.01);
        assertEquals(7000, cuenta.saldo());
    }

    // TRANSFERENCIES
    @Test
    public void transferir_100_compte_amb_500_a_compte_amb_50(){
        Cuenta emisor = new Cuenta();
        Cuenta receptor = new Cuenta();
        emisor.ingresar(500);
        receptor.ingresar(50);

        emisor.transferir(100, receptor);
        assertEquals(400, emisor.saldo());
        assertEquals(150, receptor.saldo());
    }
    @Test
    public void transferir_100negatius_compte_amb_500_a_compte_amb_50(){
        Cuenta emisor = new Cuenta();
        Cuenta receptor = new Cuenta();
        emisor.ingresar(500);
        receptor.ingresar(50);

        emisor.transferir(-100, receptor);
        assertEquals(500, emisor.saldo());
        assertEquals(50, receptor.saldo());
    }
    @Test
    public void transferir_3000_compte_amb_3500_a_compte_amb_50(){
        Cuenta emisor = new Cuenta();
        Cuenta receptor = new Cuenta();
        emisor.ingresar(3500);
        receptor.ingresar(50);

        emisor.transferir(3000, receptor);
        assertEquals(500, emisor.saldo());
        assertEquals(3050, receptor.saldo());
    }
    @Test
    public void transferir_3000coma01_compte_amb_3500_a_compte_amb_50() {
        Cuenta emisor = new Cuenta();
        Cuenta receptor = new Cuenta();
        emisor.ingresar(3500);
        receptor.ingresar(50);

        emisor.transferir(3000.01, receptor);
        assertEquals(3500, emisor.saldo());
        assertEquals(50, receptor.saldo());
    }
    @Test
    public void transferir_2000_compte_amb_3500_a_compte_amb_50_i_despres_transferir_1200_mes(){
        Cuenta emisor = new Cuenta();
        Cuenta receptor = new Cuenta();
        emisor.ingresar(3500);
        receptor.ingresar(50);

        emisor.transferir(2000, receptor);
        emisor.transferir(1200, receptor);
        assertEquals(1500, emisor.saldo());
        assertEquals(2050, receptor.saldo());
    }
}