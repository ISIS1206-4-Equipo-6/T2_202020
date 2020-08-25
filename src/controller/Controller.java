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
	}
		
	public Modelo darModelo()
	{
		return modelo;
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
				case 1:
					long time=System.nanoTime();
					view.printMessage("----------------------- La información se esta cargando -----------------------");
					modelo=null;
					modelo=new Modelo(2000);
					modelo.cargarArchivos();
					view.printMessage("-- La información se ha cargado exitosamente. Tiempo tomado: "+((System.nanoTime()-time)/1000000)+" milisegundos -- \n");
					view.printMessage("----------------- !BIENVENIDO¡ -----------------");
					view.printMessage("--------- Explorando la magia del cine --------- ");
					Pelicula primera=modelo.firstElement();
					Pelicula segunda=modelo.lastElement();
					view.printMessage("Se han encontrado "+modelo.darCapacidad()+" registros de películas.");
					view.printMessage("Primera película cargada:\n	ID: "+primera.darId()+"\n	Nombre: "+primera.darTituloOriginal()+"\n	Director: "+primera.darDirector().darNombre()+"\n	Votación: "+primera.darVotoPromedio()+"\n	Duración: "+primera.darDuracion()+" minutos\n	Generos: "+primera.darGenres()+"\n	Idioma: "+primera.darLenguajeOriginal());
					view.printMessage("Ultima película cargada:\n	ID: "+segunda.darId()+"\n	Nombre: "+segunda.darTituloOriginal()+"\n	Director: "+segunda.darDirector().darNombre()+"\n	Votación: "+segunda.darVotoPromedio()+"\n	Duración: "+segunda.darDuracion()+" minutos\n	Generos: "+segunda.darGenres()+"\n	Idioma: "+segunda.darLenguajeOriginal());
					break;
				case 2:
					view.printMessage("Inserte el nombre del director a buscar: ");
					String nombreDirector=lector.nextLine();
					System.out.println(modelo.buenasPeliculas(nombreDirector.strip()));
					break;
				case 3: 
					view.printMessage("--------- \n Hasta pronto !! \n---------"); 
					lector.close();
					fin = true;
					break;	
				default: 
					view.printMessage("------------------- \n ¡Opcion Invalida! \n-------------------");
					break;
			}
		}	
	}	
}
