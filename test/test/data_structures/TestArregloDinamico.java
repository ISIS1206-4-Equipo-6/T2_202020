package test.data_structures;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.data_structures.ArregloDinamico;




public class TestArregloDinamico {

	private ArregloDinamico arreglo;
	private static int TAMANO=100;
	
	@Before
	public void setUp1() {
		arreglo= new ArregloDinamico(TAMANO);
	}

	public void setUp2() {

	}

	@Test
	public void testArregloDinamico() {
		// TODO
		assertTrue(arreglo!=null);
		assertEquals(arreglo.darCapacidad(),100);
		assertEquals(arreglo.darTamano(),0);
	}

	@Test
	public void testDarElemento() {
		setUp2();
		// TODO
		assertEquals(arreglo.darCapacidad(),200);
		assertEquals(arreglo.darTamano(),200);
		assertEquals(arreglo.darElemento(199),199);
		
	}

}
