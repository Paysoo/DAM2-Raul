package M5.UF2.ActivitatTDDRefactoring;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Cuenta {

    private int saldo;
    static final int INGRESO_MAXIMO = 6000;
    static final int RETIRADA_MAXIMA = 6000;
    static final int TRANSFERENCIA_MAXIMA = 3000;
    private double tranferenciaHecha;
    private String ultimaTransferencia = "0000";

    public Cuenta() {
    }

    public double saldo() {

        return this.saldo;
    }

    public void ingresar(double ingreso) {
        if (ingreso > 0 && tieneDosDecimales_o_Menos(ingreso) && ingreso <= INGRESO_MAXIMO) {
            this.saldo += ingreso;
        }
    }

    public void retirar(double retiro) {
        if (this.saldo >= retiro && retiro > 0 && tieneDosDecimales_o_Menos(retiro) && retiro <= RETIRADA_MAXIMA) {
            this.saldo -= retiro;
        }
    }

    public void transferir(double transferencia, Cuenta receptor) {

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

    private boolean tieneDosDecimales_o_Menos(double ingreso){

        return ingreso == Math.floor(ingreso * 100) / 100;

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
