package M3.UF5.NF4.Activitat16.Interficies.Clases;

import M3.UF5.NF4.Activitat16.Interficies.Interficies.Valida;

public class Fecha implements Comparable, Valida {

    private int any;
    private int mes;
    private int dia;

    public Fecha(int any, int mes, int dia) {
        this.any = any;
        this.mes = mes;
        this.dia = dia;
    }

    @Override
    public boolean check() {
        boolean valido = false;

        if (this.any > 1920 && this.any < 2020
                && this.mes > 0 && this.mes < 12
                && this.dia > 0 && this.dia < 31) {
            valido = true;
        } else {
            valido = false;
        }
        return valido;
    }

    @Override
    public int compareTo(Object o) {

        int devuelve;

        Fecha otro = (Fecha) o;

        if (this.any == otro.any){
            if (this.mes == otro.mes){
                if (this.dia == otro.dia){
                    devuelve = 0;
                } else {
                    devuelve = this.dia - otro.dia;
                }
            } else {
                devuelve = this.mes - otro.mes;
            }
        } else {
            devuelve = this.any - otro.any;
        }

        return devuelve;
    }

    @Override
    public String toString() {
        return "Fecha: " + dia + "/" + mes + "/" + any;
    }
}
