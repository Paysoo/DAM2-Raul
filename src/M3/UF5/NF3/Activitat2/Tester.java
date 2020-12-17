package M3.UF5.NF3.Activitat2;

public class Tester {

    public boolean comprobacio(int num, int numT) {
        boolean reversible = false;

        int longNum = 0;
        int longNumT = 0;

        int numCount = num;
        int numTCount = numT;

        // Calculo la longitud del numero original
        while(numCount !=0)
        {
            numCount = numCount/10;
            longNum++;
        }

        // Calculo la longitud del numero al reves
        while(numTCount !=0)
        {
            numTCount = numTCount/10;
            longNumT++;
        }

        // Si no coinciden lo marco como no reversible
        if (longNum == longNumT) {
            int numResultat = num + numT;

            // Si el modulo no es 0 significa que la suma es impar = reversive
            if (numResultat % 2 != 0) {
                reversible = true;
            } else {
                reversible = false;
            }

        } else {
            reversible = false;
        }

        return reversible;
    }


}
