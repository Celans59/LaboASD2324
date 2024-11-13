package eccezioni;

public class Studente extends Persona {
	private double media;
	private int esami;
	
	public Studente(String nome, String cognome) {
		super(nome,cognome);	
	}

	public Studente(String nome, String cognome, int anni, Continente continente) {
		super(nome,cognome,anni,continente);
	}

	public Studente(String nome, String cognome, double media, int esami) {
		super(nome,cognome);
		this.media = media;
		this.esami = esami;
	}

	public void setNumExams(int esami) throws IllegalArgumentException {
		if(esami < 0)
			throw new IllegalArgumentException("Il numero di esami deve essere >= 0");
		this.esami = esami;
	}
	
	public void setAvgGrade(double media) throws IllegalArgumentException {
		if(media < 18 || media > 30)
			throw new IllegalArgumentException("La media deve essere compresa tra 18 e 30");
		this.media = media;
	}
	
	public int getNumExams() {
		return esami;
	}

	public double getAvgGrade() {
		return media;
	}

	@Override
	public String getInfo() {
		return "Mi chiamo " + nome + " " + cognome + " ho " + anni + " anni e vivo in " + continente + ". Ho sostenuto " + esami + " esami con media " + media;
	}
}
