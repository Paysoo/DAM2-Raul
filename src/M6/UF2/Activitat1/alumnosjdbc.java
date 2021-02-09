package M6.UF2.Activitat1;

import java.net.ConnectException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class alumnosjdbc {
    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) throws ParseException {
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
                    .getConnection("jdbc:mysql://localhost:3306/alumnosjdbc", "root", "");
            System.out.println("SQL Connection to database established!");

            boolean sortir = false;

            do {

                System.out.println("\nQue quieres hacer?");
                System.out.println("---------------------------------------------\n" +
                        "01 - Introducir alumno\n"+
                        "02 - Modificar alumno\n" +
                        "03 - Borrar alumno\n" +
                        "04 - Mostrar alumnos\n" +
                        "05 - Mostrar alumno por DNI\n" +
                        "06 - Introducir poblacion\n" +
                        "07 - Modificar poblacion\n" +
                        "08 - Borrar poblacion\n" +
                        "09 - Mostrar poblaciones\n" +
                        "10 - Mostrar poblacion por codigo postal\n" +
                        "11 - Salir\n" +
                        "---------------------------------------------");

                int opcion = teclado.nextInt();
                teclado.nextLine();

                switch (opcion) {

                    case 1:
                        // Llamo a la funcion para añdir alumno
                        inserirAlumne(connection);
                        break;

                    case 2:
                        // Llamo a la funcion para modificar alumno
                        mostrarAlumnes(connection);
                        System.out.println("Introduce el DNI del alumno que quieres modificar");
                        String dni = teclado.next();
                        modificarAlumne(connection, dni);
                        break;

                    case 3:
                        // Llamo a la funcion para borrar alumno
                        esborrarAlumne(connection);
                        break;

                    case 4:
                        // Llamo a la funcion para mostrar la tabla de alumnos
                        mostrarAlumnes(connection);
                        break;

                    case 5:
                        // Llamo a la funcion para mostrar alumno por DNI
                        System.out.println("Introduce el DNI del alumno que quieres listar");
                        dni = teclado.next();
                        mostrarAlumne(connection, dni);
                        break;

                    case 6:
                        // Lamo a la funcion para añadir poblacion
                        inserirPoblacio(connection);
                        break;

                    case 7:
                        // Llamo a la funcion para modificar poblacion
                        System.out.println("Introduce el Código Postal de la poblacion que quieres listar");
                        int codigoPostal = teclado.nextInt();
                        modificarPoblacio(connection,codigoPostal);
                        break;

                    case 8:
                        // Llamo a la funcion para borrar poblacion
                        esborrarPoblacio(connection);
                        break;

                    case 9:
                        // Llamo a la funcion para mostrar la tabla de poblaciones
                        mostrarPoblaciones(connection);
                        break;

                    case 10:
                        // Llamo a la funcion para mostrar poblacion por codigo postal
                        System.out.println("Introduce el Código Postal de la poblacion que quieres listar");
                        codigoPostal = teclado.nextInt();
                        mostrarPoblacion(connection, codigoPostal);
                        break;

                    case 11:
                        // Salgo del programa
                        sortir = true;
                        break;

                    default:
                        System.out.println("Introduce una opción valida por favor");
                        break;

                }

            } while (!sortir);

        } catch (SQLException e) {
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

    public static void mostrarAlumnes(Connection con) {
        try {
            PreparedStatement stmt;
            stmt = con.prepareStatement("SELECT * FROM alumno");
            ResultSet rs = stmt.executeQuery();

            SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");

            while (rs.next()) {
                System.out.println("Nombre: " + rs.getString(1));
                System.out.println("DNI: " + rs.getString(2));
                System.out.println("Fecha de nacimiento: " + data.format(rs.getDate(3)));
                System.out.println("Dirección: " + rs.getString(4));
                System.out.println("Genero: " + rs.getString(5));
                System.out.println("Código Postal: " + rs.getInt(6));
                System.out.println();
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
    }

    public static void mostrarAlumne(Connection con, String dni) {

        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");

        try {

            PreparedStatement stmt;
            stmt = con.prepareStatement("SELECT * FROM alumno WHERE dni = ?");
            stmt.setString(1, dni);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                System.out.println("Nombre: " + rs.getString(1));
                System.out.println("DNI: " + rs.getString(2));
                System.out.println("Fecha de nacimiento: " + data.format(rs.getDate(3)));
                System.out.println("Dirección: " + rs.getString(4));
                System.out.println("Genero: " + rs.getString(5));
                System.out.println("Código Postal: " + rs.getInt(6));
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
    }

    public static void mostrarPoblaciones(Connection con) {
        try {
            PreparedStatement stmt;
            stmt = con.prepareStatement("SELECT * FROM poblaciones");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                System.out.println("Población: " + rs.getString(1));
                System.out.println("Código Postal: " + rs.getString(2));
                System.out.println();
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
    }

    public static void mostrarPoblacion(Connection con, int codigoPostal) {

        try {

            PreparedStatement stmt;
            stmt = con.prepareStatement("SELECT * FROM poblaciones WHERE codigoPostal = ?");
            stmt.setInt(1, codigoPostal);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                System.out.println("Poblacion: " + rs.getString(1));
                System.out.println("Código Postal: " + rs.getString(2));
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
    }

    public static void inserirAlumne(Connection con) throws ParseException {
        System.out.println("Introduce el nombre del alumno");
        String aNombre = teclado.nextLine();
        System.out.println("Introduce el DNI de " + aNombre);
        String aDNI = teclado.next();

        System.out.println("Introduce la fecha de nacimiento de " + aNombre + "\nFormato [dd/MM/yyyy]");
        String aDate = teclado.next();
        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
        Date aFechaNacimiento = data.parse(aDate);
        teclado.nextLine();

        System.out.println("Introduce la dirección de " + aNombre);
        String aDireccion = teclado.nextLine();
        System.out.println("Introduce el sexo de " + aNombre + "\n[H] o [M]");
        String aSexo = teclado.next();
        System.out.println("Introduce el código postal de la dirección " + aDireccion);
        int aCodigoPostal = teclado.nextInt();
        boolean ciudadExist = false;
        try {
            do {

                PreparedStatement poblacionExist;
                poblacionExist = con.prepareStatement("SELECT poblacion FROM poblaciones WHERE codigoPostal = ?");
                poblacionExist.setInt(1, aCodigoPostal);
                ResultSet rs = poblacionExist.executeQuery();

                if (rs.isBeforeFirst()) {
                    PreparedStatement aStmt;
                    aStmt = con.prepareStatement("INSERT INTO alumno VALUES (?,?,?,?,?,?)");
                    aStmt.setString(1, aNombre);
                    aStmt.setString(2, aDNI);
                    aStmt.setDate(3, new java.sql.Date(aFechaNacimiento.getTime()));
                    aStmt.setString(4, aDireccion);
                    aStmt.setString(5, aSexo);
                    aStmt.setInt(6, aCodigoPostal);
                    aStmt.executeUpdate();

                    ciudadExist = true;
                } else {
                    System.out.println("Introduce un código postal existente");
                    aCodigoPostal = teclado.nextInt();
                }
            } while (!ciudadExist);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void inserirPoblacio(Connection con) {

        System.out.println("Introduce el nombre de la población");
        String pPoblacion = teclado.nextLine();
        System.out.println("Introduce el código postal de esa población");
        int pCodigoPostal = teclado.nextInt();

        try {

            PreparedStatement pStmt;
            pStmt = con.prepareStatement("INSERT INTO poblaciones VALUES (?,?)");
            pStmt.setString(1, pPoblacion);
            pStmt.setInt(2, pCodigoPostal);

            pStmt.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void modificarAlumne(Connection con, String dni) throws ParseException {

        mostrarAlumne(con, dni);
        System.out.println();
        teclado.nextLine();
        System.out.println("Introduce el nuevo nombre del alumno");
        String aNombre = teclado.nextLine();
        System.out.println("Introduce la fecha de nacimiento de " + aNombre + "\nFormato [dd/MM/yyyy]");
        String aDate = teclado.next();
        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
        Date aFechaNacimiento = data.parse(aDate);
        teclado.nextLine();

        System.out.println("Introduce la nueva dirección de " + aNombre);
        String aDireccion = teclado.nextLine();
        System.out.println("Introduce el sexo de " + aNombre + "\n[H] o [M]");
        String aSexo = teclado.next();
        System.out.println("Introduce el código postal de la dirección " + aDireccion);
        int aCodigoPostal = teclado.nextInt();
        boolean ciudadExist = false;

        try {
            do {

                PreparedStatement poblacionExist;
                poblacionExist = con.prepareStatement("SELECT poblacion FROM poblaciones WHERE codigoPostal = ?");
                poblacionExist.setInt(1, aCodigoPostal);
                ResultSet rs = poblacionExist.executeQuery();

                if (rs.isBeforeFirst()) {
                    PreparedStatement aStmt;
                    aStmt = con.prepareStatement("UPDATE alumno SET nombre=?,fechaNacimiento=?,direccion=?," +
                            "sexo=?,codigoPostal=? WHERE dni = ?");

                    aStmt.setString(1, aNombre);
                    aStmt.setDate(2, new java.sql.Date(aFechaNacimiento.getTime()));
                    aStmt.setString(3, aDireccion);
                    aStmt.setString(4, aSexo);
                    aStmt.setInt(5, aCodigoPostal);
                    aStmt.setString(6, dni);
                    aStmt.executeUpdate();

                    ciudadExist = true;
                } else {
                    System.out.println("Introduce un código postal existente");
                    aCodigoPostal = teclado.nextInt();
                }
            } while (!ciudadExist);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public static void modificarPoblacio(Connection con, int codigoPostal) {
        mostrarPoblacion(con, codigoPostal);
        System.out.println();
        teclado.nextLine();
        System.out.println("Introduce el nuevo nombre de la población");
        String poblacion = teclado.nextLine();

        boolean ciudadExist = false;

        try {
            do {

                PreparedStatement poblacionExist;
                poblacionExist = con.prepareStatement("SELECT poblacion FROM poblaciones WHERE codigoPostal = ?");
                poblacionExist.setInt(1, codigoPostal);
                ResultSet rs = poblacionExist.executeQuery();

                if (rs.isBeforeFirst()) {
                    PreparedStatement aStmt;
                    aStmt = con.prepareStatement("UPDATE poblaciones SET poblacion=? WHERE codigoPostal = ?");

                    aStmt.setString(1, poblacion);
                    aStmt.setInt(2, codigoPostal);
                    aStmt.executeUpdate();

                    ciudadExist = true;
                } else {
                    System.out.println("Introduce un código postal existente");
                    codigoPostal = teclado.nextInt();
                }
            } while (!ciudadExist);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void esborrarAlumne(Connection con) {
        String aDNI;
        boolean longitudCorrecta = false;
        String consulta;

        do {
            System.out.println("Introduce el DNI del alumno que quieras borrar");
            aDNI = teclado.next();
            consulta = "DELETE FROM alumno WHERE DNI = ? ";

            if (aDNI.length() == 9) {
                longitudCorrecta = true;
            }

        } while (!longitudCorrecta);

        try {

            PreparedStatement stmt = con.prepareStatement(consulta);
            stmt.setString(1, aDNI);
            stmt.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block

            e.printStackTrace();
        }


    }

    public static void esborrarPoblacio(Connection con) {
        int codigoPostal;
        boolean longitudCorrecta = false;
        String consultaPoblacion;

        do {
            System.out.println("Introduce el código postal de la poblacion que quieras borrar");
            codigoPostal = teclado.nextInt();
            consultaPoblacion = "DELETE FROM poblaciones WHERE codigoPostal = ? ";

            if (String.valueOf(codigoPostal).length() == 5) {
                longitudCorrecta = true;
            }

        } while (!longitudCorrecta);

        try {

            PreparedStatement pStmt = con.prepareStatement(consultaPoblacion);
            pStmt.setInt(1, codigoPostal);
            pStmt.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block

            e.printStackTrace();
        }
    }


}
