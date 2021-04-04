package M9.UF3.Activitat5;

import java.net.*;
import java.io.*;

// C:\Disco Duro 2TB\IntelliJ IDEA Project\out\production\IntelliJ IDEA Project>java M9.UF3.Activitat5.ServidorTCP4 5 <-NºClients

public class ServidorTCP4 {

    public static void main(String[] args) throws Exception {

        int numPort = 60000;
        ServerSocket servidor = new ServerSocket(numPort);
        String cadena = "";

        for (int i = 0; i < Integer.valueOf(args[0]); i++) {
            System.out.println("Esperant connexió... ");
            Socket clientConnectat = servidor.accept();
            System.out.println("Client connectat... ");

            //FLUX DE SORTIDA AL CLIENT
            PrintWriter fsortida = new PrintWriter(clientConnectat.getOutputStream(), true);


            //FLUX D'ENTRADA DEL CLIENT
            BufferedReader fentrada = new BufferedReader(new InputStreamReader(clientConnectat.getInputStream()));

            while (!(cadena = fentrada.readLine()).equals("")) {

                fsortida.println(cadena);
                System.out.println("Rebent: " + cadena);
                if (cadena.equals("*")) break;

            }

            //TANCAR STREAMS I SOCKETS
            System.out.println("Tancant connexió... ");
            fentrada.close();
            fsortida.close();
            clientConnectat.close();
        }
        servidor.close();


    }

}