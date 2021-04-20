package M9.UF3.Activitat10;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

// C:\Disco Duro 2TB\IntelliJ IDEA Project\out\production\IntelliJ IDEA Project>java M9.UF3.Activitat10.ServidorTCP 3 <-NºClients

public class ServidorTCP extends Thread {

    Socket cliente;
    static int clientes = 0;
    static int maxClients;
    Socket[] conexiones = new Socket[3];

    public ServidorTCP(Socket clientConnectat) {
        this.cliente = clientConnectat;
    }

    @Override
    public void run() {
        String cadena;

        try {
            System.out.println("Client connectat... ");

            for (int i = 0; i <= conexiones.length-1; i++) {
                if (conexiones[i] == null) {
                    conexiones[i] = this.cliente;
                }

            }

            //FLUX DE SORTIDA AL CLIENT
            PrintWriter fsortida = new PrintWriter(cliente.getOutputStream(), true);

            //FLUX D'ENTRADA DEL CLIENT
            BufferedReader fentrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));

            while (!(cadena = fentrada.readLine()).equals("")) {
                for (int i = 0; i <= conexiones.length-1; i++) {
                    fsortida = new PrintWriter(conexiones[i].getOutputStream(), true);
                    fsortida.println(cadena);
                }
                System.out.println("Rebent: " + cadena);

            }

            //TANCAR STREAMS I SOCKETS
            System.out.println("Tancant connexió...");
            fentrada.close();
            fsortida.close();
            cliente.close();
            clientes--;
            System.out.println("Clientes conectados: " + clientes);
            if (clientes == 0) {
                System.exit(0);
            }


        } catch (Exception e) {
            System.out.println("ERROR");
        }
    }

    public static void main(String[] args) throws Exception {

        int numPort = 60000;
        ServerSocket servidor = new ServerSocket(numPort);
        maxClients = Integer.valueOf(args[0]);
        int contador = 0;
        boolean clienteAfegit = false;

        while (true){
            if (clientes < maxClients) {
                System.out.println("Esperant connexió del client...");
                Socket clientConnectat = servidor.accept();
                ServidorTCP cliente = new ServidorTCP(clientConnectat);
                cliente.start();
                clientes++;
            }
            sleep(300);
        }

    }

}