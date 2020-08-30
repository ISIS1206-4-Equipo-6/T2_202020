package mundo;
public class Pelicula implements Comparable<Pelicula>{
	private int id;
	private int numeroActores;
	private Persona[] actores;
	private Persona director;
	private String genres;
	private String lenguajeOriginal;
	private String tituloOriginal;
	private String fechaLanzamiento;
	private int duracion;
	private String idiomaHablado;
	private float votoPromedio;
	
	public Pelicula(int pId, int pNumeroActores, Persona[] pActores, Persona pDirector, String pTituloOriginal, float pVotoPromedio, int pDuracion, String pGenero, String pIdioma, String pFecha) {
		id=pId;
		numeroActores=pNumeroActores;
		director=pDirector;
		actores=pActores;
		tituloOriginal=pTituloOriginal;
		votoPromedio=pVotoPromedio;
		duracion=pDuracion;
		genres= pGenero;
		lenguajeOriginal=pIdioma;
		fechaLanzamiento=pFecha;
	}
	
	public String darGenres() {
		return genres;
	}
	public String darLenguajeOriginal() {
		return lenguajeOriginal;
	}
	public String darTituloOriginal() {
		return tituloOriginal;
	}
	public String darFechaLanzamiento() {
		return fechaLanzamiento;
	}
	public int darDuracion() {
		return duracion;
	}
	public String darIdiomaHablado() {
		return idiomaHablado;
	}
	public float darVotoPromedio() {
		return votoPromedio;
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
	public String darNombreActores() {
		String s="";
		for (int i = 0; i < actores.length; i++) {
			if(actores[i]!=null) {
				if(i==actores.length-1) {
					s+=actores[i];
				}else {
					s+=actores[i].darNombre()+", ";
				}
			}
		}
		return s;
	}

	@Override
	public int compareTo(Pelicula o) {
		return (this.votoPromedio==o.votoPromedio)?0:(this.votoPromedio<o.votoPromedio?-1:1);
	}
	

} 