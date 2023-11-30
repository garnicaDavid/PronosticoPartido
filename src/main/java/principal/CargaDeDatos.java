package principal;
import java.util.ArrayList;
import java.util.List;

import lectorSql.LeerDesdeBaseDeDatos;

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
		
		LeerDesdeBaseDeDatos resultadosSql = new LeerDesdeBaseDeDatos();
		ArrayList<String> datosResultados = new ArrayList<String> (resultadosSql.getResultadosSql());
		
			//Para leer desde txt descomentar renglon 28-29 y comentar los renglones 23-24 
		
		//Lectura lecturaDeResultados = new Lectura ();
		//ArrayList<String> datosResultados = new ArrayList<String> (lecturaDeResultados.getLecturaResultado());
				
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
		
			//Para leer desde txt descomentar y comentar lineas 58 y 59
		//Lectura lecturaDePronosticos = new Lectura ();
		//ArrayList<String> datosPronosticos = new ArrayList<String> (lecturaDePronosticos.getLecturaPronostico());
		
		LeerDesdeBaseDeDatos lecturaSql = new LeerDesdeBaseDeDatos();
		ArrayList<String> datosPronosticos = new ArrayList<String> (lecturaSql.getPronosticosSql());
		
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
		
		LeerDesdeBaseDeDatos lecturaSql = new LeerDesdeBaseDeDatos();
		ArrayList<String> datosConfiguracion = new ArrayList<String> (lecturaSql.getConfiguracionSql());
		
			//Para leer desde txt descomentar y comentar lineas 89/90
		
		//Lectura lecturaDeConfiguracion = new Lectura ();
		//List<String> datosConfiguracion = new ArrayList<String> (lecturaDeConfiguracion.getLecturaConfiguracion());
		
		
 		for(String linea : datosConfiguracion) {
 			String texto[]=linea.split(" ");
 			String puntos = texto[1];
 			this.datosDeConfiguracion.add(Integer.parseInt(puntos));
 		}
		return datosDeConfiguracion;
	}
}
