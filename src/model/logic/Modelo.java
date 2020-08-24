package model.logic;
import model.data_structures.ArregloDinamico;
import model.data_structures.IArregloDinamico;
import mundo.Pelicula;

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
	
	/**
	 * Servicio de consulta de numero de elementos presentes en el modelo 
	 * @return numero de elementos presentes en el modelo
	 */
	public int darTamano()
	{
		return datos.darTamano();
	}

	/**
	 * Requerimiento de agregar dato
	 * @param dato
	 */
	public void agregar(Pelicula dato)
	{	
		datos.agregar(dato);
	}
	
	/**
	 * Requerimiento buscar dato
	 * @param dato Dato a buscar
	 * @return 
	 * @return dato encontrado
	 */
	public Pelicula buscar(Pelicula dato)
	{
		return  datos.buscar(dato);
	}
	
	/**
	 * Requerimiento eliminar dato
	 * @param dato Dato a eliminar
	 * @return dato eliminado
	 */
	public Pelicula eliminar(Pelicula dato)
	{
		return datos.eliminar(dato);
	}
	
	public void asd(Pelicula numero, int pos) {
		 datos.insertElement(numero, pos);
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
		for (int i = 0; i < datos.darTamano(); i++) {
			Pelicula peli=(Pelicula)datos.darElemento(i);
			if(peli.darDirector().darNombre().equalsIgnoreCase(pDirector)) {
				promedioTotal+=peli.getVotoPromedio();
				numeroTotal++;
				if(peli.getVotoPromedio()>=6) 
				{
					numeroBuenas++;
					mensajeFinal+="Pelicula "+numeroBuenas+": \n";
					mensajeFinal+=("	ID: "+peli.darId()+"\n	Titulo Original: "+ peli.getTituloOriginal()+"\n	Generos: "+peli.getGenres()+"\n	Fecha de lanzamiento: "+peli.getFechaLanzamiento()+"\n	Actores: "+ peli.darNombreActores() +"\n	Votación: "+peli.getVotoPromedio()+"\n");
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
}
