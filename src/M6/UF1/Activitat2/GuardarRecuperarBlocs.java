package M6.UF1.Activitat2;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class GuardarRecuperarBlocs {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner teclado = new Scanner(System.in);

        // Campo variable de cotxe
        Cotxe cotxe;

        // Declaro el fichero
        File fitxer = new File("cotxesObject.txt");

        //Crea el flux de sortida
        FileOutputStream fileout = new FileOutputStream(fitxer);

        //Connectar el flux de bytes al flux de dades
        ObjectOutputStream dataOuMarca = new ObjectOutputStream(fileout);

        // Variables
        int cantidad;

        // Pido la cantidad de cotxes que quiere introducir el usuario
        System.out.println("Cuantos coches quieres añadir");
        cantidad = teclado.nextInt();

        //Recorre els arrays
        for (int i=1; i<cantidad+1; i++){//Crea el cotxe

            // Declaro que voy a usar la variable cotxe para crear un nuevo objeto en la clase cotxe
            cotxe = new Cotxe();

            // Pido los datos del cotxe por teclado y los guardo en el objeto cotxe
            System.out.println("Introduce la marca del coche " + i);
            cotxe.setMarca(teclado.next());
            System.out.println("Introduce el modelo del coche " + i);
            cotxe.setModelo(teclado.next());
            System.out.println("Introduce el año del coche " + i);
            cotxe.setAny(teclado.nextInt());
            System.out.println("Introduce la matricula del coche " + i);
            cotxe.setMatricula(teclado.next());

            // Lo escribo en el fichero
            dataOuMarca.writeObject(cotxe);

        }

        //Crea el flux d'entrada
        FileInputStream filein = new FileInputStream(fitxer);
        //Connectar el flux de bytes al flux de dades
        ObjectInputStream dataInMarca = new ObjectInputStream(filein);

        System.out.println("1 - Recuperar todos los objetos");
        System.out.println("2 - Recuperar los objetos buscando por un campo");
        int opcion = teclado.nextInt();

        // Switch de las opciones dadas al usuario
        switch (opcion) {
            case 1:
                try {

                    while (true){//Llegeix el fitxer

                        //Llegeix el cotxe
                        cotxe = (Cotxe) dataInMarca.readObject();

                        // Muestro los datos de los coches que hay dentro del fichero
                        System.out.println("Cotxe: " + cotxe.getMarca());
                        System.out.println("Model: " + cotxe.getModelo());
                        System.out.println("Any: " + cotxe.getAny());
                        System.out.println("Matricula: " + cotxe.getMatricula());
                        System.out.println("---------");
                    }

                } catch (EOFException eo) {}
                dataInMarca.close();//Tanca el stream d'entrada

                dataOuMarca.close();//Tanca el stream de sortida

                break;

            case 2:
                System.out.println("Que campo quieres buscar?");
                System.out.println("1 - Marca | 2 - Model | 3 - Any | 4 - Matricula");
                opcion = teclado.nextInt();

                // Switch de los campos dados al usuario
                switch (opcion) {
                    case 1:
                        System.out.println("Introduce el nombre de la marca");
                        String marca = teclado.next();

                        try {

                            while (true){//Llegeix el fitxer

                                //Llegeix el cotxe
                                cotxe = (Cotxe) dataInMarca.readObject();

                                // Si hay coches en los que el campo marca coincida con la marca que ha dado el usuario los muestra con sus datos
                                if (cotxe.getMarca().equalsIgnoreCase(marca)) {
                                    System.out.println("Cotxe: " + cotxe.getMarca());
                                    System.out.println("Model: " + cotxe.getModelo());
                                    System.out.println("Any: " + cotxe.getAny());
                                    System.out.println("Matricula: " + cotxe.getMatricula());
                                    System.out.println("---------");
                                }
                            }
                        } catch (EOFException eo) {}
                        dataInMarca.close();//Tanca el stream d'entrada

                        dataOuMarca.close();//Tanca el stream de sortida
                        break;

                    case 2:
                        System.out.println("Introduce el nombre de el modelo");
                        String model = teclado.next();

                        try {

                            while (true){//Llegeix el fitxer

                                //Llegeix el cotxe
                                cotxe = (Cotxe) dataInMarca.readObject();

                                // Si hay coches en los que el campo modelo coincida con la marca que ha dado el usuario los muestra con sus datos
                                if (cotxe.getModelo().equalsIgnoreCase(model)) {
                                    System.out.println("Cotxe: " + cotxe.getMarca());
                                    System.out.println("Model: " + cotxe.getModelo());
                                    System.out.println("Any: " + cotxe.getAny());
                                    System.out.println("Matricula: " + cotxe.getMatricula());
                                    System.out.println("---------");
                                }
                            }
                        } catch (EOFException eo) {}
                        dataInMarca.close();//Tanca el stream d'entrada

                        dataOuMarca.close();//Tanca el stream de sortida
                        break;

                    case 3:
                        System.out.println("Introduce el nombre de el año");
                        int any = teclado.nextInt();

                        try {

                            while (true){//Llegeix el fitxer

                                //Llegeix el cotxe
                                cotxe = (Cotxe) dataInMarca.readObject();

                                // Si hay coches en los que el campo año coincida con la marca que ha dado el usuario los muestra con sus datos
                                if (cotxe.getAny() == any) {
                                    System.out.println("Cotxe: " + cotxe.getMarca());
                                    System.out.println("Model: " + cotxe.getModelo());
                                    System.out.println("Any: " + cotxe.getAny());
                                    System.out.println("Matricula: " + cotxe.getMatricula());
                                    System.out.println("---------");
                                }
                            }
                        } catch (EOFException eo) {}
                        dataInMarca.close();//Tanca el stream d'entrada

                        dataOuMarca.close();//Tanca el stream de sortida
                        break;

                    case 4:
                        System.out.println("Introduce el nombre de la matricula");
                        String matricula = teclado.next();

                        try {

                            while (true){//Llegeix el fitxer

                                //Llegeix el cotxe
                                cotxe = (Cotxe) dataInMarca.readObject();

                                // Si hay coches en los que el campo matricula coincida con la marca que ha dado el usuario los muestra con sus datos
                                if (cotxe.getMatricula().equalsIgnoreCase(matricula)) {

                                    System.out.println("Cotxe: " + cotxe.getMarca());
                                    System.out.println("Model: " + cotxe.getModelo());
                                    System.out.println("Any: " + cotxe.getAny());
                                    System.out.println("Matricula: " + cotxe.getMatricula());
                                    System.out.println("---------");
                                }
                            }

                        } catch (EOFException eo) {}
                        dataInMarca.close();//Tanca el stream d'entrada

                        dataOuMarca.close();//Tanca el stream de sortida
                        break;

                    default:
                        System.out.println("error 404");
                        break;

                }
                break;

            default:
                System.out.println("error 404");
                break;

        }
    }
}




