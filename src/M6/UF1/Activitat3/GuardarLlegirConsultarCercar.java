package M6.UF1.Activitat3;

import java.io.*;
import java.util.Scanner;

public class GuardarLlegirConsultarCercar {
    public static void main(String[] args) throws IOException {
        Scanner teclado = new Scanner(System.in);

//									ESCRIBIR DATOS
//		------------------------------------------------------------------

        // Declaro el fichero
        File fitxer = new File("persones.txt");

        //Crea un flux (stream) d'arxiu d'accés aleatori per llegir
        RandomAccessFile aleatoriFile = new RandomAccessFile(fitxer, "rw");

        //Les dades per inserir
        String dni = null;
        String nom = null;
        String cognom = null;
        int edat;

        // Pregunto cuantas personas quiere introducir
        System.out.println("Cuantas personas quieres introducir");
        int cantidad = teclado.nextInt();

        //Construeix un buffer (memòria intermèdia) de strings
        StringBuffer buffer = null;

        for (int i=1; i<cantidad+1; i++) {
            System.out.println("Escribe el DNI de la persona " + i);
            dni = teclado.next();

            aleatoriFile.writeInt(i+1);//1 enter ocupa 4 bytes

            //50 caràcters a 2bytes/caràcter 100 bytes
            buffer = new StringBuffer (dni);
            buffer.setLength(50);
            aleatoriFile.writeChars(buffer.toString());

            System.out.println("Escribe el nombre de la persona " + i);
            nom = teclado.next();

            //25 caràcters a 2bytes/caràcter 50 bytes
            buffer = new StringBuffer (nom);
            buffer.setLength(25);
            aleatoriFile.writeChars(buffer.toString());

            System.out.println("Escribe el apellido de la persona " + i);
            cognom = teclado.next();

            //30 caràcters a 2bytes/caràcter 60 bytes
            buffer = new StringBuffer (cognom);
            buffer.setLength(30);
            aleatoriFile.writeChars(buffer.toString());

            System.out.println("Escribe la edad de la persona " + i);
            edat = teclado.nextInt();

            //1 int ocupa 4 bytes
            aleatoriFile.writeInt(edat);

            // Total 214 bytes
        }

//								LEER DATOS
//		---------------------------------------------------------------

        //Apuntador s'inicialitza apuntant a l'inici del fitxer
        int apuntador = 0;

        char dni1[] = new char[50];
        char nom1[] = new char[25];
        char cognom1[] = new char[30];
        int edat1;
        char  aux;

        //Recorrer el fitxer llibres
        for (;;) {
            aleatoriFile.seek(apuntador);//Apuntar a l'inici de cada llibre al fitxer

            //Llegeix Títol
            for(int i = 0; i<dni1.length; i++) {
                aux = aleatoriFile.readChar();
                dni1[i] = aux;
            }

            String dnis = new String(dni);


            //Llegeix Autor
            for(int i = 0; i<nom1.length; i++) {
                aux = aleatoriFile.readChar();
                nom1[i] = aux;
            }

            String noms = new String(nom);

            //Llegeix Editorial
            for(int i = 0; i<cognom1.length; i++) {
                aux = aleatoriFile.readChar();
                cognom1[i] = aux;
            }

            String cognoms = new String(cognom);

            //Llegeix Preu
            edat1 = aleatoriFile.readInt();

            //Sortida de les dades de cada llibre
            System.out.println("DNI: "+ dnis);
            System.out.println("Nom: " + noms);
            System.out.println("Cognom: " + cognoms);
            System.out.println("Edat " + edat1);

            //S'ha de posicionar l'apuntador al següent llibre
            apuntador += 214;

            //Si coincideix on s'està apuntat amb el final del fitxer, sortim
            if(aleatoriFile.getFilePointer()==aleatoriFile.length()) {

                break;

            }

        }

        aleatoriFile.close();//Tancar el fitxer

    }

}
