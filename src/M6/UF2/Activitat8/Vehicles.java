package M6.UF2.Activitat8;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Vehicles implements Serializable{
	private static final long serialVersionUID = 1L;	

	@Id @GeneratedValue
	private long id;
	private String matricula;
	private int kilometres;
	private Date dataEntrada;
	private boolean presupostFet;
	private String dniPropietari;

	public Vehicles(String matricula, int kilometres, boolean presupostFet, String dniPropietari) {	
		this.matricula = matricula;
		this.kilometres = kilometres;
		this.dataEntrada = new Date(System.currentTimeMillis());
		this.presupostFet = presupostFet;
		this.dniPropietari = dniPropietari;

	}

	public Vehicles() {

	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public int getKilometres() {
		return kilometres;
	}

	public void setKilometres(int kilometres) {
		this.kilometres = kilometres;
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public boolean isPresupostFet() {
		return presupostFet;
	}

	public void setPresupostFet(boolean presupostFet) {
		this.presupostFet = presupostFet;
	}

	public String getDniPropietari() {
		return dniPropietari;
	}

	public String toString() {
		return "DNI del propietari: " + getDniPropietari() + ", Data entrada: " + getDataEntrada() + 
				", Matricula: " + getMatricula() + ", KM: " + getKilometres() + ", Presupost fet: " + isPresupostFet();
	}

}