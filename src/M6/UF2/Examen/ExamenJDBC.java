package M6.UF2.Examen;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class ExamenJDBC {
    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println();
        System.out.println("-------- MySQL JDBC Connection Demo ------------");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found !!");

        }
        System.out.println("MySQL JDBC Driver Registered!");
        Connection connection = null;
        try {
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/examen_m6_uf2", "root", "");
            System.out.println("SQL Connection to database established!");

            boolean sortir = false;

            do {

                System.out.println("\nQue quieres hacer?");
                System.out.println("---------\n" +
                        "1 - CREAR\n" +
                        "2 - LOGIN\n" +
                        "3 - RESET\n" +
                        "4 - Salir\n" +
                        "---------");

                int opcion = teclado.nextInt();
                teclado.nextLine();

                switch (opcion) {

                    case 1:
                        // Llamo a la funcion para crear usuario
                        crearUsuario(connection);
                        break;

                    case 2:
                        // Llamo a la funcion para hacer login
                        login(connection);
                        break;

                    case 3:
                        System.out.println("A que usuario quieres cambiar la contrasenya?");
                        String nom = teclado.next();
                        teclado.nextLine();
                        // Llamo a la funcion para cambiar contraseña
                        resetPassword(connection, nom);
                        break;

                    case 4:
                        // Salgo del programa
                        sortir = true;
                        break;

                    default:
                        System.out.println("Introduce una opción valida por favor");
                        break;

                }

            } while (!sortir);

        } catch (SQLException | ParseException e) {
            System.out.println("Connection Failed! Check output console");
            System.out.println(e);

        } finally {
            try {
                if (connection != null)
                    connection.close();
                System.out.println("Connection closed !!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public static void crearUsuario(Connection con) throws ParseException {
        System.out.println("Introduce el nombre del usuario");
        String aNombre = teclado.nextLine();
        System.out.println("Introduce la contraseña para el usuario " + aNombre);
        String aContrasenya = teclado.next();
        teclado.nextLine();
        System.out.println("Introduce la pregunta de seguridad (por si olvidas la contraseña)");
        String aPregunta = teclado.nextLine();
        System.out.println("Introduce la respuesta");
        String aRespuesta = teclado.nextLine();

        try {

            PreparedStatement usuariExiste;
            usuariExiste = con.prepareStatement("SELECT usuari FROM usuaris WHERE usuari = ?");
            usuariExiste.setString(1, aNombre);
            ResultSet rs = usuariExiste.executeQuery();

            if (!rs.isBeforeFirst()) {

                PreparedStatement aStmt;
                aStmt = con.prepareStatement("INSERT INTO usuaris VALUES (?,?,?,?)");
                aStmt.setString(1, aNombre);
                aStmt.setString(2, aContrasenya);
                aStmt.setString(3, aPregunta);
                aStmt.setString(4, aRespuesta);

                aStmt.executeUpdate();

                System.out.println("Usuari creat");
            } else {
                System.out.println("ERROR: Usuari ja existeix");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public static void login(Connection con) throws ParseException {
        System.out.println("Introduce el nombre del usuario");
        String aNombre = teclado.nextLine();
        System.out.println("Introduce la contraseña para el usuario " + aNombre);
        String aContrasenya = teclado.next();
        teclado.nextLine();

        try {

            PreparedStatement comprobarContrasenya;
            comprobarContrasenya = con.prepareStatement("SELECT contrasenya FROM usuaris WHERE contrasenya = ?");
            comprobarContrasenya.setString(1, aContrasenya);
            ResultSet rs = comprobarContrasenya.executeQuery();

            if (rs.isBeforeFirst()) {
                System.out.println("Login correcte");

            } else {
                System.out.println("ERROR: Login incorrecte");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public static void resetPassword(Connection con, String nom) {

        try {
            PreparedStatement usuariExiste;
            usuariExiste = con.prepareStatement("SELECT usuari FROM usuaris WHERE usuari = ?");
            usuariExiste.setString(1, nom);
            ResultSet rs = usuariExiste.executeQuery();

            if (rs.isBeforeFirst()) {

                try {

                    PreparedStatement stmt;
                    stmt = con.prepareStatement("SELECT * FROM usuaris WHERE usuari = ?");
                    stmt.setString(1, nom);
                    rs = stmt.executeQuery();

                    while (rs.next()) {
                        System.out.println(rs.getString(3));
                    }

                    System.out.print("Respuesta: ");
                    String resposta = teclado.nextLine();

                    try {

                        PreparedStatement comprobarResposta;
                        comprobarResposta = con.prepareStatement("SELECT resposta FROM usuaris WHERE resposta = ?");
                        comprobarResposta.setString(1, resposta);
                        rs = comprobarResposta.executeQuery();

                        if (rs.isBeforeFirst()) { // Si encuentra la respuesta en la bases de datos entonces le deja cambiar la contraseña
                                                    // Si no la encuentra le deberia salir el mensaje de error "ERROR: Reset incorrecte"
                            System.out.println("Introduce la nueva contraseña");
                            String novaContrasenya = teclado.next();
                            teclado.nextLine();

                            PreparedStatement canviarContrasenya;
                            canviarContrasenya = con.prepareStatement("UPDATE usuaris SET contrasenya=? WHERE usuari = ?");
                            canviarContrasenya.setString(1, novaContrasenya);
                            canviarContrasenya.setString(2, nom);

                            canviarContrasenya.executeUpdate();
                            System.out.println("Contrasenya canviada");

                        } else {
                            System.out.println("ERROR: Reset incorrecte");
                        }

                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }

                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();

                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

