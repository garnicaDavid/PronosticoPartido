import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Ronda {
	private String nro;
	private List<Partido> partidos;	
	
	public Ronda(String nro, Partido[] partidos) {
		super();
		this.nro = nro;
		this.partidos = new ArrayList<>();
	}


	public String getNro() {
		return nro;
	}


	public void setNro(String nro) {
		this.nro = nro;
	}


	public List<Partido> getPartidos() {
		return partidos;
	}


	public void agregarPartido(Partido partido) {
        partidos.add(partido);
    }

	public static int puntos() {
		
		return 0;
	}
	public Ronda metodoRonda () {
		
	
	
	Partido partido = new Partido(null, null, 0, 0);
	Ronda ronda = null;
	String listaDePartidos = "resultados.txt";
	int contador = 0;
	List <Ronda> rondas = new ArrayList<>();
	Ronda rondaActual = null;
	int numeroRonda = 1;
	
		try {
			for (String linea : Files.readAllLines(Paths.get(listaDePartidos))) {
					System.out.println("-----------RONDA "+numeroRonda+"-----------");
					System.out.println("Equipos\t\t|  Cant Goles");
			        String[] datos = linea.split(" ");
			        System.out.println(datos[0]+"  \t|\t  "+datos[1]);
			        System.out.println(datos[3]+"  \t|\t  "+datos[2]);
			        System.out.print("\n");
			        if (datos.length == 4) {
			            

			            if (rondaActual == null || Integer.parseInt(rondaActual.getNro())  != numeroRonda) {
			               
							rondaActual = new Ronda(null, null);
			                rondas.add(rondaActual);
			                rondaActual.setNro(String.valueOf(numeroRonda));
			                numeroRonda++;
			            }

			            rondaActual.agregarPartido(partido.metodoPartido());
			        
			    }
			}
			
			
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rondaActual;	
	
		
		}


	@Override
	public String toString() {
		return "Ronda [nro=" + nro + ", partidos=" + partidos + "]";
	}
}

