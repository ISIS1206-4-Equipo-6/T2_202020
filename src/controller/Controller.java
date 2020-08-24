package controller;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import model.logic.Modelo;
import mundo.Pelicula;
import mundo.Persona;
import mundo.Persona.Rol;
import view.View;

public class Controller {

	/* Instancia del Modelo*/
	private Modelo modelo;
	
	/* Instancia de la Vista*/
	private View view;
	
	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new View();
		modelo = new Modelo(2000);
	}
		
	public void run() throws CsvValidationException, IOException 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		while( !fin ){
			view.printMenu();
			int option = lector.nextInt();
			lector.nextLine();
			switch(option){

				case 3: 
					view.printMessage("--------- \n Hasta pronto !! \n---------"); 
					lector.close();
					fin = true;
					break;	
					
				case 1:
					long time=System.nanoTime();
					view.printMessage("-- La información se esta cargando --");
					CSVParser csvParser = new CSVParserBuilder().withSeparator(';').build();
					CSVReader reader = new CSVReaderBuilder(new FileReader("data/MoviesCastingRaw-small.csv")).withCSVParser(csvParser).build();
					CSVReader reader2 = new CSVReaderBuilder(new FileReader("data/SmallMoviesDetailsCleaned.csv")).withCSVParser(csvParser).build();
					String [] nextLine;
					String [] nextLine2;
					//TODO
					reader.readNext();
					reader2.readNext();
					while ((nextLine = reader.readNext()) != null && (nextLine2 = reader2.readNext()) != null) {
						String id=nextLine[0];
						int numeroActores=Integer.parseInt(nextLine[11]);
						int numeroDirectores=Integer.parseInt(nextLine[14]);
						int numeroProductores=Integer.parseInt(nextLine[16].trim());
						String nombrePelicula=nextLine2[5].trim();
						float votacion=Float.parseFloat(nextLine2[17].trim());
						int duracion=Integer.parseInt(nextLine2[12].trim());
						String generos=nextLine2[2].trim();
						String idioma=nextLine2[4].trim();
						String fecha=nextLine2[10].trim();
						Persona[] actores=((numeroActores>=5)?new Persona[5]:new Persona[numeroActores]);
						//TODO revisar for crear actores
						int i=0;
						int pos=1;
						while(i<actores.length) {
							String nombre=nextLine[pos];
							if(!nombre.equals("none")) {
								actores[i]=new Persona(nombre, Integer.parseInt(nextLine[pos+1]),  Rol.ACTOR);
								i++;
							}
							pos+=2;
							if(pos>10) {
								break;
							}
						}
						Persona director=new Persona(nextLine[12], Integer.parseInt(nextLine[13]), Rol.DIRECTOR);
						Persona productor=new Persona(nextLine[15], 0, Rol.PRODUCTOR);
						Persona guionista=new Persona(nextLine[17], 0, Rol.GUIONISTA);
						Persona editor=new Persona(nextLine[18], 0, Rol.EDITOR);
						
						modelo.agregar(new Pelicula(Integer.parseInt(id), numeroActores, numeroDirectores, numeroProductores, actores, director, productor, guionista, editor, nombrePelicula, votacion, duracion, generos, idioma, fecha));
					}
					view.printMessage("-- La información se ha cargado exitosamente. Tiempo tomado: "+((System.nanoTime()-time)/1000000)+" milisegundos -- \n");
					view.printMessage("---------- !BIENVENIDO¡ ----------");
					view.printMessage("-- Bxplorando la magia del cine -- ");
					break;
				case 2:
					view.printMessage("Inserte el nombre del director a buscar: ");
					String nombreDirector=lector.nextLine();
					System.out.println(modelo.buenasPeliculas(nombreDirector));
					break;
				default: 
					view.printMessage("--------- \n Opcion Invalida !! \n---------");
					break;
			}
		}
		
	}	
}
