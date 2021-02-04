package M3.UF5.NF4.Activitat22.Classes;

public class Item implements Comparable<Item>{

    protected String nom;
    protected double pes;
    protected int valor;

    public Item(String nom, double pes, int valor) {
        this.nom = nom;
        this.pes = pes;
        this.valor = valor;
    }

    @Override
    public int compareTo(Item o) {
        if (this.valor < o.valor) {
            return -1;
        }
        if (this.valor > o.valor) {
            return 1;
        }
        return 0;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPes() {
        return pes;
    }

    public void setPes(double pes) {
        this.pes = pes;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }


}
