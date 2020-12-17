/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M6.UF1.Activitat6;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

//@XmlRootElement
@XmlRootElement(name = "Pelicula")

//@XmlAccessorType(XmlAccessType.FIELD) // This line was added
class Pelicula {

	// Atributs
	private int id;
	private String categoria;

	// Elements
	private int notaReview;	
	private String titol;
	private String durada;
	private String estreno;

	// ATRIBUTOS
	// 	@XmlAttribute(name="id") hace que me a�ada id como atributo y no como elemento
	@XmlAttribute(name="id")        
	public int getId() {
		return this.id;
	}        

	public void setId(int id) {
		this.id = id;
	}
	
	@XmlAttribute(name="categoria") 
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

   // ELEMENTOS
	public String getTitol() {
		return titol;
	}        

	public void setTitol(String titol) {
		this.titol = titol;
	}
  
	public String getDurada() {
		return durada;
	}
	public void setDurada(String Durada) {
		this.durada = Durada;
	}        
   
	public String getEstreno() {
		return estreno;
	}
	public void setEstreno(String Estreno) {
		this.estreno = Estreno;
	}        

	public int getNotaReview() {
		return this.notaReview;
	}
	public void setNotaReview(int notaReview) {
		this.notaReview = notaReview;
	}
	
}
