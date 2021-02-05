package M3.UF5.Examen;

public class Main {
    public static void main(String[] args) {

        Habilitat dribbling = new Habilitat("Dribbling", true, 7);
        Habilitat jocAeri = new Habilitat("Joc aeri", false, 3);
        Habilitat gol = new Habilitat("Gol", true, 3);

        Defensor defensor = new Defensor("Jaime", 189, 70, 90, 0);

        defensor.equiparHabilitat(jocAeri);
        defensor.equiparHabilitat(dribbling);


        System.out.println(defensor);

    }
}
