package controller;

import java.io.IOException;
import java.util.Scanner;
import com.opencsv.exceptions.CsvValidationException;
import model.logic.Modelo;
import mundo.Pelicula;
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
				modelo=new Modelo(1,2000);
				modelo.cargarArchivos();
				view.printMessage("-- La información se ha cargado exitosamente. Tiempo tomado: "+((System.nanoTime()-time)/1000000)+" milisegundos -- \n");
				view.printMessage("----------------- !BIENVENIDO¡ -----------------");
				view.printMessage("--------- Explorando la magia del cine --------- ");
				Pelicula primera=modelo.firstElement();
				Pelicula segunda=modelo.lastElement();
				view.printMessage("Se han encontrado "+modelo.size()+" registros de películas.");
				view.printMessage("Primera película cargada:\n	ID: "+primera.darId()+"\n	Nombre: "+primera.darTituloOriginal()+"\n	Director: "+primera.darDirector().darNombre()+"\n	Votación: "+primera.darVotoPromedio()+"\n	Duración: "+primera.darDuracion()+" minutos\n	Generos: "+primera.darGenres()+"\n	Idioma: "+primera.darLenguajeOriginal());
				view.printMessage("Ultima película cargada:\n	ID: "+segunda.darId()+"\n	Nombre: "+segunda.darTituloOriginal()+"\n	Director: "+segunda.darDirector().darNombre()+"\n	Votación: "+segunda.darVotoPromedio()+"\n	Duración: "+segunda.darDuracion()+" minutos\n	Generos: "+segunda.darGenres()+"\n	Idioma: "+segunda.darLenguajeOriginal());
				break;
			case 2:
				long time2=System.nanoTime();
				view.printMessage("----------------------- La información se esta cargando -----------------------");
				modelo=null;
				modelo=new Modelo(0,2000);
				modelo.cargarArchivos();
				view.printMessage("-- La información se ha cargado exitosamente. Tiempo tomado: "+((System.nanoTime()-time2)/1000000)+" milisegundos -- \n");
				view.printMessage("----------------- !BIENVENIDO¡ -----------------");
				view.printMessage("--------- Explorando la magia del cine --------- ");
				Pelicula primera2=modelo.firstElement();
				Pelicula segunda2=modelo.lastElement();
				view.printMessage("Se han encontrado "+modelo.size()+" registros de películas.");
				view.printMessage("Primera película cargada:\n	ID: "+primera2.darId()+"\n	Nombre: "+primera2.darTituloOriginal()+"\n	Director: "+primera2.darDirector().darNombre()+"\n	Votación: "+primera2.darVotoPromedio()+"\n	Duración: "+primera2.darDuracion()+" minutos\n	Generos: "+primera2.darGenres()+"\n	Idioma: "+primera2.darLenguajeOriginal());
				view.printMessage("Ultima película cargada:\n	ID: "+segunda2.darId()+"\n	Nombre: "+segunda2.darTituloOriginal()+"\n	Director: "+segunda2.darDirector().darNombre()+"\n	Votación: "+segunda2.darVotoPromedio()+"\n	Duración: "+segunda2.darDuracion()+" minutos\n	Generos: "+segunda2.darGenres()+"\n	Idioma: "+segunda2.darLenguajeOriginal());
				break;
//			case 3:
//				if(modelo!=null) {
//					view.printMessage("Inserte el nombre del director a buscar: ");
//					String nombreDirector=lector.nextLine();
//					System.out.println(modelo.buenasPeliculas(nombreDirector.strip()));
//				}else {
//					view.printMessage("Antes de buscar buenas pelicula por favor cargue la información de las películas.");
//				}
//				break;
			case 3:
				if(modelo!=null) {
					System.out.println(modelo.peorPromedio(20));
				}else {
					view.printMessage("Antes de buscar las 20 películas con peor promedio por favor cargue la información de las películas.");
				}
				break;
			case 4: 
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
