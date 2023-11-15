import java.util.ArrayList;

public class Logica {
	
	public Logica() {
	}

	public void leerDesdeTxt() {
		
	CargaDeDatos lectorDeDatos= new CargaDeDatos ();	
	Lectura lecturaDePronosticos = new Lectura ();
	String [] renglon;
	int pronosticoPuntaje = 0;
 	int puntajeTotal =0;
	ArrayList<Integer> resultado = new ArrayList<Integer>(lectorDeDatos.GetDatosDeResultados());
 	ArrayList<Persona> listaNombres = new ArrayList<>(lectorDeDatos.getDatosDePersonas());
 	ArrayList<String> datosPronosticos = new ArrayList<String> (lecturaDePronosticos.getLecturaPronostico());
 	
 	System.out.println("\n-------------------PRONOSTICOS-------------------");
 	System.out.println("Equipo1 \tGana1\tEmpate\tGana2\tEquipo2");
 	
 	try {
 		int index=0;
		int persona =0;
 		
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
				}
				else if (Integer.parseInt(renglon[2]) == 1) {
					pronosticoPuntaje = 1;
				}
				else{
					pronosticoPuntaje = 3;
				}
			if(index == 4) {
				index = 0;
				persona++;
			}

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
		
		e.printStackTrace();
	}
 	System.out.println("\n-------------------RESULTADO-------------------");
 	for(Persona linea : listaNombres) {
 		System.out.println("[Puntaje "+linea.getNombre()+" : "+linea.getPuntaje()+"]");
 		}
 	
 }
}
