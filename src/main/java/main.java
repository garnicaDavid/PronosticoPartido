
public class main {
	
	public static void main(String[] args) {
		
	//Este metodo muestra todas las rondas y sus resultados
		Ronda verRondas = new Ronda (null, null);
		verRondas = verRondas.metodoRonda();

	//La logica compara los resultados con el pronostico;
		Logica logica = new Logica();
		logica.leerDesdeTxt();

	}
 }


