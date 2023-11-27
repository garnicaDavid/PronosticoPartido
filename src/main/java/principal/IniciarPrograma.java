package principal;

public class IniciarPrograma {
	
	public void incioDelPrograma () {
		
	//Este metodo muestra todas las rondas y sus resultados
		Ronda verRondas = new Ronda ();
		verRondas.verRondas();

	//La logica compara los resultados con el pronostico;
		Logica logica = new Logica();
 		logica.leerDesdeSql();
		
	}
 }


