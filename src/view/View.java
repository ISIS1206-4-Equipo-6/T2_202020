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
		System.out.println("Por favor inserte una opci�n: ");
		System.out.println("1. Cargar informaci�n en lista encadenada");
		System.out.println("2. Cargar informaci�n en arreglo din�mico");
		System.out.println("3. Encontrar las 20 pel�culas con peor promedio de votaci�n (vote_average)");
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
