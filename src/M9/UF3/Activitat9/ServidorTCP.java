package M9.UF3.Activitat9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

// C:\Disco Duro 2TB\IntelliJ IDEA Project\out\production\IntelliJ IDEA Project>java M9.UF3.Activitat9.ServidorTCP 3 <-NºClients

public class ServidorTCP extends Thread {

    Socket cliente;
    static int clientes = 0;
    static boolean cerrarServidor = false;

    public ServidorTCP(Socket clientConnectat) {
        this.cliente = clientConnectat;
    }

    @Override
    public void run() {
        String cadena;

        try {
            clientes++;
            System.out.println("Client connectat... ");

            //FLUX DE SORTIDA AL CLIENT
            PrintWriter fsortida = new PrintWriter(cliente.getOutputStream(), true);

            //FLUX D'ENTRADA DEL CLIENT
            BufferedReader fentrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));

            while (!(cadena = fentrada.readLine()).equals("")) {
                fsortida.println(cadena);
                System.out.println("Rebent: " + cadena);

            }

            //TANCAR STREAMS I SOCKETS
            System.out.println("Tancant connexió...");
            fentrada.close();
            fsortida.close();
            cliente.close();
            clientes--;
            if (clientes <= 0) {
                cerrarServidor = true;
            }
            System.out.println("Clientes conectados: " + clientes);

        } catch (Exception e) {
            System.out.println("ERROR");
        }
    }

    public static void main(String[] args) throws Exception {

        int numPort = 60000;
        ServerSocket servidor = new ServerSocket(numPort);

        do {
            System.out.println("Esperant connexió del client...");
            Socket clientConnectat = servidor.accept();
            ServidorTCP cliente = new ServidorTCP(clientConnectat);
            cliente.start();
        } while (!cerrarServidor);

        servidor.close();

    }

}