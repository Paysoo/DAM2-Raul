package M9.UF3.Activitat9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

// C:\Disco Duro 2TB\IntelliJ IDEA Project\out\production\IntelliJ IDEA Project>java M9.UF3.Activitat5.ServidorTCP4 5 <-NºClients

public class ServidorTCP extends Thread {

    public static void main(String[] args) throws Exception {


        int numPort = 60000;
        ServerSocket servidor = new ServerSocket(numPort);
        String cadena = "";
        int clientes = Integer.valueOf(args[0]);

        for (int i = 0; i < clientes; i++) {
            System.out.println("Esperant connexió del client [" + i + "]");
            Socket clientConnectat = servidor.accept();
            System.out.println("Client [" + i + "] connectat... ");

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