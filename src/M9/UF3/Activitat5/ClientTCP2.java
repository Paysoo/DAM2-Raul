package M9.UF3.Activitat5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientTCP2 {
    public static void main (String[] args) throws Exception {

        String host = "localhost";
        int port = 60000;//Port remot
        Socket client = new Socket(host, port);

        //FLUX DE SORTIDA AL SERVIDOR
        PrintWriter fsortida = new PrintWriter(client.getOutputStream(), true);

        //FLUX D'ENTRADA AL SERVIDOR
        BufferedReader fentrada = new BufferedReader(new InputStreamReader(client.getInputStream()));

        //FLUX PER A ENTRADA ESTÀNDARD
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String cadena, eco = "";
        System.out.println("Introdueix la cadena: ");
        //Lectura teclat
        cadena = in.readLine();

        // HASTA QUE NO HACES UN "ENTER" SIN HABER PUESTO NADA EN LA CADENA, EL CLIENTE NO SE CIERRA Y
        // PETA AL CREAR UNO NUEVO
        while (cadena != null) {

            //Enviament cadena al servidor
            fsortida.println(cadena);
            //Rebuda cadena del servidor
            eco = fentrada.readLine();
            System.out.println("  =>ECO: "+eco);
            //Lectura del teclat
            cadena = in.readLine();

        }

        fsortida.close();
        fentrada.close();
        System.out.println("Finalització de l'enviament...");
        in.close();
        client.close();

    }

}
