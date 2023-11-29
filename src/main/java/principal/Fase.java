package principal;

import java.util.ArrayList;
import java.util.List;

public class Fase {
	private String nro;
	private List<Ronda> rondas;
	
	public Fase() {
		
		this.nro = nro;
		this.rondas = new ArrayList<>();
	}
	
	
	public String getNro() {
		return nro;
	}


	public void setNro(String nro) {
		this.nro = nro;
	}


	public List<Fase> getRondas(){
		//LeerDesdeBaseDeDatos lecturaSql = new LeerDesdeBaseDeDatos();
		Ronda rondas= new Ronda();
		Lectura lecturaDeResultados = new Lectura();
		ArrayList <Fase> fase = new ArrayList<>();
		Fase faseActual = null;
		int numeroFase = 0;
		
			try {
				for (String linea : lecturaDeResultados.getLecturaResultado()) {
						String[] datos = linea.split(" ");
							
						if (datos.length == 6) {
				            

				            if (faseActual == null || Integer.parseInt(datos[5])  != numeroFase) {
				               
				            	faseActual = new Fase();
				                fase.add(faseActual);
				                faseActual.setNro(datos[5]);
				                
				            }

				            faseActual.setRondas(rondas);
				    }
					
				}
			}catch (NumberFormatException e) {
				
				e.printStackTrace();
			}
		return fase;
	}


	@Override
	public String toString() {
		return "Fase [nro=" + nro + ", rondas=" + rondas + "]";
	}


	public void setRondas(Ronda totalRondas) {
		rondas.add(totalRondas);
	}

	
	public ArrayList<Integer> cantidadDeRondasPorFase() {
		
		Fase fase=new Fase ();
	 	ArrayList<Fase> datosFase = new ArrayList<>(fase.getRondas());
	 	int cantidadDeRondas = 0;
	 	int numeroDeFaseActual=1;
	 	int numeroDeFaseAnterior =1;
	 	ArrayList <Integer> cantidadDeRondasPorFase = new ArrayList <>();

	 	for (Fase linea : datosFase) {
	 		numeroDeFaseActual = Integer.parseInt(linea.getNro());
	 		
	 		if(numeroDeFaseAnterior!=numeroDeFaseActual){
	 			cantidadDeRondasPorFase.add(cantidadDeRondas);
	 			cantidadDeRondas = 1;
	 			
	 			numeroDeFaseAnterior = Integer.parseInt(linea.getNro());
	 		}else {
	 			cantidadDeRondas++;
	 		}
	 		
	 	 
			
		}
	 	cantidadDeRondasPorFase.add(cantidadDeRondas);
	
		return (ArrayList<Integer>) cantidadDeRondasPorFase;
	}
	
}
