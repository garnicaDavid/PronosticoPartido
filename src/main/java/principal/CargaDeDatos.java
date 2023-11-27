package principal;
import java.util.ArrayList;
import java.util.List;

public class CargaDeDatos {
	
	private List<Integer> datosDeResultados;
	private List <Persona> datosDePersonas;
	private List <Integer> datosDeConfiguracion;
	
	public CargaDeDatos() {
		this.datosDeResultados = new ArrayList <Integer>();
		this.datosDePersonas = new ArrayList <Persona>();
		this.datosDeConfiguracion = new ArrayList <Integer>();
	}

	public List<Integer> GetDatosDeResultados () {
		
		String [] renglon;
		Lectura lecturaDeResultados = new Lectura ();
		ArrayList<String> datosResultados = new ArrayList<String> (lecturaDeResultados.getLecturaResultado());
				
		try {
			for(String linea : datosResultados){
				
				renglon=linea.split(" ");
			//empataron
			if (Integer.parseInt(renglon[1]) == Integer.parseInt(renglon[2])) {
				this.datosDeResultados.add(1);
				}
			//gano equipo 1
				else if (Integer.parseInt(renglon[1]) > Integer.parseInt(renglon[2])) {
					datosDeResultados.add(2);

					}
			//gano equipo 2
				else if (Integer.parseInt(renglon[1]) < Integer.parseInt(renglon[2])) {
					datosDeResultados.add(3);

					}
			}	
		} catch (NumberFormatException e) {
			
			e.printStackTrace();
		}
		
		return datosDeResultados;
	}

	public List<Persona> getDatosDePersonas () {
		
		Lectura lecturaDePronosticos = new Lectura ();
		ArrayList<String> datosPronosticos = new ArrayList<String> (lecturaDePronosticos.getLecturaPronostico());
		
 		int bandera = 0;
 		int posicion=0;
		
 		for(String linea : datosPronosticos) {
 			String texto[]=linea.split(" ");
 			String nombre = texto[5];
 			if(bandera == 0 || !nombre.equalsIgnoreCase(this.datosDePersonas.get(posicion-1).getNombre()) ) {
 				this.datosDePersonas.add(new Persona(nombre,0));
 				bandera =1;
 	 			posicion++;
 			}
 		}
		return datosDePersonas;
	}
	public List<Integer> getDatosDeConfiguracion() {
		
		Lectura lecturaDeConfiguracion = new Lectura ();
		List<String> datosConfiguracion = new ArrayList<String> (lecturaDeConfiguracion.getLecturaConfiguracion());
		
		
 		for(String linea : datosConfiguracion) {
 			String texto[]=linea.split(" ");
 			String puntos = texto[1];
 			this.datosDeConfiguracion.add(Integer.parseInt(puntos));
 		}
		return datosDeConfiguracion;
	}
}
