package M9.UF3.Activitat10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClienteTCP extends Thread {
    static String host = "localhost";
    static int port = 60000;//Port remot
    static Socket client;

    public ClienteTCP() {
    }

    @Override
    public void run() {
        try {


            while (true) {
                BufferedReader servEntrada = new BufferedReader(new InputStreamReader(client.getInputStream()));
                String msgServer = "";
                //Rebuda cadena del servidor
                msgServer = servEntrada.readLine();
                System.out.println(" %% Other user: " + msgServer);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws Exception {

        client = new Socket(host, port);

        //FLUX DE SORTIDA AL SERVIDOR
        PrintWriter fsortida = new PrintWriter(client.getOutputStream(), true);

        //FLUX D'ENTRADA AL SERVIDOR
        BufferedReader fentrada = new BufferedReader(new InputStreamReader(client.getInputStream()));

        //FLUX PER A ENTRADA ESTÀNDARD
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String cadena = "";
        System.out.println("Introdueix la cadena: ");

        ClienteTCP recibirServer = new ClienteTCP();
        recibirServer.start();

        do {
            //Lectura del teclat
            cadena = in.readLine();
            //Enviament cadena al servidor
            fsortida.println(cadena);


        } while (!(cadena.equals("")));
        //Enviament cadena al servidor
        fsortida.println(cadena);

        fsortida.close();
        fentrada.close();
        System.out.println("Finalització de l'enviament...");
        in.close();
        client.close();
        System.exit(0);

    }

}