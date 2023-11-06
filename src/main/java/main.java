import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class main {

	public static void main(String[] args) {
		
		Ronda rondaActual = new Ronda (null, null);
		rondaActual = rondaActual.metodoRonda();

		//La logica compara los resultados con el pronostico;
		Logica logica = new Logica();
		logica.numeroDeRonda();
		

	}
		 }


