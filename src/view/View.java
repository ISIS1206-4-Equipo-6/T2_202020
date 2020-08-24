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
		System.out.println("1. Cargar información");
		System.out.println("2. Encontrar buenas peliculas de un director");
		System.out.println("3. Exit");
	}

	public void printMessage(String mensaje) {

		System.out.println(mensaje);
	}

	public void printModelo(Modelo modelo)
	{
		// TODO implementar
		int tam = modelo.darTamano();
		for(int i=0; i<tam; i++)
		{
			printMessage(" "+modelo.datos.darElemento(i).getLenguajeOriginal());
		}
	}
}
