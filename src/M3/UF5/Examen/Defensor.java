package M3.UF5.Examen;

public class Defensor extends Jugador{
    protected int puntsDefensors;
    protected int puntsRecuperacio;

    public Defensor(String nom, int alçada, int puntuacio, int puntsDefensors, int puntsRecuperacio) {
        super(nom, alçada, puntuacio);
        this.puntsDefensors = puntsDefensors;
        this.puntsRecuperacio = puntsRecuperacio;
    }

    public int getPuntsDefensors() {
        return puntsDefensors;
    }

    public void setPuntsDefensors(int puntsDefensors) {
        this.puntsDefensors = puntsDefensors;
    }

    public int getPuntsRecuperacio() {
        return puntsRecuperacio;
    }

    public void setPuntsRecuperacio(int puntsRecuperacio) {
        this.puntsRecuperacio = puntsRecuperacio;
    }

    public String toString(){
        return super.toString() + "\nPuntucació defensiva: " + this.puntsDefensors;
    }
}
