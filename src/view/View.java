package view;

import model.logic.Modelo;

public class View
{
	/**
	 * Metodo constructor
	 */
	public View()
	{

	}

	public void printMenu()
	{
		System.out.println("Por favor inserte una opción: ");
		System.out.println("1. Cargar información en lista encadenada");
		System.out.println("2. Cargar información en arreglo dinámico");
		System.out.println("3. Encontrar las 20 películas con peor promedio de votación (vote_average)");
		System.out.println("4. Exit");
	}

	public void printMessage(String mensaje) {

		System.out.println(mensaje);
	}

	public void printModelo(Modelo modelo)
	{
		int tam = modelo.size();
		for(int i=0; i<tam; i++)
		{
			printMessage(" "+modelo.datos.getElement(i).darLenguajeOriginal());
		}
	}
}
