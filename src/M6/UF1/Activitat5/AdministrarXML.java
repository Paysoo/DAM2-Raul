package M6.UF1.Activitat5;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

import java.io.*;
import java.util.Scanner;

public class AdministrarXML {
    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException {

        File fitxer = new File("alumnes.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse(fitxer);

        // Variables
        int opcion;

        // Le doy el nombre arrel a alumnes
        Element arrel = document.getDocumentElement();


        // Variable para pasar la id a las funciones
        String idElemento;

        // Boolean para seguir ejecutando el programa
        boolean salir = false;

        // Activo las id de los elementos para poder buscarlos
        activarId(document);

        while (!salir) {

            // Menu
            System.out.println("Elige una opcion");
            System.out.println("1 - Crear alumne");
            System.out.println("2 - Modificar alumne");
            System.out.println("3 - Eliminar alumne");
            System.out.println("4 - Crear atribut");
            System.out.println("5 - Modificar atribut");
            System.out.println("6 - Eliminar atribut");
            System.out.println("7 - Mostrar documento");
            System.out.println("8 - Guardar y salir");
            System.out.println("9 - Salir sin guardar");
            System.out.println("Introduce la opcion:");
            opcion = teclado.nextInt();


            switch (opcion) {

                case 1:

                    crearElement(document, arrel);

                    break;

                case 2:

                    mostrarDocument(document);
                    System.out.println("Introduce el id del elemento que quieres modificar");
                    idElemento = teclado.next();
                    modificarElemento(document, idElemento);

                    break;

                case 3:

                    System.out.println("Introduce el id del elemento que quieres eliminar");
                    idElemento = teclado.next();
                    eliminarElemento(document, idElemento);

                    break;

                case 4:

                    System.out.println("Introduce la id del elemento al que quieras añadir un atributo");
                    idElemento = teclado.next();
                    crearAtributo(document, idElemento);
                    break;


                case 5:

                    System.out.println("Introduce la id del elemento al que quieras modificar un atributo");
                    idElemento = teclado.next();
                    modificarAtributo(document, idElemento);
                    break;


                case 6:

                    System.out.println("Introduce la id del elemento al que quieras eliminar un atributo");
                    idElemento = teclado.next();
                    eliminarAtributo(document, idElemento);
                    break;

                case 7:

                    mostrarDocument(document);
                    break;

                case 8:

                    // GUARDAR
                    Source source = new DOMSource(document);
                    Result result = new StreamResult(new java.io.File("alumnes.xml"));
                    Transformer transformer = TransformerFactory.newInstance().newTransformer();
                    transformer.transform(source, result);
                    mostrarDocument(document);
                    salir = true;

                    break;

                case 9:

                    salir = true;

                    break;

            }
        }

    }

    // METODO ACTIVAR ID DE LOS ELEMENTOS
    public static void activarId(Document document) {

        // nodeArrel es alumnes
        Node nodeArrel = document.getDocumentElement();

        // Array dels nodes de alumnes
        NodeList nodesAlumnes = nodeArrel.getChildNodes();

        // For que recorre los nodes de alumnes
        for (int i = 0; i < nodesAlumnes.getLength(); i++) {

            // Asigna un node a la variable nodes
            Node node = nodesAlumnes.item(i);

            // Si el node que esta recorriendo es de tipo elemento...
            if (node.getNodeType() == Node.ELEMENT_NODE) {

                // Meto el nodo en una variable elemento para poder usar el metodo de activar id
                Element element = (Element) node;
                element.setIdAttribute("id", true);
            }
        }
    }

    // METODO CREAR ELEMENTO
    public static void crearElement(Document document, Element arrel) {

        // Creo el elemento alumne
        Element alumne = document.createElement("alumne");

        // Introduzco el elemento alumne dentro de arrel que es alumnes
        arrel.appendChild(alumne);

        // Creo el atributo id en elemento alumne
        alumne.setAttribute("id", contarId(document)); // Llamo a la funcion contarId para saber que id tengo que poner
        alumne.setIdAttribute("id", true); // Activo la id para poder buscar el elemento desde ella

        // Creo el resto de elementos y los introduzco en alumne usando appendChild
        Element nom = document.createElement("nom");
        alumne.appendChild(nom);
        Element cognom1 = document.createElement("cognom1");
        alumne.appendChild(cognom1);
        Element cognom2 = document.createElement("cognom2");
        alumne.appendChild(cognom2);
        Element notaFinal = document.createElement("notaFinal");
        alumne.appendChild(notaFinal);

        // Pido al usuario la informacion de los alumnos
        System.out.println("Introduce el nombre");
        String nomAfegit = teclado.next();
        System.out.println("Introduce el primer apellido");
        String cognom1Afegit = teclado.next();
        System.out.println("Introduce el segundo apellido");
        String cognom2Afegit = teclado.next();
        System.out.println("Introduce la nota final");
        String notaFinalAfegit = teclado.next();

        // Introduzco la informacion añadida por el usuario dentro de los elementos creados
        Text nodeNomAfegit = document.createTextNode(nomAfegit);
        nom.appendChild(nodeNomAfegit);
        Text nodeCognom1Afegit = document.createTextNode(cognom1Afegit);
        cognom1.appendChild(nodeCognom1Afegit);
        Text nodeCognom2Afegit = document.createTextNode(cognom2Afegit);
        cognom2.appendChild(nodeCognom2Afegit);
        Text nodeNotaFinalAfegit = document.createTextNode(notaFinalAfegit);
        notaFinal.appendChild(nodeNotaFinalAfegit);
    }

    // METODO MODIFICAR ELEMENTO
    public static void modificarElemento(Document document, String id) {

        // Asigno a alumne el elemento que quiere modificar buscandolo por la id
        Element alumne = document.getElementById(id);

        // Pregunto el elemento que quiere modificar
        System.out.println("Que elemento quieres modificar");
        System.out.println("1 - Nom");
        System.out.println("2 - Primer cognom");
        System.out.println("3 - Segon cognom");
        System.out.println("4 - Nota final");
        int elementoModificar = teclado.nextInt();

        // Switch para modificar el elemento seleccionado
        switch (elementoModificar) {

            case 1:

                // Asigno a la variable nom el elemento que se llame nom dentro de alumne, item(0) es
                // el primer elemento que se llame así que encuentre
                Element nom = (Element) alumne.getElementsByTagName("nom").item(0);

                System.out.println("Introduce el nuevo nombre");
                String nomAfegit = teclado.next();

                // Introduzco el nuevo texto en el elemento nom
                nom.setTextContent(nomAfegit);

                break;

            case 2:

                Element cognom1 = (Element) alumne.getElementsByTagName("cognom1").item(0);

                System.out.println("Introduce el nuevo primer apellido");
                String cognom1Afegit = teclado.next();

                // Introduzco el nuevo texto en el elemento cognom1
                cognom1.setTextContent(cognom1Afegit);

                break;

            case 3:

                Element cognom2 = (Element) alumne.getElementsByTagName("cognom2").item(0);

                System.out.println("Introduce el nuevo segundo apellido");
                String cognom2Afegit = teclado.next();

                // Introduzco el nuevo texto en el elemento cognom2
                cognom2.setTextContent(cognom2Afegit);

                break;

            case 4:

                Element notaFinal = (Element) alumne.getElementsByTagName("notaFinal").item(0);

                System.out.println("Introduce la nueva nota final");
                String notaFinalAfegit = teclado.next();

                // Introduzco el nuevo texto en el elemento notaFinal
                notaFinal.setTextContent(notaFinalAfegit);

                break;
        }

    }

    // METODO PARA ELIMINAR ELEMENTO
    public static void eliminarElemento(Document document, String id) throws ParserConfigurationException {

        // nodeArrel es alumnes
        Node nodeArrel = document.getDocumentElement();
        Element nodeEliminar = document.getElementById(id);

        nodeArrel.removeChild(nodeEliminar);

    }

    // METODO CREAR ATRIBUTO
    public static void crearAtributo(Document document, String id) {

        Element alumne = document.getElementById(id);

        System.out.println("Introduce el nombre del atributo que quieres crear");
        String nuevoAtributo = teclado.next();
        System.out.println("Introduce el valor de " + nuevoAtributo);
        String valorNuevoAtributo = teclado.next();

        alumne.setAttribute(nuevoAtributo, valorNuevoAtributo);
    }

    // METODO PARA ELIMINAR ATRIBUTO
    public static void eliminarAtributo(Document document, String id) {

        Element alumne = document.getElementById(id);

        System.out.println("Introduce el nombre del atributo que quieres eliminar");
        String atributoEliminar = teclado.next();

        // Elimino el atributo
        alumne.removeAttribute(atributoEliminar);

    }

    // METODO PARA MODIFICAR ATRIBUTO
    public static void modificarAtributo(Document document, String id) {
        Element alumne = document.getElementById(id);

        System.out.println("Introduce el nombre del atributo que quieres modificar");
        String atributoModificar = teclado.next();
        System.out.println("Introduce el nuevo valor del atributo " + atributoModificar);
        String nuevoValor = teclado.next();

        // Elimino el atributo
        alumne.setAttribute(atributoModificar, nuevoValor);
    }

    // METODO PARA SABER QUE ID PONER AL ELEMENTO CREADO
    public static String contarId(Document document) {

        // Primer elemento del xml
        Node nodeArrel = document.getDocumentElement();

        // Array dels nodes de alumnes
        NodeList nodesAlumnes = nodeArrel.getChildNodes();

        // Variable
        int num = 0;
        int comparacionId = 0;

        // For que recorre los nodes de alumnes
        for (int i = 0; i < nodesAlumnes.getLength(); i++) {

            // Asigna un node a la variable nodes
            Node node = nodesAlumnes.item(i);

            // Si el node que esta recorriendo es de tipo elemento...
            if (node.getNodeType() == Node.ELEMENT_NODE) {

                // Le suma 1 a la variable num
                num++;

                // Si el node tiene atributos...
                if (node.hasAttributes()) {

                    // Array de los atributos de nodes
                    NamedNodeMap atributs = node.getAttributes();

                    // For que recorre los atributos
                    for (int j = 0; j < atributs.getLength(); j++) {

                        // Si el atributo que esta recorrienddo es id
                        if (atributs.item(j).getNodeName().equals("id")) {

                            // Asigna a la variable comparacion el atributo que esta recorriendo
                            String comparacion = atributs.item(j).getNodeValue();

                            // La paso a int para poder compararla con num
                            comparacionId = Integer.parseInt(comparacion);
                        }
                    }
                }
            }


        }

        // La comparo con num y si son iguales le sumo un 1 a num
        if (comparacionId == num) {
            num++;
        }

        // Paso el num a String
        String numId = Integer.toString(num);

        return numId;


    }

    // METODO MOSTRAR DOCUMENTO
    public static void mostrarDocument(Document document) throws SAXException, IOException, ParserConfigurationException {

        //Per obtenir el nom, el tipus i el valor d’un node, cerqueu els mètodes apropiats.
        System.out.println("Element arrel: " +
                document.getDocumentElement().getNodeName() + "\n");
        //Es crea una llista de nodes amb tots els nodes llibre
        NodeList alumnes = document.getElementsByTagName("alumne");
        //Es recorre la llista
        for (int i = 0; i<alumnes.getLength(); i++){
            Node alumneNode = alumnes.item(i);//Obtindre un node
            //Tipus de node
            if (alumneNode.getNodeType() == Node.ELEMENT_NODE){
                //Obtindre els elements del node
                Element alumne = (Element) alumneNode;

                System.out.println("ID: " + alumne.getAttribute("id"));
                System.out.println("Edat: " + alumne.getAttribute("edad"));
                System.out.println("Nom: " + getNode("nom", alumne) );
                System.out.println("Cognoms: " + getNode("cognom1", alumne) + " " + getNode("cognom2", alumne) );
                System.out.println("Nota final: " + getNode("notaFinal", alumne) );

            }

        }
    }

    //Per obtenir els nodes fill d’un node useu el mètode getChildNodes()
    private static String getNode (String etiqueta, Element element) {

        NodeList node = element.getElementsByTagName(etiqueta).item(0).getChildNodes();
        Node valorNode = (Node) node.item(0);
        return valorNode.getNodeValue();//Torna el valor del node

    }

}
