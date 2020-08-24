package mundo;
public class Pelicula implements Comparable<Pelicula>{
	private int id;
	private int numeroActores;
	private int numeroDirectores;
	private int numeroProductores;
	private Persona[] actores;
	private Persona director;
	private Persona productor;
	private Persona guionista;
	private Persona editor;
	private String genres;
	private int presupuesto;
	private String imdb_id;
	private String lenguajeOriginal;
	private String tituloOriginal;
	private String overview;
	private float popularidad;
	private String compañia;
	private String fechaLanzamiento;
	private int dineroReunido;
	private int duracion;
	private String idiomaHablado;
	private String status;
	private String tag;
	private String titulo;
	private float votoPromedio;
	private int conteoVotos;
	private int numCompanias;
	private int numPaiesesProd;
	private int numLenguajes;
	public Pelicula(int pId, int pNumeroActores, int pNumeroDirectores, int numeroProductores, Persona[] pActores, Persona pDirector, Persona pProductor, Persona pGuionista, Persona pEditor, String pTituloOriginal, float pVotoPromedio, int pDuracion, String pGenero, String pIdioma, String pFecha) {
		id=pId;
		numeroActores=pNumeroActores;
		numeroDirectores=pNumeroDirectores;
		director=pDirector;
		productor=pProductor;
		guionista=pGuionista;
		editor=pEditor;
		actores=pActores;
		tituloOriginal=pTituloOriginal;
		votoPromedio=pVotoPromedio;
		duracion=pDuracion;
		genres= pGenero;
		lenguajeOriginal=pIdioma;
		fechaLanzamiento=pFecha;
	}
	public String getGenres() {
		return genres;
	}
	public int getPresupuesto() {
		return presupuesto;
	}
	public String getImdb_id() {
		return imdb_id;
	}
	public String getLenguajeOriginal() {
		return lenguajeOriginal;
	}
	public String getTituloOriginal() {
		return tituloOriginal;
	}
	public String getOverview() {
		return overview;
	}
	public float getPopularidad() {
		return popularidad;
	}
	public String getCompañia() {
		return compañia;
	}
	public String getFechaLanzamiento() {
		return fechaLanzamiento;
	}
	public int getDineroReunido() {
		return dineroReunido;
	}
	public int getDuracion() {
		return duracion;
	}
	public String getIdiomaHablado() {
		return idiomaHablado;
	}
	public String getStatus() {
		return status;
	}
	public String getTag() {
		return tag;
	}

	public String getTitulo() {
		return titulo;
	}
	public float getVotoPromedio() {
		return votoPromedio;
	}
	public int getConteoVotos() {
		return conteoVotos;
	}
	public int getNumCompanias() {
		return numCompanias;
	}
	public int getNumPaiesesProd() {
		return numPaiesesProd;
	}
	public int getNumLenguajes() {
		return numLenguajes;
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
	public String darNombreActores() {
		String s=actores[0].darNombre();
		for (int i = 1; i < actores.length; i++) {
			if(actores[i]!=null) {
				s+=", "+actores[i].darNombre();
			}
		}
		return s;
	}
	@Override
	public int compareTo(Pelicula o) {
		// TODO Auto-generated method stub
		return 0;
	}
} 