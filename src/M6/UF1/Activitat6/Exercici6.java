/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M6.UF1.Activitat6;


import java.io.File;  
import java.io.FileOutputStream;
import java.io.IOException;
 
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
 
public class Exercici6 {
	
	private static final String PELICULES_XML_FILE = "peliculesDual.xml";
 
	public static void main(String[] args) throws JAXBException, IOException {
		
		JAXBContext context = JAXBContext.newInstance(Pelicules.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
//		Pelicules pelicules = omplePelicules();
//		
//		//Mostrem el document XML generat por la sortida estandard
//		marshaller.marshal(pelicules, System.out);
//		
//		FileOutputStream fos = new FileOutputStream(PELICULES_XML_FILE);
//		//guardem l'objecte serializat en un document XML
//		marshaller.marshal(pelicules, fos);
//		fos.close();
		
		Unmarshaller unmarshaller = context.createUnmarshaller();
		//Deserialitzem a partir de un document XML
		Pelicules peliculesAux = (Pelicules) unmarshaller.unmarshal(new File(PELICULES_XML_FILE));
		System.out.println("********* Pelicules carregat desde fitxer XML***************");
		//Mostrem l'objeto Java obtingut
		marshaller.marshal(peliculesAux, System.out);
		
	}
	
	private static Pelicules omplePelicules(){
		
		String[] titolsPelicules = {"Resacon", "Aristogatos", "Zodiac"};
		String[] duradesPelicules = {"2.40 horas", "1.30 horas", "2.30 horas"};
		String[] estrenosPelicules = {"Enero 2010", "Marzo 2015", "Junio 2013"};
		int[] notesReviews = {7, 9, 10};
		String[] categoriesPelicules = {"humor", "infantil", "misterio"};
		Pelicula[] ArrayPelicules = new Pelicula[3];
		
		for(int i=0; i<ArrayPelicules.length; i++){
			ArrayPelicules[i] = new Pelicula();
			ArrayPelicules[i].setTitol(titolsPelicules[i]);
			ArrayPelicules[i].setDurada(duradesPelicules[i]);
			ArrayPelicules[i].setEstreno(estrenosPelicules[i]);
			ArrayPelicules[i].setNotaReview(notesReviews[i]);
			ArrayPelicules[i].setId(i+1); // A�ado +1 para que el primer elemento tenga "id=1" en vez de 0		
			ArrayPelicules[i].setCategoria(categoriesPelicules[i]);
		}
		
		Pelicules pelicules = new Pelicules();
		pelicules.setPelicules(ArrayPelicules);
		
		return pelicules;
	}
 
}