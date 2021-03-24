package M5.UF2.Activitat2TDDRefactoring;

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
        M5.UF2.Activitat2TDDRefactoring.Cuenta cuenta = new M5.UF2.Activitat2TDDRefactoring.Cuenta();
        cuenta.ingresar(10000);
        assertEquals(10000, cuenta.saldo());
    }
    @Test
    public void ingressar_3000_compteBuit(){
        M5.UF2.Activitat2TDDRefactoring.Cuenta cuenta = new M5.UF2.Activitat2TDDRefactoring.Cuenta();
        cuenta.ingresar(300000);
        assertEquals(300000, cuenta.saldo());
    }
    @Test
    public void ingressar_3000_compteAmb100(){
        M5.UF2.Activitat2TDDRefactoring.Cuenta cuenta = new M5.UF2.Activitat2TDDRefactoring.Cuenta();
        cuenta.ingresar(10000);
        cuenta.ingresar(300000);
        assertEquals(310000, cuenta.saldo());
    }
    @Test
    public void ingressar_100Negativo_compteBuit(){
        M5.UF2.Activitat2TDDRefactoring.Cuenta cuenta = new M5.UF2.Activitat2TDDRefactoring.Cuenta();
        cuenta.ingresar(-10000);
        assertEquals(0, cuenta.saldo());
    }
    @Test
    public void ingressar_6000_compteBuit(){
        M5.UF2.Activitat2TDDRefactoring.Cuenta cuenta = new M5.UF2.Activitat2TDDRefactoring.Cuenta();
        cuenta.ingresar(600000);
        assertEquals(600000, cuenta.saldo());
    }
    @Test
    public void ingressar_6000coma01_compteBuit(){
        M5.UF2.Activitat2TDDRefactoring.Cuenta cuenta = new M5.UF2.Activitat2TDDRefactoring.Cuenta();
        cuenta.ingresar(600001);
        assertEquals(0, cuenta.saldo());
    }
    // RETIRAR
    @Test
    public void retirar_100_compte_amb_500(){
        M5.UF2.Activitat2TDDRefactoring.Cuenta cuenta = new M5.UF2.Activitat2TDDRefactoring.Cuenta();
        cuenta.ingresar(50000);
        cuenta.retirar(10000);
        assertEquals(40000, cuenta.saldo());
    }
    @Test
    public void retirar_500_compte_amb_200(){
        M5.UF2.Activitat2TDDRefactoring.Cuenta cuenta = new M5.UF2.Activitat2TDDRefactoring.Cuenta();
        cuenta.ingresar(20000);
        cuenta.retirar(50000);
        assertEquals(20000, cuenta.saldo());
    }
    @Test
    public void retirar_100negatiu_compte_amb_500(){
        M5.UF2.Activitat2TDDRefactoring.Cuenta cuenta = new M5.UF2.Activitat2TDDRefactoring.Cuenta();
        cuenta.ingresar(50000);
        cuenta.retirar(-10000);
        assertEquals(50000, cuenta.saldo());
    }
    @Test
    public void retirar_6000_compte_amb_7000(){
        M5.UF2.Activitat2TDDRefactoring.Cuenta cuenta = new M5.UF2.Activitat2TDDRefactoring.Cuenta();
        cuenta.ingresar(300000);
        cuenta.ingresar(400000);
        cuenta.retirar(600000);
        assertEquals(100000, cuenta.saldo());
    }
    @Test
    public void retirar_6000coma01_compte_amb_7000(){
        M5.UF2.Activitat2TDDRefactoring.Cuenta cuenta = new M5.UF2.Activitat2TDDRefactoring.Cuenta();
        cuenta.ingresar(300000);
        cuenta.ingresar(400000);
        cuenta.retirar(600001);
        assertEquals(700000, cuenta.saldo());
    }
    // TRANSFERENCIES
    @Test
    public void transferir_100_compte_amb_500_a_compte_amb_50(){
        M5.UF2.Activitat2TDDRefactoring.Cuenta emisor = new M5.UF2.Activitat2TDDRefactoring.Cuenta();
        M5.UF2.Activitat2TDDRefactoring.Cuenta receptor = new M5.UF2.Activitat2TDDRefactoring.Cuenta();
        emisor.ingresar(50000);
        receptor.ingresar(5000);

        emisor.transferir(10000, receptor);
        assertEquals(40000, emisor.saldo());
        assertEquals(15000, receptor.saldo());
    }
    @Test
    public void transferir_100negatius_compte_amb_500_a_compte_amb_50(){
        M5.UF2.Activitat2TDDRefactoring.Cuenta emisor = new M5.UF2.Activitat2TDDRefactoring.Cuenta();
        M5.UF2.Activitat2TDDRefactoring.Cuenta receptor = new M5.UF2.Activitat2TDDRefactoring.Cuenta();
        emisor.ingresar(50000);
        receptor.ingresar(5000);

        emisor.transferir(-10000, receptor);
        assertEquals(50000, emisor.saldo());
        assertEquals(5000, receptor.saldo());
    }
    @Test
    public void transferir_3000_compte_amb_3500_a_compte_amb_50(){
        M5.UF2.Activitat2TDDRefactoring.Cuenta emisor = new M5.UF2.Activitat2TDDRefactoring.Cuenta();
        M5.UF2.Activitat2TDDRefactoring.Cuenta receptor = new M5.UF2.Activitat2TDDRefactoring.Cuenta();
        emisor.ingresar(350000);
        receptor.ingresar(5000);

        emisor.transferir(300000, receptor);
        assertEquals(50000, emisor.saldo());
        assertEquals(305000, receptor.saldo());
    }
    @Test
    public void transferir_3000coma01_compte_amb_3500_a_compte_amb_50() {
        M5.UF2.Activitat2TDDRefactoring.Cuenta emisor = new M5.UF2.Activitat2TDDRefactoring.Cuenta();
        M5.UF2.Activitat2TDDRefactoring.Cuenta receptor = new M5.UF2.Activitat2TDDRefactoring.Cuenta();
        emisor.ingresar(350000);
        receptor.ingresar(5000);

        emisor.transferir(300001, receptor);
        assertEquals(350000, emisor.saldo());
        assertEquals(5000, receptor.saldo());
    }
    @Test
    public void transferir_2000_compte_amb_3500_a_compte_amb_50_i_despres_transferir_1200_mes(){
        M5.UF2.Activitat2TDDRefactoring.Cuenta emisor = new M5.UF2.Activitat2TDDRefactoring.Cuenta();
        M5.UF2.Activitat2TDDRefactoring.Cuenta receptor = new M5.UF2.Activitat2TDDRefactoring.Cuenta();
        emisor.ingresar(350000);
        receptor.ingresar(5000);

        emisor.transferir(200000, receptor);
        emisor.transferir(120000, receptor);
        assertEquals(150000, emisor.saldo());
        assertEquals(205000, receptor.saldo());
    }
}