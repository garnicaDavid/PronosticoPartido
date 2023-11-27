package principal;

import java.util.ArrayList;
import java.util.List;

public class Ronda {
	private String nro;
	private List<Partido> partidos;	
	
	public Ronda() {
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
	
	public ArrayList<Ronda> metodoRonda() {
		
	
	Partido partido = new Partido(null, null, 0, 0);
	Lectura lecturaDeResultados = new Lectura();
	ArrayList <Ronda> rondas = new ArrayList<>();
	Ronda rondaActual = null;
	int numeroRonda = 0;
	
		try {
			for (String linea : lecturaDeResultados.getLecturaResultado()) {
					String[] datos = linea.split(" ");
						
					if (datos.length == 6) {
			            

			            if (rondaActual == null || Integer.parseInt(datos[4])  != numeroRonda) {
			               
							rondaActual = new Ronda();
			                rondas.add(rondaActual);
			                rondaActual.setNro(datos[4]);
			                
			            }

			            rondaActual.agregarPartido(partido.metodoPartido());
			    }
				
			}
		}catch (NumberFormatException e) {
			
			e.printStackTrace();
		}
		return rondas;
		
		}


	@Override
	public String toString() {
		return "Ronda [nro=" + nro + ", partidos=" + partidos + "]";
	}
	
	public void verRondas() {
		
		Lectura lecturaDeResultados = new Lectura();
		int numeroRonda = 0;
		
				for (String linea : lecturaDeResultados.getLecturaResultado()) {
						String[] datos = linea.split(" ");
						
						if (numeroRonda != Integer.parseInt(datos[4])) {
						System.out.println("-----------RONDA "+ datos[4] +"-----------");
						}
						System.out.println("Equipos\t\t|  Cant Goles");
				        System.out.println(datos[0]+"  \t|\t  "+datos[1]);
				        System.out.println(datos[3]+"  \t|\t  "+datos[2]);
				        System.out.print("\n");
				        
				        numeroRonda=Integer.parseInt(datos[4]);
  }
		
		
	}	
	public ArrayList<Integer> cantidadDePartidosPorRonda() {
		Ronda rondas=new Ronda ();
	 	ArrayList<Ronda> datosRonda = new ArrayList<>(rondas.metodoRonda());
	 	int cantidadDePartidos = 0;
	 	int numeroDeRondaActual=1;
	 	int numeroDeRondaAnterior =1;
	 	ArrayList <Integer> cantidadDePartidosPorRonda = new ArrayList <>();

	 	for (Ronda linea : datosRonda) {
	 		numeroDeRondaActual = Integer.parseInt(linea.getNro());
	 		
	 		if(numeroDeRondaAnterior!=numeroDeRondaActual){
	 			cantidadDePartidosPorRonda.add(cantidadDePartidos);
	 			cantidadDePartidos = 1;
	 			
	 			numeroDeRondaAnterior = Integer.parseInt(linea.getNro());
	 		}else {
	 			cantidadDePartidos++;
	 		}
	 		
	 	 
			
		}
	 	cantidadDePartidosPorRonda.add(cantidadDePartidos);
	
		return (ArrayList<Integer>) cantidadDePartidosPorRonda;

	}
	

}

