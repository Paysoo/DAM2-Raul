package M9.UF3.Activitat1;

import java.net.InetAddress;
import java.net.UnknownHostException;

// PARA EJECUTAR POR COMANDOS:
// C:\Disco Duro 2TB\IntelliJ IDEA Project\out\production\IntelliJ IDEA Project>java M9.UF3.Activitat1.TestInetAddress localhost
public class TestInetAddress {

    public static void main(String[] args) {

        InetAddress dir;
        System.out.println("=====================================================");
        System.out.println("SALIDA");

        try {
        // LE PASO EL PRIMER ARGUMENTO DEL ARRAY
            dir = InetAddress.getByName(args[0]);
            provaTots(dir);

            // Array tipus InetAddress amb totes les adreces IP de google.com
            System.out.println("\n\tAdreces IP per a: " + dir.getHostName());
            InetAddress[] adreces = InetAddress.getAllByName(dir.getHostName());
            for (int i = 0; i < adreces.length; i++)
                System.out.println("\t\t" + adreces[i].toString());
            System.out.println("=====================================================");

        } catch (UnknownHostException e1) {
            e1.printStackTrace();
        }
    }

    private static void provaTots(InetAddress dir) {

        InetAddress dir2;

        System.out.println("\tMètode getByName(): "+dir);

        try {
            dir2 = InetAddress.getLocalHost();
            System.out.println("\tMètode getLocalHost(): "+dir2);
        } catch (UnknownHostException e) {e.printStackTrace();}

        //FEM SERVIR MÊTODES DE LA CLASSE
        System.out.println("\tMètode getHostName(): "+dir.getHostName());
        System.out.println("\tMètode getHostAddress(): "+dir.getHostAddress());
        System.out.println("\tMètode toString(): "+dir.toString());
        System.out.println("\tMètode getCanonicalHostName(): "+dir.getCanonicalHostName());

    }

}