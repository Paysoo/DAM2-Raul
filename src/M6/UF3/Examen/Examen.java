package M6.UF3.Examen;

import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.*;
import org.xmldb.api.modules.XPathQueryService;

import java.util.Scanner;

public class Examen {
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
            System.out.println("Introduce una opcion entre 1 y 4]" +
                    "\n1-CONSULTA 1 - Mostrar dies" +
                    "\n2-CONSULTA 2 - Dia i quantitat en que s'ha produit maxim nous casos" +
                    "\n3-CONSULTA 3 - Dia i quantitat en que s'ha produit maxim defuncions" +
                    "\n4-CONSULTA 4 - Mitja de nous casos i defuncions" +
                    "\n5-INSERCIO 5 - Afegir un dia i les dades" +
                    "\n6-ESBORRAT 6 - Esborrar dia i les dades" +
                    "\n7-Salir");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    mostrardies(servei);
                    break;
                case 2:
                    diaiquantitatmaximanouscasos(servei);
                    break;
                case 3:
                    diaiquantitatmaximadefuncions(servei);
                    break;
                case 4:
                    mitjanouscasosidefuncions(servei);
                    break;
                case 5:
                    inserirdia(servei);
                    break;
                case 6:
                    esborrardia(servei);
                    break;
                case 7:
                    salir = true;
                    break;
                default:
                    break;
            }
            System.out.println();
        }

        //S'esborra
        col.close();

    }

    private static void esborrardia(XPathQueryService servei)throws XMLDBException {
        ResourceSet result;
        String dia;

        System.out.println("Escribe el DIA (YYYY-mm-dd) que quieres ELIMINAR ");
        dia = teclado.next();

        result = servei.query("for $dia in /response/rows/row[data = \" " + dia + "\"] return $dia");
        ResourceIterator i;
        i = result.getIterator();

        if (!i.hasMoreResources()) {
            System.out.println("No existe ese dia");
            System.out.println();
        } else {
            servei.query("update delete /response/rows/row[data = \" " + dia + "\"]");
        }
    }

    private static void inserirdia(XPathQueryService servei)throws XMLDBException {
        ResourceSet result;
        String dia;
        int nousCasosDiaris;
        int defuncionsDiaries;
        int totalCasos;
        int totalDefuncions;

        System.out.println("Introduce el dia (YYYY-mm-dd)");
        dia = teclado.next();
        System.out.println("Introduce el numero de nuevos casos diarios");
        nousCasosDiaris = teclado.nextInt();
        System.out.println("Introduce el numero de defunciones diarias");
        defuncionsDiaries = teclado.nextInt();
        System.out.println("Introduce el total de casos confirmados");
        totalCasos = teclado.nextInt();
        System.out.println("Introduce el total de defunciones");
        totalDefuncions = teclado.nextInt();

        result = servei.query("for $dia in /response/rows/row[data = \" " + dia + "\"] return $dia");
        ResourceIterator i;
        i = result.getIterator();

        if (!i.hasMoreResources()) {
            servei.query("update insert <row><data>"
                    + dia + "</data><nous_casos_diaris_confirmats>" + nousCasosDiaris + "</nous_casos_diaris_confirmats><defuncions_di_ries>" + defuncionsDiaries
                    + "</defuncions_di_ries><total_de_casos_confirmats>" + totalCasos + "</total_de_casos_confirmats><total_de_defuncions>" + totalDefuncions + "</total_de_defuncions></row> into /response/rows");
        } else {
            System.out.println("Ya existe ese dia en el archivo");
            System.out.println();
        }

    }

    private static void mitjanouscasosidefuncions(XPathQueryService servei)throws XMLDBException {
        ResourceSet result = servei.query("avg(/response/rows/row/nous_casos_diaris_confirmats)");
        ResourceIterator i;
        i = result.getIterator();
        if (!i.hasMoreResources()) {
            System.out.println("No hay datos de los nuevos casos diarios");
        }
        while (i.hasMoreResources()) {
            Resource r = i.nextResource();
            System.out.println("Mitja nous casos diaris: " + (String) r.getContent());
        }

        result = servei.query("avg(/response/rows/row/defuncions_di_ries)");
        i = result.getIterator();
        if (!i.hasMoreResources()) {
            System.out.println("No hay datos de las defunciones diarias");
        }
        while (i.hasMoreResources()) {
            Resource r = i.nextResource();
            System.out.println("Mitja defuncions diaries: " + (String) r.getContent());
        }
    }

    private static void diaiquantitatmaximadefuncions(XPathQueryService servei) throws XMLDBException{
        ResourceSet result = servei.query("/response/rows/row[defuncions_di_ries = max(defuncions_di_ries)]");
        ResourceIterator i;
        i = result.getIterator();
        if (!i.hasMoreResources()) {
            System.out.println("No hay datos");
        }
        while (i.hasMoreResources()) {
            Resource r = i.nextResource();
            System.out.println((String) r.getContent());
        }
    }

    private static void diaiquantitatmaximanouscasos(XPathQueryService servei) throws XMLDBException{
        ResourceSet result = servei.query("/response/rows/row[nous_casos_diaris_confirmats = max(nous_casos_diaris_confirmats)]");
        ResourceIterator i;
        i = result.getIterator();
        if (!i.hasMoreResources()) {
            System.out.println("No hay datos");
        }
        while (i.hasMoreResources()) {
            Resource r = i.nextResource();
            System.out.println((String) r.getContent());
        }
    }

    private static void mostrardies(XPathQueryService servei) throws XMLDBException{
        ResourceSet result = servei.query("for $dia in /response/rows return /response/rows/row/data");
        ResourceIterator i;
        i = result.getIterator();
        if (!i.hasMoreResources()) {
            System.out.println("No hay dias en el XML");
        }
        while (i.hasMoreResources()) {
            Resource r = i.nextResource();
            System.out.println((String) r.getContent());

        }
    }
}
