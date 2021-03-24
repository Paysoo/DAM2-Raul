package M5.UF2.Activitat2TDDRefactoring;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Cuenta {

    private int amount;
    static final int INGRESO_MAXIMO = 600000;
    static final int RETIRADA_MAXIMA = 600000;
    static final int TRANSFERENCIA_MAXIMA = 300000;
    private int tranferenciaHecha;
    private String ultimaTransferencia = "000000";

    public Cuenta() {
    }

    public int saldo() {

        return this.amount;
    }

    public void ingresar(int ingreso) {
        if (ingreso > 0 && ingreso <= INGRESO_MAXIMO) {
            this.amount += ingreso;
        }
    }

    public void retirar(int retiro) {
        if (this.amount >= retiro && retiro > 0 && retiro <= RETIRADA_MAXIMA) {
            this.amount -= retiro;
        }
    }

    public void transferir(int transferencia, Cuenta receptor) {

        if (transferencia > 0 && transferencia <= TRANSFERENCIA_MAXIMA) {
            if (this.ultimaTransferencia.equals(fecha())) {
                if (this.tranferenciaHecha + transferencia <= TRANSFERENCIA_MAXIMA) {
                    receptor.ingresar(transferencia);
                    this.retirar(transferencia);
                    this.tranferenciaHecha += transferencia;
                    this.ultimaTransferencia = fecha();
                }
            } else {
                this.tranferenciaHecha = 0;
                receptor.ingresar(transferencia);
                this.retirar(transferencia);
                this.tranferenciaHecha += transferencia;
                this.ultimaTransferencia = fecha();
            }

        }
    }


    private String fecha(){
        String data = "";

        Calendar c = new GregorianCalendar();

        String dia = Integer.toString(c.get(Calendar.DATE));
        String mes = Integer.toString(c.get(Calendar.MONTH));
        String annio = Integer.toString(c.get(Calendar.YEAR));

        data = dia+mes+annio;

        return data;
    }
}
