/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M6.UF1.Activitat6;

//import exempleJAXB.*;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
class Pelicules {
	
	private Pelicula[] pelicules;
 
	
	public Pelicula[] getPelicules() {
		return pelicules;
	}
	public void setPelicules(Pelicula[] pelicules) {
		this.pelicules = pelicules;
	}
 
}
