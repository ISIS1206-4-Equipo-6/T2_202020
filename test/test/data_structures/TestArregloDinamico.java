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
		for (int i = 0; i < TAMANO; i++) {
			arreglo.agregar(i);
		}
	}

	@Test
	public void testArregloDinamico() {
		setUp1();
		assertTrue(arreglo!=null);
		assertEquals(arreglo.darCapacidad(),100);
		assertEquals(arreglo.darTamano(),0);
	}

	@Test
	public void testDarElemento() {
		setUp2();
		for (int i = 0; i < arreglo.darCapacidad(); i++) {
			assertTrue((Integer)arreglo.darElemento(i+1)==i);
		}
		
	}
	@Test
	public void testInsertElement() {
		setUp2();
		arreglo.insertElement(777, 5);
		assertTrue((Integer)arreglo.darElemento(5)==777);
		assertTrue(arreglo.darTamano()==101);
		arreglo.insertElement(820, 5);
		assertTrue((Integer)arreglo.darElemento(5)==820);
		assertTrue(arreglo.darTamano()==102);
		assertEquals(arreglo.isPresent(820), 5);
	}
	@Test
	public void testRemoveLast() {
		setUp2();
		for (int i = 0; i < arreglo.darCapacidad(); i++) {
			arreglo.removeLast();
			assertTrue(arreglo.darTamano()==100-(i+1));
			assertEquals(arreglo.isPresent(100-(i+1)), -1);
		}
	}
	@Test
	public void testLastElement() {
		setUp2();
		assertTrue((Integer)arreglo.lastElement()==99);
	}
	@Test
	public void testIsPresent() {
		setUp2();
		for (int i = 0; i < arreglo.darTamano(); i++) {
			assertTrue((Integer)arreglo.isPresent(i)==i+1);	
		}
		assertTrue((Integer)arreglo.isPresent(300)==-1);
	}
	@Test
	public void testChangeInfo() {
		setUp2();
		for (int i = 0; i < arreglo.darCapacidad(); i++) {
			arreglo.changeInfo(i+1, 0);
		}
		for (int i = 0; i < arreglo.darCapacidad(); i++) {
			assertTrue((Integer)arreglo.darElemento(i+1)==0);
		}

	}
	@Test
	public void testAddFirst() {
		setUp2();
		arreglo.addFirst(999);
		assertEquals(arreglo.isPresent(999),1);
		assertEquals(arreglo.firstElement(),999);
		assertEquals(arreglo.darTamano(),101);
	}
	

	@Test
	public void testRemoveFirst() {
		setUp2();
		arreglo.removeFirst();
		assertEquals(arreglo.isPresent(0),-1);
		assertEquals(arreglo.firstElement(),1);
		assertEquals(arreglo.darTamano(),99);
	}
 
	@Test
	public void testFirstElement() {
		setUp2();
		assertEquals(arreglo.firstElement(),0);
	}
	
	@Test
	public void testIsEmpty() {
		assertTrue(arreglo.isEmpty());
		setUp2();
		assertFalse(arreglo.isEmpty());
		}

	@Test
	public void testExchange() {
		setUp2();
		int d1=(int) arreglo.darElemento(10);
		int d2=(int) arreglo.darElemento(90);
		arreglo.exchange(10, 90);
		assertEquals(arreglo.darElemento(10),d2);
		assertEquals(arreglo.darElemento(90),d1);
	}

}
