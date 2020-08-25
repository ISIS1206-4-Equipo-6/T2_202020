package test.logic;

import static org.junit.Assert.*;

import java.io.IOException;

import model.logic.Modelo;
import mundo.Pelicula;
import mundo.Persona;
import mundo.Persona.Rol;

import org.junit.Before;
import org.junit.Test;

import com.opencsv.exceptions.CsvValidationException;

public class TestModelo {
	
	private Modelo modelo;
	private static int CAPACIDAD=100;
	
	@Before
	public void setUp1() {
		modelo= new Modelo(CAPACIDAD);
	}

	public void setUp2() throws CsvValidationException, IOException {
		modelo = new Modelo(2000);
		modelo.cargarArchivos();

	}
	

	@Test
	public void testModelo() throws CsvValidationException, IOException {
		setUp1();
		assertTrue(modelo!=null);
		assertEquals(0, modelo.darTamano());  
	}

	@Test
	public void testDarTamano() throws CsvValidationException, IOException {
		setUp1();
		assertTrue("El tamaño no corresponde",modelo.darTamano()==0);
		setUp2();
		assertTrue("El tamaño no corresponde",modelo.darTamano()==2000);
	}

	@Test
	public void testAgregar() throws CsvValidationException, IOException {
		setUp1();
		Persona[] actores=new Persona[1];
		Persona director=new Persona("Director1", 1, Rol.DIRECTOR);
		actores[0]=new Persona("Actor1", 1, Rol.ACTOR);
		Pelicula nueva=new Pelicula(1, 2, actores, director, "Pelicula1", 8, 120, "Accion", "es", "29/07/2002");
		modelo.agregar(nueva);
		assertTrue("El tamaño no cambio", modelo.darTamano()==1);
		assertTrue("El elemento no se encontró", modelo.isPresent(nueva)!=-1);
		actores=new Persona[2];
		director=new Persona("Director2", 0, Rol.DIRECTOR);
		actores[0]=new Persona("Actor1", 1, Rol.ACTOR);
		actores[1]=new Persona("Actor2", 0, Rol.ACTOR);
		Pelicula nueva2=new Pelicula(1, 2, actores, director, "Pelicula2", 9, 110, "Accion", "es", "21/07/1995");
		modelo.agregar(nueva2);
		assertTrue("El tamaño no cambio", modelo.darTamano()==2);
		assertTrue("El elemento no se encontró", modelo.isPresent(nueva2)!=-1);
	}
	@Test
	public void testDarCapacidad() throws CsvValidationException, IOException {
		setUp1();
		assertTrue("El tamaño no corresponde",modelo.darCapacidad()==100);
		setUp2();
		assertTrue("El tamaño no corresponde",modelo.darTamano()==2000);
	}
	@Test
	public void isPresent() {
		setUp1();
		Persona[] actores=new Persona[1];
		Persona director=new Persona("Director1", 1, Rol.DIRECTOR);
		actores[0]=new Persona("Actor1", 1, Rol.ACTOR);
		Pelicula nueva=new Pelicula(1, 2, actores, director, "Pelicula1", 8, 120, "Accion", "es", "29/07/2002");
		modelo.agregar(nueva);
		actores=new Persona[2];
		director=new Persona("Director2", 0, Rol.DIRECTOR);
		actores[0]=new Persona("Actor1", 1, Rol.ACTOR);
		actores[1]=new Persona("Actor2", 0, Rol.ACTOR);
		Pelicula nueva2=new Pelicula(1, 2, actores, director, "Pelicula2", 9, 110, "Accion", "es", "21/07/1995");
		modelo.agregar(nueva2);
		assertTrue("El elemento no se encontró", modelo.isPresent(nueva)!=-1);
		assertTrue("El elemento no se encontró", modelo.isPresent(nueva2)!=-1);
	}
	@Test
	public void firstElement() {
		setUp1();
		Persona[] actores=new Persona[1];
		Persona director=new Persona("Director1", 1, Rol.DIRECTOR);
		actores[0]=new Persona("Actor1", 1, Rol.ACTOR);
		Pelicula nueva=new Pelicula(1, 2, actores, director, "Pelicula1", 8, 120, "Accion", "es", "29/07/2002");
		modelo.agregar(nueva);
		actores=new Persona[2];
		director=new Persona("Director2", 0, Rol.DIRECTOR);
		actores[0]=new Persona("Actor1", 1, Rol.ACTOR);
		actores[1]=new Persona("Actor2", 0, Rol.ACTOR);
		Pelicula nueva2=new Pelicula(1, 2, actores, director, "Pelicula2", 9, 110, "Accion", "es", "21/07/1995");
		modelo.agregar(nueva2);
		assertTrue("El elemento no se encontró", modelo.firstElement().equals(nueva));
	}
	@Test
	public void lastElement() {
		setUp1();
		Persona[] actores=new Persona[1];
		Persona director=new Persona("Director1", 1, Rol.DIRECTOR);
		actores[0]=new Persona("Actor1", 1, Rol.ACTOR);
		Pelicula nueva=new Pelicula(1, 2, actores, director, "Pelicula1", 8, 120, "Accion", "es", "29/07/2002");
		modelo.agregar(nueva);
		actores=new Persona[2];
		director=new Persona("Director2", 0, Rol.DIRECTOR);
		actores[0]=new Persona("Actor1", 1, Rol.ACTOR);
		actores[1]=new Persona("Actor2", 0, Rol.ACTOR);
		Pelicula nueva2=new Pelicula(1, 2, actores, director, "Pelicula2", 9, 110, "Accion", "es", "21/07/1995");
		modelo.agregar(nueva2);
		assertTrue("El elemento no se encontró", modelo.lastElement().equals(nueva2));
	}

}
