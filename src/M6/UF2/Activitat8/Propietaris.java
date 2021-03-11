package M6.UF2.Activitat8;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Propietaris implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue
	private long id;
	private String nom;
	private String dni;


	public Propietaris(String nom, String dni) {
		this.nom = nom;
		this.dni = dni;
	}

	public Propietaris() {

	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String toString() {
		return "Nom: " + getNom() + ", DNI: " + getDni();
	}

}
