package M3.UF5.Examen;

import M3.UF5.NF4.Activitat22.Classes.Item;

public abstract class Jugador {

    protected String nom;
    protected int alçada;
    protected int puntuacio;
    protected Habilitat[] habilitats = new Habilitat[3];

    public Jugador(String nom, int alçada, int puntuacio) {
        this.nom = nom;
        this.alçada = alçada;
        this.puntuacio = puntuacio;
    }

    public boolean equiparHabilitat(Habilitat habilitat){
        boolean potEquipar = false;
        boolean salir = false;
        int contador = 0;

        do {
            if (this.habilitats[contador] == null) {
                this.habilitats[contador] = habilitat;
                System.out.println(this.habilitats[contador].getNom() + " añadida correctamente a las habilidades de " +
                        this.nom + ".");
                potEquipar = true;
                salir = true;
            } else {
                if (contador < 2) {
                    contador++;
                } else {
                    System.out.println(this.nom + " ya tiene 3 habilidades.");
                    salir = true;
                }
            }
        } while (!salir);

        return potEquipar;
    }

    public boolean teEspecial(){
        boolean te = false;
        boolean sortir = false;
        int contador = 0;

        do {
            if (this.habilitats[contador] != null) {
                if (this.habilitats[contador].isEspecial()) {
                    te = true;
                }
            }
            contador++;
        } while (!sortir && contador < 3);



        return te;
    }

    public int puntuacioTotal(){
        int suma = 0;

        for (int i = 0; i < habilitats.length; i++) {
            if (this.habilitats[i] != null) {
                if (this.habilitats[i].isEspecial()) {
                    suma += (this.habilitats[i].getPuntuacio() * 2);
                } else {
                    suma += this.habilitats[i].getPuntuacio();
                }
            }
        }

        suma += this.puntuacio;

        return suma;
    }

    public String retornarHabilitats() {
        String str = "Habilitats\n";

        for (int i = 0; i < (this.habilitats.length - 1); i++) {
            for (int j = i + 1; j < this.habilitats.length; j++) {
                if ((this.habilitats[i] != null) && (this.habilitats[j] != null)) {
                    if (this.habilitats[i].getPuntuacio() < this.habilitats[j].getPuntuacio()) {
                        Habilitat aux = this.habilitats[i];
                        this.habilitats[i] = this.habilitats[j];
                        this.habilitats[j] = aux;
                    } else if (this.habilitats[i].getPuntuacio() == this.habilitats[j].getPuntuacio()) {
                        if (!this.habilitats[i].isEspecial() && this.habilitats[j].isEspecial()) {
                            Habilitat aux = this.habilitats[i];
                            this.habilitats[i] = this.habilitats[j];
                            this.habilitats[j] = aux;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < this.habilitats.length; i++) {
            if (this.habilitats[i] != null) {
                str += "     " + this.habilitats[i].getNom() + " · " + this.habilitats[i].getPuntuacio() + " · ";
                if (this.habilitats[i].isEspecial()) {
                    str += "Especial\n";
                } else {
                    str += "No especial\n";
                }
            }
        }

        return str;
    }

    public String toString(){
        String tipus = "";
        if (this.teEspecial()) {
            tipus = " · Especial";
        }
        return this.nom + " · " + this.alçada + " cm · " + this.puntuacio + " punts" + tipus + "\n" +
                this.retornarHabilitats() + "Puntuació total: " + this.puntuacioTotal() + " punts";
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getAlçada() {
        return alçada;
    }

    public void setAlçada(int alçada) {
        this.alçada = alçada;
    }

    public int getPuntuacio() {
        return puntuacio;
    }

    public void setPuntuacio(int puntuacio) {
        this.puntuacio = puntuacio;
    }

    public Habilitat[] getHabilitats() {
        return habilitats;
    }

    public void setHabilitats(Habilitat[] habilitats) {
        this.habilitats = habilitats;
    }

}
