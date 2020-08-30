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
			arreglo.addLast(i);
		}
	}

	@Test
	public void testArregloDinamico() {
		setUp1();
		assertTrue(arreglo!=null);
		assertEquals(arreglo.darCapacidad(),100);
		assertEquals(arreglo.size(),0);
	}

	@Test
	public void testgetElement() {
		setUp2();
		for (int i = 0; i < arreglo.darCapacidad(); i++) {
			assertTrue((Integer)arreglo.getElement(i+1)==i);
		}
		
	}
	@Test
	public void testInsertElement() {
		setUp2();
		arreglo.insertElement(777, 5);
		assertTrue((Integer)arreglo.getElement(5)==777);
		assertTrue(arreglo.size()==101);
		arreglo.insertElement(820, 5);
		assertTrue((Integer)arreglo.getElement(5)==820);
		assertTrue(arreglo.size()==102);
		assertEquals(arreglo.isPresent(820), 5);
	}
	@Test
	public void testRemoveLast() {
		setUp2();
		for (int i = 0; i < arreglo.darCapacidad(); i++) {
			arreglo.removeLast();
			assertTrue(arreglo.size()==100-(i+1));
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
		for (int i = 0; i < arreglo.size(); i++) {
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
			assertTrue((Integer)arreglo.getElement(i+1)==0);
		}

	}
	@Test
	public void testAddFirst() {
		setUp2();
		arreglo.addFirst(999);
		assertEquals(arreglo.isPresent(999),1);
		assertEquals(arreglo.firstElement(),999);
		assertEquals(arreglo.size(),101);
	}
	

	@Test
	public void testRemoveFirst() {
		setUp2();
		arreglo.removeFirst();
		assertEquals(arreglo.isPresent(0),-1);
		assertEquals(arreglo.firstElement(),1);
		assertEquals(arreglo.size(),99);
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
		int d1=(int) arreglo.getElement(10);
		int d2=(int) arreglo.getElement(90);
		arreglo.exchange(10, 90);
		assertEquals(arreglo.getElement(10),d2);
		assertEquals(arreglo.getElement(90),d1);
	}

}
