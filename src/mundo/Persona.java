package mundo;

public class Persona {
	public static enum Rol{
		ACTOR,
		DIRECTOR,
		PRODUCTOR,
		GUIONISTA,
		EDITOR
	}
	private Rol rol;
	private String nombre;
	private int genero;

	public Persona(String pNombre, int pGenero, Rol pRol) {
		nombre=pNombre;
		genero=pGenero;
		rol=pRol;
	}
	
	public String darNombre() {
		return nombre;
	}
	
	public int darGenero() {
		return genero;
	}
	public Rol darRol() {
		return rol;
	}
}
