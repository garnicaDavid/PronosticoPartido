package principal;
import java.util.ArrayList;

import lectorSql.LeerDesdeBaseDeDatos;

public class Logica {
	
	public Logica() {
	}

	public void leerDesdeSql() {
		
	CargaDeDatos lectorDeDatos= new CargaDeDatos ();	
	
		//Lectura lecturaDePronosticos = new Lectura ();
	LeerDesdeBaseDeDatos lecturaSql = new LeerDesdeBaseDeDatos();
	
	String [] renglon;
	int pronosticoPuntaje = 0;
 	int puntajeTotal =0;
 	int partidosPorRonda=0;
 	int partidosAcertadosPorRonda=0;
 	int contadorDePartidos=0;
 	int contadorDePartidosPorFase=0;
 	int partidosAcertadosPorFase=0;
 	int partidosPorFase=0;
 	int indexRonda = 0;
 	int indexFase =0;
 	Ronda rondas=new Ronda ();
 	Fase fases=new Fase();
 	ArrayList<Integer> cantidadDeRondasPorFase = new ArrayList<>(fases.cantidadDeRondasPorFase());
 	ArrayList<Integer> resultado = new ArrayList<Integer>(lectorDeDatos.GetDatosDeResultados());
 	ArrayList<Persona> listaNombres = new ArrayList<>(lectorDeDatos.getDatosDePersonas());
 	ArrayList<String> datosPronosticos = new ArrayList<String> (lecturaSql.getPronosticosSql());
 	ArrayList<Integer> datosConfiguracion = new ArrayList<Integer> (lectorDeDatos.getDatosDeConfiguracion());
 	ArrayList<Integer> cantidadDePartidosPorRonda = new ArrayList<>(rondas.cantidadDePartidosPorRonda());
 	
 	System.out.println("\n-------------------PRONOSTICOS-------------------");
 	System.out.println("Equipo1 \tGana1\tEmpate\tGana2\tEquipo2 \tRonda \tFase");
 	
 	try {
 		int index=0;
		int persona =0;
 		
		for(String linea : datosPronosticos){
			renglon=linea.split(" ");
			contadorDePartidos++;
			contadorDePartidosPorFase++;
			System.out.print(renglon[0]+"  \t");
			
			for(int i=0;i<3;i++) {
				if(Integer.parseInt(renglon[i+1])==1) {
					System.out.print("  X\t");
				} else {
					System.out.print("  -\t");
				}
			}
			System.out.print(renglon[4] +"  \t");
			System.out.print(renglon[6] + "\t");
			System.out.print(renglon[7]+ "\n");
			
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
				System.out.println("  ["+listaNombres.get(persona).getNombre()+" : +"+ datosConfiguracion.get(0) +" ]");
				puntajeTotal= puntajeTotal+datosConfiguracion.get(0);
				partidosAcertadosPorRonda++;
				partidosAcertadosPorFase++;
				listaNombres.get(persona).setPuntaje(puntajeTotal);
				
			}
		 	else {
		 		System.out.println("  ["+listaNombres.get(persona).getNombre()+" : 0]");
		 	}
			
			//AGREGAR PUNTOS EXTRA POR RONDA
			
			if(contadorDePartidos==cantidadDePartidosPorRonda.get(indexRonda)) {
				if (partidosPorRonda==partidosAcertadosPorRonda) {
					System.out.println("[Puntaje extra por acertar la ronda completa: +" + datosConfiguracion.get(1) + "]");
					puntajeTotal= puntajeTotal+datosConfiguracion.get(1);
					listaNombres.get(persona).setPuntaje(puntajeTotal);
				}
				partidosPorRonda=0;
				partidosAcertadosPorRonda=0;
				contadorDePartidos=0;
				
			}
			
			//AGREGAR PUNTOS EXTRAS POR FASE
			if(contadorDePartidosPorFase==cantidadDeRondasPorFase.get(indexFase)) {
				if (partidosPorFase==partidosAcertadosPorFase) {
					System.out.println("[Puntaje extra por acertar la fase completa: +"+ datosConfiguracion.get(2)+"]");
					puntajeTotal= puntajeTotal+datosConfiguracion.get(2);
					listaNombres.get(persona).setPuntaje(puntajeTotal);
				}
				partidosPorFase=0;
				partidosAcertadosPorFase=0;
				contadorDePartidosPorFase=0;
			}
			
			
			
			
			
			
				index++;
		}
		
	} catch (NumberFormatException e) {
		
		e.printStackTrace();
	}
 	System.out.println("\n-------------------RESULTADO-------------------");
 	for(Persona linea : listaNombres) {
 		System.out.println("[Puntaje "+linea.getNombre()+" : "+linea.getPuntaje()+"]");
 		System.out.println();
 		
 		System.out.println(cantidadDeRondasPorFase);
 		}
 	
 

//public class Logica {
//	
//	public Logica() {
//	}
//
//	public void leerDesdeSql() {
//		
//	CargaDeDatos lectorDeDatos= new CargaDeDatos ();	
//	
//		//Lectura lecturaDePronosticos = new Lectura ();
//	LeerDesdeBaseDeDatos lecturaSql = new LeerDesdeBaseDeDatos();
//	
//	String [] renglon;
//	int pronosticoPuntaje = 0;
// 	int puntajeTotal =0;
//	int puntoPronostico =0;
//	ArrayList<Integer> resultado = new ArrayList<Integer>(lectorDeDatos.GetDatosDeResultados());
// 	ArrayList<Persona> listaNombres = new ArrayList<>(lectorDeDatos.getDatosDePersonas());
// 	ArrayList<String> datosPronosticos = new ArrayList<String> (lecturaSql.getPronosticosSql());
// 	ArrayList<Integer> puntosExtras = new ArrayList<Integer>(lectorDeDatos.getDatosDeConfiguracion());
// 	
// 	System.out.println("\n-------------------PRONOSTICOS-------------------");
// 	System.out.println("Equipo1 \tGana1\tEmpate\tGana2\tEquipo2");
// 	
// 	try {
// 		int index=0;
//		int persona =0;
//		int cantRondaSeguidas =0;
//		int cantFaseSeguidas =0;
//		int rondaExtra=0;
//		int faseExtra=0;
// 		
//		for(String linea : datosPronosticos){
//			renglon=linea.split(" ");
//			
//			System.out.print(renglon[0]+"  \t");
//			
//			for(int i=0;i<3;i++) {
//				if(Integer.parseInt(renglon[i+1])==1) {
//					System.out.print("  X\t");
//				} else {
//					System.out.print("  -\t");
//				}
//			}
//			System.out.print(renglon[4]+"\n");
//			//gano equipo1
//			if (Integer.parseInt(renglon[1]) == 1) {
//				pronosticoPuntaje = 2;
//				}
//			//gano equipo2
//				else if (Integer.parseInt(renglon[2]) == 1) {
//					pronosticoPuntaje = 1;
//				}
//			//empataron
//				else{
//					pronosticoPuntaje = 3;
//				}
//			if(index == resultado.size()) {
//				index = 0;
//				persona++;
//				cantRondaSeguidas=0;
//				cantFaseSeguidas =0;
//				rondaExtra=0;
//				faseExtra=0;
//				puntoPronostico=0;
//			}
//
//			if (pronosticoPuntaje == resultado.get(index)) {
//				
//				cantRondaSeguidas++;
//				cantFaseSeguidas++;
//				if(cantRondaSeguidas >=2) {
//					//puntosExtras.get(3) RONDAS;
//					rondaExtra += puntosExtras.get(3);
//					System.out.println("[+"+(puntosExtras.get(3))+" Rondas]");
//				}
//				//si aposto por algun equipo, y gana, punto extra de GANADOR;
//				if(pronosticoPuntaje == 2 || pronosticoPuntaje ==1) {
//					puntoPronostico += puntosExtras.get(0);
//					System.out.println("[+"+(puntosExtras.get(0))+" Ganador]");
//				} 
//				//punto si EMPATARON;
//				else {
//					puntoPronostico += puntosExtras.get(2);
//					System.out.println("[+"+(puntosExtras.get(2))+" Empate]");
//				}
//				
//			}
//		 	else {
//		 		//punto si perdio la ronda PERDIO;
//		 		puntoPronostico += puntosExtras.get(1);
//		 		System.out.println("[+"+(puntosExtras.get(1))+" Perdio]");
//		 		//se corta la racha de rondas
//		 		cantRondaSeguidas =0;
//		 	}
//			System.out.println("["+listaNombres.get(persona).getNombre()+" : +"+(puntoPronostico+rondaExtra)+" ]");
//			//Ultima ronda donde se define los puntos;
//			if(index == (resultado.size()-1)) {
//				//punto si gano la primera fase de rondas FASE;
//				if(cantFaseSeguidas == resultado.size()) {
//					faseExtra += puntosExtras.get(4);
//					System.out.println("["+listaNombres.get(persona).getNombre()+" : +"+(faseExtra)+"]");
//				}
//				puntajeTotal += puntoPronostico + rondaExtra + faseExtra;
//				listaNombres.get(persona).setPuntaje(puntajeTotal);
//				puntajeTotal=0;
//			}
//			index++;
//		}
//		
//	} catch (NumberFormatException e) {
//		
//		e.printStackTrace();
//	}
 	
 }

		
	}

