import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Logica {
	
	
	
	public Logica() {
	}

	public void numeroDeRonda() {
		
		
	String [] renglon;
	Ronda [] numeroDeRonda;
	ArrayList<Integer> resultado = new ArrayList<Integer>();
	ArrayList<Integer> pronostico = new ArrayList<Integer>();
 	int resultadoPuntaje = 0;
 	int pronosticoPuntaje = 0;
 	int puntajeTotal =0;
 	Ronda ronda = null;
 	
 	try {
		for(String linea:Files.readAllLines(Paths.get("resultados.txt"))){
			
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
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 	System.out.println("\n-------------------PRONOSTICOS-------------------");
 	System.out.println("Equipo1 \tGana1\tEmpate\tGana2\tEquipo2");
 	try {
 		int index=0;
		for(String linea:Files.readAllLines(Paths.get("pronostico.txt"))){
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
			
			if (pronosticoPuntaje == resultado.get(index)) {
				System.out.println("[Puntaje : +1]");
				puntajeTotal++;
			}
		 	else {
		 		System.out.println("[Puntaje : 0]");
		 	}
			index++;
		}
	} catch (NumberFormatException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 	System.out.println("\n-------------------RESULTADO-------------------");
 	System.out.println("\n[Puntaje Total : "+puntajeTotal+"]");
 	
 	
 	
 	
 	
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