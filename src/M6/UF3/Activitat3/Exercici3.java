package M6.UF3.Activitat3;

import org.xmldb.api.*;
import org.xmldb.api.base.*;
import org.xmldb.api.modules.*;

import java.sql.ResultSet;
import java.util.Scanner;

public class Exercici3 {
    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) throws XMLDBException {
        //Driver per a eXist
        String driver = "org.exist.xmldb.DatabaseImpl";
        //Col·lecció
        Collection col = null;
        //URI col·lecció
        String URI = "xmldb:exist://localhost:8080/exist/xmlrpc/db/";
        //Usuari
        String usu = "admin";
        //Contrasenya
        String usuPass = "alumne";

        try {
            //Carrega el driver
            Class cl = Class.forName(driver);
            //Instància de la BD
            Database database = (Database) cl.newInstance();
            //Registre del driver
            DatabaseManager.registerDatabase(database);
        } catch (Exception e) {
            System.out.println("Error en inicialitzar la base de dades eXist");
            e.printStackTrace();
        }

        col = DatabaseManager.getCollection(URI, usu, usuPass);
        if (col == null)
            System.out.println("*** LA COL·LECCIÓ NO EXISTEIX ***");

        int opcion;
        boolean salir = false;
        XPathQueryService servei = (XPathQueryService) col.getService("XPathQueryService", "1.0");

        while (!salir) {
            mostrardeps(servei);
            System.out.println("Introduce una opcion entre 1 y 4]" +
                    "\n1-Añadir departamento" +
                    "\n2-Borrar departamento" +
                    "\n3-Modificar departamento" +
                    "\n4-Salir");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    insereixdep(servei);
                    break;
                case 2:
                    esborradep(servei);
                    break;
                case 3:
                    modificadep(servei);
                    break;
                case 4:
                    salir = true;
                default:
                    break;
            }
        }

        //S'esborra
        col.close();

    }

    public static void insereixdep(XPathQueryService servei) throws XMLDBException {
        ResourceSet result;
        int depNum;
        String depNom;
        String depLocalitat;

        System.out.println("Introduce el num de departamento");
        depNum = teclado.nextInt();
        System.out.println("Introduce el nombre del departamento");
        depNom = teclado.next();
        System.out.println("Introduce la localidad del departamento");
        depLocalitat = teclado.next();

        result = servei.query("for $dep in /departamentos/DEP_ROW[DEPT_NO=" + depNum + "] return $dep");
        ResourceIterator i;
        i = result.getIterator();

        if (!i.hasMoreResources()) {
            servei.query("update insert <DEP_ROW><DEPT_NO>"
                    + depNum + "</DEPT_NO><DNOMBRE>" + depNom + "</DNOMBRE><LOC>" + depLocalitat
                    + "</LOC></DEP_ROW> into /departamentos");
        } else {
            System.out.println("Ya existe un departamento con ese numero");
            System.out.println();
        }

    }

    public static void esborradep(XPathQueryService servei) throws XMLDBException {
        ResourceSet result;
        int depNum = 0;

        System.out.println("Escribe el numero del DEPARTAMENTO que quieres ELIMINAR ");
        depNum = teclado.nextInt();

        result = servei.query("for $dep in /departamentos/DEP_ROW[DEPT_NO=" + depNum + "] return $dep");
        ResourceIterator i;
        i = result.getIterator();

        if (!i.hasMoreResources()) {
            System.out.println("No hay departamentos con ese numero");
            System.out.println();
        } else {
            servei.query("update delete /departamentos/DEP_ROW[DEPT_NO=" + depNum + "]");
        }
    }

    public static void modificadep(XPathQueryService servei) throws XMLDBException {
        ResourceSet result;
        int depNum;
        String depNom;
        String depLocalitat;

        System.out.println("Introduce el num de DEPARTAMENTO que quieres MODIFICAR");
        depNum = teclado.nextInt();
        System.out.println("Introduce el nombre del departamento");
        depNom = teclado.next();
        System.out.println("Introduce la localidad del departamento");
        depLocalitat = teclado.next();

        result = servei.query("for $dep in /departamentos/DEP_ROW[DEPT_NO=" + depNum + "] return $dep");
        ResourceIterator i;
        i = result.getIterator();

        if (!i.hasMoreResources()) {
            System.out.println("No hay departamentos con ese numero");
            System.out.println();
        } else {
            servei.query("update replace /departamentos/DEP_ROW[DEPT_NO = " + depNum + "]/DNOMBRE with " +
                    "<DNOMBRE>" + depNom + "</DNOMBRE>");
            servei.query("update replace /departamentos/DEP_ROW[DEPT_NO =" + depNum + "]/LOC with " +
                    "<LOC>" + depLocalitat + "</LOC>");
        }
    }

    public static void mostrardeps(XPathQueryService servei) throws XMLDBException {
        ResourceSet result = servei.query("for $dep in /departamentos return $dep");
        ResourceIterator i;
        i = result.getIterator();
        if (!i.hasMoreResources()) {
            System.out.println("NO HAY DEPARTAMENTOS");
        }
        while (i.hasMoreResources()) {
            Resource r = i.nextResource();
            System.out.println((String) r.getContent());
        }
    }

}
