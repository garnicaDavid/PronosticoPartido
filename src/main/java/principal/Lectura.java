package principal;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Lectura {

	private List <String> lecturaArchivos;
	private List <String> lecturaPronostico;
	private List <String> lecturaConfiguracion;
	private List <String> lecturaPuntaje;
	
		public Lectura () {
			this.lecturaArchivos = new ArrayList <String>();
			this.lecturaPronostico = new ArrayList<String>();
			this.lecturaConfiguracion = new ArrayList<String>();
			this.lecturaPuntaje = new ArrayList<String>();
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
		
		
		
		public List<String> getLecturaConfiguracion() {
			String listaDeConfiguracion = "configuracion.txt";
			try {
				for (String linea : Files.readAllLines(Paths.get(listaDeConfiguracion))) {
					this.lecturaConfiguracion.add(linea);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			return lecturaConfiguracion;
		}
		
		public List<String> getLecturaPuntaje() {
			String listaDePuntaje = "puntajes.txt";
			try {
				for (String linea : Files.readAllLines(Paths.get(listaDePuntaje))) {
					this.lecturaPuntaje.add(linea);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			return lecturaPuntaje;
		}
		
	}
		
	