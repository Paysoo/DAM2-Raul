package M5.UF2.Examen;

public class Compte {
    private int saldo;
    private String contrasenya;

    // Constructor
    public Compte(int saldoInicial, String cs) {
        this.saldo = saldoInicial;
        this.contrasenya = cs;
    }

    /**
     * METODO PARA DEPOSITAR DINERO
     * @param pasta
     * @return SALDO
     */
    // Rebem els de diners
    public int diposita(int pasta) {
        this.saldo += pasta;
        return saldo;
    }

    /**
     * METODO PARA RETIRAR DINERO
     * @param pasta
     * @param cs
     * @return [IF - RETIRO] || [ELSE IF - RETIRO > SALDO] || [ELSE - CONTRASENYA INCORRECTA]
     */
    // Si la contrasenya és correcta i tenim prou diners, els restem del saldo i
    // retornem el valor de la pasta que hem retirat.
    // Si no tenim prou saldo, retornem un -1.
    // Si la contrasenya no és correcte, retornem un -2.
    public int retira(int pasta, String cs) {
        if (pasta <= saldo && cs.equals(contrasenya)) {
            this.saldo -= pasta;
            return pasta;
        } else if (pasta > saldo) {
            return -1;
        } else return -2;
    }

    /**
     * GETTER QUE DEVUELVE EL SALDO DE LA CUENTA
     * @return SALDO
     */
    // Retornem el saldo
    public int getSaldo() {
        return saldo;
    }

    /**
     * GETTER QUE DEVUELVE LA CONTRASENYA
     * @return CONTRASENYA
     */
    // Retornem la contrasenya
    public String getContrasenya() {
        return contrasenya;
    }

}