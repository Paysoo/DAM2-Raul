package M3.UF5.Examen;

public class Atacant extends Jugador{
    protected int puntsOfensius;
    protected int puntsGolejadors;

    public Atacant(String nom, int alçada, int puntuacio, int puntsOfensius, int puntsGolejadors) {
        super(nom, alçada, puntuacio);
        this.puntsOfensius = puntsOfensius;
        this.puntsGolejadors = puntsGolejadors;
    }

    public int getPuntsOfensius() {
        return puntsOfensius;
    }

    public void setPuntsOfensius(int puntsOfensius) {
        this.puntsOfensius = puntsOfensius;
    }

    public int getPuntsGolejadors() {
        return puntsGolejadors;
    }

    public void setPuntsGolejadors(int puntsGolejadors) {
        this.puntsGolejadors = puntsGolejadors;
    }

    public String toString(){
        return super.toString() + "\nPuntucació ofensiva: " + this.puntsOfensius;
    }

}
