package model.data_structures;

public interface IArregloDinamico  <T extends Comparable<T>> {

	/**
	 * Retornar el numero de elementos maximo en el arreglo
	 * @return
	 */
	int darCapacidad( );

	/**
	 * Retornar el numero de elementos presentes en el arreglo
	 * @return
	 */
	int darTamano( );
	
	/**
	 * Retornar el elemento en la posicion i
	 * @param i posicion de consulta
	 * @return elemento de consulta. null si no hay elemento en posicion.
	 */
	T darElemento( int i );
	
	T firstElement();
	
	T lastElement();
	
	int isPresent(T dato);
	
	public void agregar(T dato);
	
	public void insertElement(T dato, int pos);

}
