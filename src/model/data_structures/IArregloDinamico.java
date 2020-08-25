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
	
	void agregar(T dato);
	
	void insertElement(T dato, int pos);
	
	T removeFirst();

	T removeLast();
	
	T lastElement();

	int isPresent(T dato);
	
	void changeInfo(int i, T dato);
	
	void addFirst(T dato);
	
	void exchange(int i, int j);
	
	T firstElement();
	
	boolean isEmpty();
	
	
	

}
