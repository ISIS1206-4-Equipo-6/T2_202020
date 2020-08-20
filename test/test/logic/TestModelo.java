package test.logic;

import static org.junit.Assert.*;
import model.logic.Modelo;

import org.junit.Before;
import org.junit.Test;

public class TestModelo {
	
	private Modelo modelo;
	private static int CAPACIDAD=100;
	
	@Before
	public void setUp1() {
		modelo= new Modelo(CAPACIDAD);
		System.out.println("Llegué aca 1");
	}

	public void setUp2() {
		for(int i =0; i< CAPACIDAD;i++){
			modelo.agregar(i);
		}
	}

	@Test
	public void testModelo() {
		assertTrue(modelo!=null);
		assertEquals(0, modelo.darTamano());  // Modelo con 0 elementos presentes.
	}

	@Test
	public void testDarTamano() {
		// TODO
		setUp2();
		assertTrue(modelo!=null);
		assertEquals(100,modelo.darTamano());
	}

	@Test
	public void testAgregar() {
		// TODO Completar la prueba
		assertTrue(modelo!=null);
		int dato = 2020;
		modelo.agregar(dato);
		assertTrue(modelo.darTamano()>0);
		assertTrue(modelo.buscar(dato)!=null);
	}

	@Test
	public void testBuscar() {
		setUp2();
		int dato = 3;
		assertTrue(modelo.buscar(dato)!=null);
	}

	@Test
	public void testEliminar() {
		setUp2();
//		// TODO Completar la prueba
		int dato = 1;
		System.out.println(modelo.darTamano());
		assertTrue(modelo.eliminar(dato)!=null);
		System.out.println(modelo.darTamano());
		assertEquals(modelo.darTamano(),CAPACIDAD-1);
		assertTrue(modelo.buscar(dato)==null);
		
	}

}
