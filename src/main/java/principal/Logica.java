package principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import lectorSql.LeerDesdeBaseDeDatos;

public class Logica {
	
	public Logica() {
	}
	
	public void imprimirPorConsola() {
		int numRondas = verRondas();
		ArrayList<Persona> resultados = new ArrayList<Persona>(mostrarPronostico(numRondas));
		mostrarResultados(resultados);
	}
	

public int verRondas() {
		Lectura lecturaDeResultados = new Lectura();
		int numeroRonda = 0;
		int cantRondas =0;
		int numPartido=1;
			for (String linea : lecturaDeResultados.getLecturaResultado()) {
					String[] datos = linea.split(" ");
					if (numeroRonda != Integer.parseInt(datos[4])) {
						numPartido =1;
						System.out.println("-----------RONDA "+ datos[4] +"-----------");
						System.out.println("\t[Partido "+numPartido+"]");
					} else {
						numPartido++;
						System.out.println("\t[Partido "+numPartido+"]");
					}
					System.out.println("Equipos\t\t|  Cant Goles");
				       System.out.println(datos[0]+"  \t|\t  "+datos[1]);
				       if(datos[3].compareTo("USA") !=0) {
				        System.out.println(datos[3]+"  \t|\t  "+datos[2]);
				       } else {
				        System.out.println(datos[3]+"  \t\t|\t  "+datos[2]);
				       }
				    System.out.print("\n");
				    numeroRonda=Integer.parseInt(datos[4]);
				    cantRondas++;
			}
		return cantRondas;
	}
	
	public ArrayList<Persona> mostrarPronostico(int numRondas) {
		LeerDesdeBaseDeDatos lecturaSql = new LeerDesdeBaseDeDatos();
	 	ArrayList<Persona> listaNombres = new ArrayList<>(leerDesdeSql());
	 	ArrayList<String> datosPronosticos = new ArrayList<String> (lecturaSql.getPronosticosSql());
	 	System.out.println("\n--------------------------------PRONOSTICOS--------------------------------");
	 	System.out.println("Participante \tEquipo1 \tGana1\tEmpate\tGana2\tEquipo2 \tRonda \tFase");
	 	String renglon[];
	 	try {
	 		String nombre=null;
	 		int index=0;
	 		int posPersona=0;
			for(String linea : datosPronosticos){
				renglon=linea.split(" ");
				if(index <numRondas) {
					index++;
					nombre = listaNombres.get(posPersona).getNombre();
				} else {
					posPersona++;
					index = 0;
				}
				System.out.print(nombre+"\t\t");
				System.out.print(renglon[0]+"  \t");
				for(int i=0;i<3;i++) {
					if(Integer.parseInt(renglon[i+1])==1) {
						System.out.print("  X\t");
					} else {
						System.out.print("  -\t");
					}
				}
				if(renglon[4].compareTo("USA") != 0) {
					System.out.print(renglon[4] +"  \t");
				}else {
					System.out.print(renglon[4] +"  \t\t");
				}
				System.out.print("  "+renglon[6] + "\t");
				System.out.print("  "+renglon[7]+ "\n");
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	 	
	 	return listaNombres;
	}
	
	private void mostrarResultados(ArrayList<Persona> resultados) {
	 	//metodo para ordenar de mayor a menor un ArrayList
	 	resultados = ordenarPorPuntos(resultados);
		System.out.println("\n-------------------RESULTADO-------------------");
	 	for(Persona linea : resultados) {
	 		System.out.println("[Puntaje "+linea.getNombre()+" : "+linea.getPuntaje()+"]\n");
	 		}
	}
	
	public ArrayList<Persona> ordenarPorPuntos(ArrayList<Persona> resultados) {
	 	//metodo para ordenar de mayor a menor un ArrayList
	 	Collections.sort(resultados, new Comparator<Persona>() {
	 		@Override
			public int compare(Persona p1, Persona p2) {
				return Integer.valueOf(p2.getPuntaje()).compareTo((p1.getPuntaje()));
			}
		});
	 	return resultados;
	}
	
	public ArrayList<Persona> leerDesdeSql() {
		
	CargaDeDatos lectorDeDatos= new CargaDeDatos ();	
	
		//Lectura lecturaDePronosticos = new Lectura ();
	LeerDesdeBaseDeDatos lecturaSql = new LeerDesdeBaseDeDatos();
	
	String [] renglon;
	
	int pronosticoPuntaje = 0;
 	int puntajeTotal =0;
 	
 	int partidosPorRonda=0;
 	int partidosAcertadosPorRonda=0;
 	int contadorDePartidos=0;
 	int indexRonda = 0;	//es la posicion que se usa en el array cantidadDePartidosPorRonda para saber cuantos partidos hay por ronda
 	
 	int contadorDePartidosPorFase=0;
 	int partidosAcertadosPorFase=0;
 	int partidosPorFase=0;
 	int indexFase =0; //es la posicion que se usa en el array cantidadDeRondasPorFase para saber cuantas rondas hay por fase
 	
 	Ronda rondas=new Ronda ();
 	Fase fases=new Fase();
 	
 	ArrayList<Integer> cantidadDeRondasPorFase = new ArrayList<>(fases.cantidadDeRondasPorFase()); //array que tiene la cantidad de rondas por fase
 	ArrayList<Integer> resultado = new ArrayList<Integer>(lectorDeDatos.GetDatosDeResultados());
 	ArrayList<Persona> listaNombres = new ArrayList<>(lectorDeDatos.getDatosDePersonas());
 	ArrayList<String> datosPronosticos = new ArrayList<String> (lecturaSql.getPronosticosSql());
 	ArrayList<Integer> datosConfiguracion = new ArrayList<Integer> (lectorDeDatos.getDatosDeConfiguracion());
 	ArrayList<Integer> cantidadDePartidosPorRonda = new ArrayList<>(rondas.cantidadDePartidosPorRonda()); //array que tiene la cantidad de partidos por ronda
 
 	try {
 		int index=0;
		int persona =0;
 		
		for(String linea : datosPronosticos){
			renglon=linea.split(" ");
			contadorDePartidos++;
			contadorDePartidosPorFase++;
			
			if (Integer.parseInt(renglon[1]) == 1) {
				pronosticoPuntaje = 2;
				}
				else if (Integer.parseInt(renglon[2]) == 1) {
					pronosticoPuntaje = 1;
				}
				else{
					pronosticoPuntaje = 3;
				}
			if(index ==  resultado.size()) {
				index = 0;
				persona++;
				puntajeTotal =0;
			}
			
			partidosPorRonda++;
			partidosPorFase++;
			
			//sumatoria de puntos
			if (pronosticoPuntaje == resultado.get(index)) {
				puntajeTotal= puntajeTotal+datosConfiguracion.get(0);
				partidosAcertadosPorRonda++;
				partidosAcertadosPorFase++;
				listaNombres.get(persona).setPuntaje(puntajeTotal);
				
			}
			
			//AGREGAR PUNTOS EXTRA POR RONDA
			//el if empieza cuando la cantidad de partidos es igual a la cantidad de partidos por ronda y se reinicia al final del if
			//si la cantidad de partidos por ronda = a la cantidad de partidos que acertaste, suma puntos
			if(contadorDePartidos==cantidadDePartidosPorRonda.get(indexRonda)) {
				if (partidosPorRonda==partidosAcertadosPorRonda) {
					puntajeTotal= puntajeTotal+datosConfiguracion.get(1);
					listaNombres.get(persona).setPuntaje(puntajeTotal);
				}
				partidosPorRonda=0;
				partidosAcertadosPorRonda=0;
				contadorDePartidos=0;
				indexRonda++;
				}
			
			if (indexRonda==cantidadDePartidosPorRonda.size()) {
				indexRonda=0;
			}
			//AGREGAR PUNTOS EXTRAS POR FASE
			//el if empieza cuando la cantidad de rondas es igual a la cantidad de rondas por fase y se reinicia al final del if
			//si la cantidad de rondas por fase = a la cantidad de rondas que acertaste, suma puntos
			if(contadorDePartidosPorFase==cantidadDeRondasPorFase.get(indexFase)) {
				if (partidosPorFase==partidosAcertadosPorFase) {
					puntajeTotal= puntajeTotal+datosConfiguracion.get(2);
					listaNombres.get(persona).setPuntaje(puntajeTotal);
				}
				partidosPorFase=0;
				partidosAcertadosPorFase=0;
				contadorDePartidosPorFase=0;
				indexFase++;
			}
			if (indexFase==cantidadDeRondasPorFase.size()) {
				indexFase=0;
			}	
				index++;
		}
		
	} catch (NumberFormatException e) {
		
		e.printStackTrace();
	}

 	
	return listaNombres;
	}
	
}
		
	

