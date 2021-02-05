package M3.UF5.Examen;

public class Habilitat {
    private String nom;
    private boolean especial;
    private int puntuacio;

    public Habilitat(String nom, boolean especial, int puntuacio) {
        this.nom = nom;
        this.especial = especial;
        this.puntuacio = puntuacio;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public boolean isEspecial() {
        return especial;
    }

    public void setEspecial(boolean especial) {
        this.especial = especial;
    }

    public int getPuntuacio() {
        return puntuacio;
    }

    public void setPuntuacio(int puntuacio) {
        this.puntuacio = puntuacio;
    }
}
