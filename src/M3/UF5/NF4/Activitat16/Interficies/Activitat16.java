package M3.UF5.NF4.Activitat16.Interficies;

import M3.UF5.NF4.Activitat16.Interficies.Clases.Dni;
import M3.UF5.NF4.Activitat16.Interficies.Clases.Email;
import M3.UF5.NF4.Activitat16.Interficies.Clases.Fecha;
import M3.UF5.NF4.Activitat16.Interficies.Clases.Sexo;

import java.util.Scanner;

public class Activitat16 {

    public static void main(String[] args) {


        Scanner teclado = new Scanner(System.in);

        // EMAIL
        Email email1 = new Email("raul@hotmail.com");
        Email email2 = new Email("raul@outlook.com");
        Email email3 = new Email("raul@hotmailcom");
        Email email4 = new Email("raulhotmail.@com");
        System.out.println(email1 + ": " + email1.check());
        System.out.println(email2 + ": " + email2.check());
        System.out.println(email3 + ": " + email3.check());
        System.out.println(email4 + ": " + email4.check());
        System.out.println();

        // DNI
        Dni dni1 = new Dni(12345678, 'A');
        Dni dni2 = new Dni(12345678, '5');
        Dni dni3 = new Dni(123456789, 'A');
        Dni dni4 = new Dni(123456789, '4');
        System.out.println(dni1 + ": " + dni1.check());
        System.out.println(dni2 + ": " + dni2.check());
        System.out.println(dni3 + ": " + dni3.check());
        System.out.println(dni4 + ": " + dni4.check());
        System.out.println();

        // FECHA (1920 - 2020)
        Fecha fecha1 = new Fecha(2015, 9, 1);
        Fecha fecha2 = new Fecha(1919, 9, 1);
        Fecha fecha3 = new Fecha(2000, 13, 1);
        Fecha fecha4 = new Fecha(1950, 9, 32);
        System.out.println(fecha1 + ": " + fecha1.check());;
        System.out.println(fecha2 + ": " + fecha2.check());;
        System.out.println(fecha3 + ": " + fecha3.check());;
        System.out.println(fecha4 + ": " + fecha4.check());;
        System.out.println();

        // SEXO
        Sexo s1 = new Sexo('H');
        Sexo s2 = new Sexo('M');
        Sexo s3 = new Sexo('X');
        Sexo s4 = new Sexo('1');
        System.out.println(s1 + ": " + s1.check());
        System.out.println(s2 + ": " + s2.check());
        System.out.println(s3 + ": " + s3.check());
        System.out.println(s4 + ": " + s4.check());
    }

}
