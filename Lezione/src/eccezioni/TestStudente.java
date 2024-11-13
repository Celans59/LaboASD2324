package eccezioni;

public class TestStudente {
	public static void main(String args[]) {
		Persona A = new Studente("Mario","Rossi",29.2,10);

		A.setContinent(Continente.EUROPA);
		A.setAge(20);

		System.out.println(A.getInfo());

		try {
			A.setAge(-10);
		} catch(IllegalAgeException e) {
			System.err.println(e);
			System.exit(0);
		}

		A.setAge(-15);

		System.out.println(A.getInfo());
	}
}
