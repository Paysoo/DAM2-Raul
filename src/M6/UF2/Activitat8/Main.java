package M6.UF2.Activitat8;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Main {

	static Scanner teclado = new Scanner(System.in);
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("magatzem.odb");
	static EntityManager em = emf.createEntityManager();


	public static void main(String[] args) {

		boolean salir = false;

		while (!salir) {
			System.out.println("Introdueix una opci�:");
			System.out.println("1 - Mostrar BD");
			System.out.println("2 - Afegir vehicle i propietari");
			System.out.println("3 - Sortir");
			System.out.println("Opci�:");

			int opcion = teclado.nextInt();
			teclado.nextLine();

			switch (opcion) {

			case 1:
				EnsenyarDades();
				break;

			case 2:
				AfegirDades();
				break;

			case 3:
				salir = true;
				break;

			default:
				System.out.println("Introdueix una opci� valida");
				break;
			}
		}

		// Cierro los EntityManagers
		em.close();
		emf.close();

	}

	// FUNCION PARA ENSE�AR LOS DATOS DE LA BD
	public static void EnsenyarDades() {

		// Recupero todos los objetos de la BD
		TypedQuery<Propietaris> queryPropietaris = em.createQuery("SELECT p FROM Propietaris p", Propietaris.class);
		TypedQuery<Vehicles> queryVehicles = em.createQuery("SELECT v FROM Vehicles v", Vehicles.class);
		List<Propietaris> resultsPropietaris = queryPropietaris.getResultList();
		List<Vehicles> resultsVehicles = queryVehicles.getResultList();

		// Muestro los objetos recuperados
		for (Propietaris p : resultsPropietaris) {
			System.err.println(p);
		}

		for (Vehicles v : resultsVehicles) {
			System.out.println(v);
		}

	}

	// FUNCION PARA A�ADIR DATOS A LA BD
	public static void AfegirDades() {

		Propietaris propietari = new Propietaris();
		Vehicles vehicle = new Vehicles();

		boolean presupostFet = true;
		boolean opcionValida = false;

		// Dades del propietari
		System.out.println("DADES PROPIETARI");
		System.out.println("Introdueix el nom del propietari");
		String nom = teclado.nextLine();
		System.out.println("Introdueix el DNI del propietari");
		String dni = teclado.next();

		// Dades del vehicle
		System.out.println("DADES VEHICLE");
		System.out.println("Introdueix la matricula");
		String matricula = teclado.next();
		System.out.println("Introdueix els kilometres");
		int kilometres = teclado.nextInt();


		do {

			System.out.println("El presupost est� fet?\n1 - Si\\n2 - No");
			System.out.println("Opci�:");
			int opcion = teclado.nextInt();

			switch (opcion) {

			case 1: 
				presupostFet = true;
				opcionValida = true;
				break;

			case 2:
				presupostFet = false;
				opcionValida = true;
				break;

			default: 
				System.out.println("Introdueix una opci� valida");
				opcionValida = false;
				break;

			}

		} while (!opcionValida);


		// Creo los objetos y los meto en la BD
		em.getTransaction().begin();
		propietari = new Propietaris(nom, dni);
		vehicle = new Vehicles(matricula, kilometres, presupostFet, dni);
		em.persist(propietari);
		em.persist(vehicle);
		em.getTransaction().commit();

	}


}