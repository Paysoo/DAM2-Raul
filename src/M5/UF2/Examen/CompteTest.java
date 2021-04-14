package M5.UF2.Examen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompteTest {

    @Test
    public void crear_cuenta(){
        Compte compte = new Compte(0, "alumne");
        assertEquals(0, compte.getSaldo());
    }

    // DIPOSITAR
    @Test
    public void dipositar_100(){
        Compte compte = new Compte(0, "alumne");
        compte.diposita(100);
        assertEquals(100, compte.getSaldo());
    }

    // RETIRAR
    @Test
    public void retirar_100_saldo_100(){
        Compte compte = new Compte(0, "alumne");
        compte.retira(100, "alumne");
        assertEquals(0, compte.getSaldo());
    }
    @Test
    public void retirar_100_saldo_0(){
        Compte compte = new Compte(0, "alumne");
        compte.retira(100, "alumne");
        assertEquals(0, compte.getSaldo());
    }
    @Test
    public void retirar_100_contrasneya_incorrecta(){
        Compte compte = new Compte(100, "alumne");
        compte.retira(100, "alumnesssss");
        assertEquals(100, compte.getSaldo());
    }
}