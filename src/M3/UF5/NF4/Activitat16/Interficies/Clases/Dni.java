package M3.UF5.NF4.Activitat16.Interficies.Clases;

import M3.UF5.NF4.Activitat16.Interficies.Interficies.Valida;

public class Dni implements Comparable, Valida {

    private int numero;
    private char letra;

    public Dni(int numero, char letra) {
        this.numero = numero;
        this.letra = letra;
    }

    @Override
    public boolean check() {

        boolean valido = false;

        if (this.numero > 0 && this.numero <= 99999999 &&
                this.letra >= 'A' && this.letra <= 'Z') {
            valido = true;
        } else {
            valido = false;
        }

        return valido;
    }

    @Override
    public int compareTo(Object o) {

        int devuelve;
        Dni otro = (Dni) o;

        if (this.numero == otro.numero){
            if (this.letra == otro.letra){
                devuelve = 0;
            } else {
                devuelve = this.letra - otro.letra;
            }
        } else {
            devuelve = this.numero - otro.numero;
        }

        return devuelve;
    }

    @Override
    public String toString() {
        return "DNI:" + numero + letra;
    }
}
