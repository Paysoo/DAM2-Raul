package M3.UF5.NF4.Activitat16.Interficies.Clases;

import M3.UF5.NF4.Activitat16.Interficies.Interficies.Valida;

public class Sexo implements Comparable, Valida {

    private char valor; // (H o M)

    public Sexo(char valor) {
        this.valor = valor;
    }

    @Override
    public boolean check() {

        return (this.valor == 'H' || this.valor == 'M');
    }

    @Override
    public int compareTo(Object o) {

        int devuelve;
        Sexo otro = (Sexo) o;

        if (this.valor == otro.valor){
            devuelve = 0;
        } else{
            devuelve = this.valor - otro.valor;
        }

        return devuelve;
    }

    @Override
    public String toString() {
        return "Sexo: " + valor;
    }
}
