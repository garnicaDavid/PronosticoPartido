import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Logica {
	
	public Logica() {
	}

	public void numeroDeRonda() {
		
	Lectura lecturaDePronosticos = new Lectura ();
	Lectura lecturaDeResultados = new Lectura ();
	String [] renglon;
	Ronda [] numeroDeRonda;
	ArrayList<Integer> resultado = new ArrayList<Integer>();
	ArrayList<Integer> pronostico = new ArrayList<Integer>();
 	int resultadoPuntaje = 0;
 	int pronosticoPuntaje = 0;
 	int puntajeTotal =0;
 	ArrayList<Persona> listaNombres = new ArrayList<>();
 	Ronda ronda = null;
 	ArrayList<String> datosResultados = new ArrayList<String> (lecturaDePronosticos.getLecturaResultado());
 	ArrayList<String> datosPronosticos = new ArrayList<String> (lecturaDePronosticos.getLecturaPronostico());
 	
 	
 	try {
		for(String linea : datosResultados){
			
			renglon=linea.split(" ");
				 				
				//pronostico
		if (Integer.parseInt(renglon[1]) == Integer.parseInt(renglon[2])) {
		resultado.add(1);
			}
			else if (Integer.parseInt(renglon[1]) > Integer.parseInt(renglon[2])) {
				resultado.add(2);

				}
			else if (Integer.parseInt(renglon[1]) < Integer.parseInt(renglon[2])) {
				resultado.add(3);

				}
		}	
	} catch (NumberFormatException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 	System.out.println("\n-------------------PRONOSTICOS-------------------");
 	System.out.println("Equipo1 \tGana1\tEmpate\tGana2\tEquipo2");
 	
// 	for(int =0;i<4;i++) {
// 		
// 	}
 	
 	
 	
 	try {
 		int index=0;
 		int bandera = 0;
 		int posicion=0;
		int persona =0;
 		for(String linea : datosPronosticos) {
 			String texto[]=linea.split(" ");
 			String nombre = texto[5];
 			if(bandera == 0 || !nombre.equalsIgnoreCase(listaNombres.get(posicion-1).getNombre()) ) {
 				listaNombres.add(new Persona(nombre,0));
 				bandera =1;
 	 			posicion++;
 			}
 		}
 		
		for(String linea : datosPronosticos){
			renglon=linea.split(" ");
			
			System.out.print(renglon[0]+"  \t");
			for(int i=0;i<3;i++) {
				if(Integer.parseInt(renglon[i+1])==1) {
					System.out.print("  X\t");
				} else {
					System.out.print("  -\t");
				}
			}
			System.out.print(renglon[4]+"\n");
			
			if (Integer.parseInt(renglon[1]) == 1) {
				pronosticoPuntaje = 2;
				//System.out.println(2);
				}
				else if (Integer.parseInt(renglon[2]) == 1) {
					pronosticoPuntaje = 1;
					//System.out.println(1);
				
			}
				else{
					pronosticoPuntaje = 3;
					//System.out.println(3);
				
			}
			if(index == 4) {
				index = 0;
				persona++;
			}
//			if(posicion[i] == posicion[i+1]) {
//				posicion[j] = puntajeTotal++;
//			}
			
			if (pronosticoPuntaje == resultado.get(index)) {
				System.out.println("["+listaNombres.get(persona).getNombre()+" : +1]");
				puntajeTotal++;
				
			}
		 	else {
		 		System.out.println("["+listaNombres.get(persona).getNombre()+" : 0]");
		 	}
			
			if(index ==3) {
				listaNombres.get(persona).setPuntaje(puntajeTotal);
				puntajeTotal=0;
			}
			index++;
		}
		
		
	} catch (NumberFormatException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 	System.out.println("\n-------------------RESULTADO-------------------");
 	for(Persona linea : listaNombres) {
 		System.out.println("[Puntaje "+linea.getNombre()+" : "+linea.getPuntaje()+"]");
 	}
 	
 	
 	
 	
 	
}
}
//if (Integer.parseInt(renglon[1]) == Integer.parseInt(renglon[2])) {
//resultadoPuntaje = 1;
//System.out.println(resultadoPuntaje);
//}
//else if (Integer.parseInt(renglon[1]) > Integer.parseInt(renglon[2])) {
//resultadoPuntaje = 2;
//System.out.println(resultadoPuntaje);
//
//}
//else if (Integer.parseInt(renglon[1]) < Integer.parseInt(renglon[2])) {
//resultadoPuntaje = 3;
//System.out.println(resultadoPuntaje);
//System.out.println("ronda" + ronda);
//	ronda++;
//	}
//}