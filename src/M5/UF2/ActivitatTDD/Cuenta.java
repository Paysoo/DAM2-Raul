package M5.UF2.ActivitatTDD;

public class Cuenta {

    private double saldo;

    public Cuenta() {
    }

    public double saldo() {

        return this.saldo;
    }

    public void ingresar(double ingreso) {
        if (ingreso > 0 && tieneDosDecimales_o_Menos(ingreso)) {
            this.saldo += ingreso;
        }
    }

    private boolean tieneDosDecimales_o_Menos(double ingreso){

        return ingreso == Math.floor(ingreso * 100) / 100;

    }
}
