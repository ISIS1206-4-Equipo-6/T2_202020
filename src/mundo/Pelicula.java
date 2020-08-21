package mundo;

public class Pelicula {

	private int id;
	private int numeroActores;
	private int numeroDirectores;
	private int numeroProductores;
	private Persona[] actores;
	private Persona director;
	private Persona productor;
	private Persona guionista;
	private Persona editor;
	
	public Pelicula(int pId, int pNumeroActores, int pNumeroDirectores, int numeroProductores, Persona[] pActores, Persona pDirector, Persona pProductor, Persona pGuionista, Persona pEditor) {
		id=pId;
		numeroActores=pNumeroActores;
		numeroDirectores=pNumeroDirectores;
		director=pDirector;
		productor=pProductor;
		guionista=pGuionista;
		editor=pEditor;
		actores=pActores;
		imprimir();
		// ((numeroActores>=5)?new Persona[5]:new Persona[numeroActores]);
	}
	
	public int darId() {
		return id;
	}
	
	public int darNumeroActores() {
		return numeroActores;
	}
	
	public Persona[] darActores() {
		return actores;
	}
	
	public Persona darDirector() {
		return director;
	}
	
	public Persona darProductor() {
		return productor;
	}
	
	public Persona darGuionista() {
		return guionista;
	}
	
	public Persona darEditor() {
		return editor;
	}
	
	public void imprimir() {
		for (int i = 0; i < actores.length; i++) {
			System.out.println(actores[i].darNombre());
		}
	}
	
}
