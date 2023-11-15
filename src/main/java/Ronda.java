
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
	Lectura lecturaDeResultados = new Lectura();
	List <Ronda> rondas = new ArrayList<>();
	Ronda rondaActual = null;
	int numeroRonda = 1;
	
		try {
			for (String linea : lecturaDeResultados.getLecturaResultado()) {
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
			                
			            }

			            rondaActual.agregarPartido(partido.metodoPartido());
			        
			    }
			        numeroRonda++;
			}
			
			
			
		} catch (NumberFormatException e) {
			
			e.printStackTrace();
		}
		return rondaActual;	
	
		
		}


	@Override
	public String toString() {
		return "Ronda [nro=" + nro + ", partidos=" + partidos + "]";
	}
}

