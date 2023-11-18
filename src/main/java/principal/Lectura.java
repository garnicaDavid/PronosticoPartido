package principal;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Lectura {

	private List <String> lecturaArchivos;
	private List <String> lecturaPronostico;
	
		public Lectura () {
			this.lecturaArchivos = new ArrayList <String>();
			this.lecturaPronostico = new ArrayList<String>();
		}

		public List<String> getLecturaResultado() {

			
			String listaDePartidos = "resultados.txt";
			
			try {
				for (String linea : Files.readAllLines(Paths.get(listaDePartidos))) {
					this.lecturaArchivos.add(linea);
					
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			return lecturaArchivos;
		}


		
		public List<String> getLecturaPronostico() {
			
			String listaDePronosticos = "pronostico.txt";
			
			try {
				for (String linea : Files.readAllLines(Paths.get(listaDePronosticos))) {
					this.lecturaPronostico.add(linea);
					
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			return lecturaPronostico;
		}

		
		
	}
		
	