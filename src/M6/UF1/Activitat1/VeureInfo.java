package M6.UF1.Activitat1;

import java.io.*;
import java.util.Date;
import java.util.Scanner;

public class VeureInfo {

    public static void main(String[] args) {

        // Guardo el fichero que me ha dado en la variable f
        File f = new File(args[0]);

        // Si el fichero existe
        if (f.exists()) {

            // Si el fichero es una carpeta
            if (f.isDirectory()) {
                System.out.println("Fitxers al directori actual: ");

                // Creo un array de strings con el nombre de los archivos dentro de la carpeta
                String[] arxius = f.list();

                // Muestro los nombres de los archivos dentro de la carpeta
                for (int i = 0; i<arxius.length; i++){
                    System.out.println(arxius[i]);
                }

                // Si es un fichero muestro la informacion de este
            } else if (f.isFile()) {
                System.out.println("Nom del fitxer : "+f.getName());
                System.out.println("Ruta           : "+f.getPath());
                System.out.println("Ruta absoluta  : "+f.getAbsolutePath());
                System.out.println("Es pot escriure: "+f.canRead());
                System.out.println("Es pot llegir  : "+f.canWrite());
                System.out.println("Grandaria      : "+f.length());
                System.out.println("Es un directori: "+f.isDirectory());
                System.out.println("Es un fitxer   : "+f.isFile());

            }

            // Muestro si está oculto
            System.out.println("Esta ocult : " +f.isHidden());

            // Variables de data
            long ms = f.lastModified(); //ms es la data en milisegons
            Date data = new Date(ms); // paso els milisegons a format de data normal

            // Guardo la data actual en milisegons en una variable y la paso al format normal
            long msActual = System.currentTimeMillis();
            Date dataActual = new Date(msActual);

            // Mostra la data actual
            System.out.println("Ultima modificacio : " + data);

            // Calculo si el milisegons de la darrera modificacio restats als milisegons de la
            // data actual son inferiors o iguals a 3 dies en milisegons
            if ((msActual - ms) <= 259200000) {
                System.out.println("El ficher ha estat modificat els darrers 3 dies");
            } else {
                System.out.println("El ficher no ha estat modificat els darrers 3 dies");
            }

            // Si el archivo no existe muestro un mensaje
        } else {
            System.out.println("El arxiu introduit no existeix");
        }
    }

}
