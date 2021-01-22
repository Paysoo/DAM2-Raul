package M3.UF5.NF4.EjemploInterficies;

public class Programa implements Comparable{

    private int pes;
    private String nom;
    private String empresa;
    private int plataforma;

    public Programa(int p, String n, String e, int pl) {
        this.pes = p;
        this.nom = n;
        this.empresa = e;
        this.plataforma = pl;
    }

    @Override
    public int compareTo(Object t) {
        int retorn = 0;
        Programa altre = (Programa)t;
        if (this.empresa.equals(altre.empresa)) {
            if (this.nom.equals(altre.nom)) {
                if (this.plataforma == altre.plataforma) {
                    if(this.pes == altre.pes){

                    } else {
                        retorn = this.pes - altre.pes;
                    }
                } else {
                    retorn = this.plataforma - altre.plataforma;
                }
            } else {
                retorn = 1;
            }
        } else {
            retorn = 1;
        }
        return retorn;
    }

    public static void main(String[] args) {
        Programa p1 = new Programa(100,"notepad++","Notepad", 32);
        Programa p2 = new Programa(100,"notepad++a","Notepad", 64);
        System.out.println(p1.compareTo(p2));

    }

}
