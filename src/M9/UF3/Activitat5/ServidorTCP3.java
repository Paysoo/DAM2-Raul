package M9.UF3.Activitat5;

import java.net.*;
import java.io.*;

public class ServidorTCP3 {

    public static void main(String[] args) throws Exception {

        int numPort = 60000;
        ServerSocket servidor = new ServerSocket(numPort);
        String cadena = "";

        for (int i = 0; i < 3; i++) {
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