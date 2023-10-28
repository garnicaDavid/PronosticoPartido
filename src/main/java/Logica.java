import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Logica {
	
	public Ronda numeroDeRonda() {
		
		
	String [] renglon;
	Ronda [] numeroDeRonda;
 	int resultadoPuntaje = 0;
 	int pronosticoPuntaje = 0;
 	Ronda ronda = null;
 	
 	try {
		for(String linea:Files.readAllLines(Paths.get("resultados.txt"))){
			
			renglon=linea.split(" ");
			 
				 				
				//pronostico
		if (Integer.parseInt(renglon[1]) == Integer.parseInt(renglon[2])) {
		resultadoPuntaje = 1;
		System.out.println(resultadoPuntaje);
			}
			else if (Integer.parseInt(renglon[1]) > Integer.parseInt(renglon[2])) {
		resultadoPuntaje = 2;
		System.out.println(resultadoPuntaje);

				}
			else if (Integer.parseInt(renglon[1]) < Integer.parseInt(renglon[2])) {
		resultadoPuntaje = 3;
		System.out.println(resultadoPuntaje);

				}
		}	
	} catch (NumberFormatException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 	
 	try {
		for(String linea:Files.readAllLines(Paths.get("pronostico.txt"))){
			
			renglon=linea.split(" ");
		
			if (Integer.parseInt(renglon[1]) == 1) {
				pronosticoPuntaje = 2;
				System.out.println(2);
				}
				else if (Integer.parseInt(renglon[2]) == 1) {
					pronosticoPuntaje = 1;
					System.out.println(1);
				
			}
				else{
					pronosticoPuntaje = 3;
					System.out.println(3);
				
			}
		
		
		}
	} catch (NumberFormatException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 	
 	if (pronosticoPuntaje == resultadoPuntaje ) {
		System.out.println("son iguales");
	}
 	else {
 		System.out.println("son distintos");
 	}
 	
 	
 	
 	
	return null;
 	
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