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
    static PrintWriter[] printWriters = new PrintWriter[3];
    int numConexion;
    String nombre;

    public ServidorTCP(Socket clientConnectat, int numConexion, String nombre) {
        this.cliente = clientConnectat;
        this.numConexion = numConexion;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        String cadena;
        boolean username = false;

        try {
            System.out.println("Client connectat... ");

            //FLUX DE SORTIDA AL CLIENT
            printWriters[numConexion] = new PrintWriter(cliente.getOutputStream(), true);

            //FLUX D'ENTRADA DEL CLIENT
            BufferedReader fentrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));

            do {
                if (!(cadena = fentrada.readLine()).startsWith("--nom ")) {
                    printWriters[numConexion].println("Por favor, introduce --nom seguido de tu nombre.");
                } else {
                    nombre = cadena.substring(6);
                    username = true;
                }
            } while (!username);

            while (!(cadena = fentrada.readLine()).equals("")) {
                System.out.println(nombre + ": " + cadena);

                for (int i = 0; i <= printWriters.length - 1; i++) {
                    if (i != numConexion && printWriters[i] != null) {
                        printWriters[i].println(nombre + ": " + cadena);

                    }
                }

            }

            //TANCAR STREAMS I SOCKETS
            System.out.println("Tancant connexió...");
            fentrada.close();
            printWriters[numConexion].close();
            cliente.close();
            clientes--;
            System.out.println("Clientes conectados: " + clientes);
            if (clientes == 0) {
                System.exit(0);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) throws Exception {

        int numPort = 60000;
        ServerSocket servidor = new ServerSocket(numPort);
        maxClients = Integer.valueOf(args[0]);

        while (true) {
            if (clientes < maxClients) {
                System.out.println("Esperant connexió del client...");
                Socket clientConnectat = servidor.accept();
                ServidorTCP cliente = new ServidorTCP(clientConnectat, clientes, "");
                cliente.start();
                clientes++;

            }
            sleep(300);
        }

    }

}