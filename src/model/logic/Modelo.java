package model.logic;
import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import model.data_structures.ArregloDinamico;
import model.data_structures.IArregloDinamico;
import mundo.Pelicula;
import mundo.Persona;
import mundo.Persona.Rol;

/**
 * Definicion del modelo del mundo
 *
 */
@SuppressWarnings("hiding")
public class Modelo{
	/**
	 * Atributos del modelo del mundo
	 */
	public IArregloDinamico<Pelicula> datos;
	
	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public Modelo()
	{
		datos = new ArregloDinamico<Pelicula>(7);
	}
	
	/**
	 * Constructor del modelo del mundo con capacidad dada
	 * @param tamano
	 */
	public Modelo(int capacidad)
	{
		datos = new ArregloDinamico<Pelicula>(capacidad);
	}
	
	
	public void cargarArchivos() throws CsvValidationException, IOException {
		CSVParser csvParser = new CSVParserBuilder().withSeparator(';').build();
		CSVReader reader = new CSVReaderBuilder(new FileReader("data/MoviesCastingRaw-small.csv")).withCSVParser(csvParser).build();
		CSVReader reader2 = new CSVReaderBuilder(new FileReader("data/SmallMoviesDetailsCleaned.csv")).withCSVParser(csvParser).build();
		String [] nextLine;
		String [] nextLine2;
		reader.readNext();
		reader2.readNext();
		while ((nextLine = reader.readNext()) != null && (nextLine2 = reader2.readNext()) != null) {
			int pId=Integer.parseInt(nextLine[0]);
			int pNumeroActores=Integer.parseInt(nextLine[11]);
			String pTituloOriginal=nextLine2[5].strip();
			float pVotoPromedio=Float.parseFloat(nextLine2[17].strip());
			int pDuracion=Integer.parseInt(nextLine2[12].strip());
			String pGeneros=nextLine2[2].strip();
			String pIdioma=nextLine2[4].strip();
			String pFecha=nextLine2[10].strip();
			Persona[] pActores=((pNumeroActores>=5)?new Persona[5]:new Persona[pNumeroActores]);
			int i=0;
			int pos=1;
			while(i<pActores.length) {
				String nombre=nextLine[pos];
				if(!nombre.equals("none")) {
					pActores[i]=new Persona(nombre, Integer.parseInt(nextLine[pos+1]),  Rol.ACTOR);
					i++;
				}
				pos+=2;
				if(pos>10) {
					break;
				}
			}
			Persona pDirector=new Persona(nextLine[12], Integer.parseInt(nextLine[13]), Rol.DIRECTOR);
			agregar(new Pelicula(pId, pNumeroActores, pActores, pDirector, pTituloOriginal, pVotoPromedio, pDuracion, pGeneros, pIdioma, pFecha));
		}
	}
	/**
	 * Servicio de consulta de numero de elementos presentes en el modelo 
	 * @return numero de elementos presentes en el modelo
	 */
	public int darTamano()
	{
		return datos.darTamano();
	}
	
	public int darCapacidad() {
		return datos.darCapacidad();
	}	
	
	public int isPresent(Pelicula element) {
		return datos.isPresent(element);
	}
	
	public Pelicula firstElement() {
		return datos.firstElement();
	}
	
	public Pelicula lastElement() {
		return datos.lastElement();
	}
	public String buenasPeliculas(String pDirector) {
		String mensajeFinal="";
		float promedioTotal=0;
		int numeroTotal=0;
		int numeroBuenas=0;
		for (int i = 1; i <= datos.darTamano(); i++) {
			Pelicula peli=(Pelicula)datos.darElemento(i);
			if(peli.darDirector().darNombre().equalsIgnoreCase(pDirector)) {
				promedioTotal+=peli.darVotoPromedio();
				numeroTotal++;
				if(peli.darVotoPromedio()>=6) 
				{
					numeroBuenas++;
					mensajeFinal+="Pelicula "+numeroBuenas+": \n";
					mensajeFinal+=("	ID: "+peli.darId()+"\n	Titulo Original: "+ peli.darTituloOriginal()+"\n	Generos: "+peli.darGenres()+"\n	Fecha de lanzamiento: "+peli.darFechaLanzamiento()+"\n	Actores: "+ peli.darNombreActores() +"\n	Votación: "+peli.darVotoPromedio()+"\n");
				}
			}
		}
		if(numeroTotal>0) {
		mensajeFinal=("\nEl director "+pDirector+" tiene "+numeroBuenas+" buenas peliculas.\nEl promedio de la votación de todas las peliculas encontradas de dicho director fue: "+promedioTotal/numeroTotal+"\nLas buenas películas se muestran a continuación:\n")+mensajeFinal;
		}else {
			mensajeFinal="El director "+pDirector+" no se encuentra en los registros.";
		}
		return mensajeFinal;
	}
	
	public void agregar(Pelicula dato)
	{	
		datos.agregar(dato);
	}
}
