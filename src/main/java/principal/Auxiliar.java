package principal;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Auxiliar {

	
	//TODO LO QUE ESTABA EN LOGICA Y SE MOVIO HACIA CargaDedatos
	
// 	try {
//		for(String linea : datosResultados){
//			
//			renglon=linea.split(" ");
//				 				
//				//pronostico
//		if (Integer.parseInt(renglon[1]) == Integer.parseInt(renglon[2])) {
//		resultado.add(1);
//			}
//			else if (Integer.parseInt(renglon[1]) > Integer.parseInt(renglon[2])) {
//				resultado.add(2);
//
//				}
//			else if (Integer.parseInt(renglon[1]) < Integer.parseInt(renglon[2])) {
//				resultado.add(3);
//
//				}
//		}	
//	} catch (NumberFormatException e) {

//		e.printStackTrace();
//	}
	
//		int bandera = 0;
//		int posicion=0;
//		for(String linea : datosPronosticos) {
//		String texto[]=linea.split(" ");
//		String nombre = texto[5];
//		if(bandera == 0 || !nombre.equalsIgnoreCase(listaNombres.get(posicion-1).getNombre()) ) {
//			listaNombres.add(new Persona(nombre,0));
//			bandera =1;
//			posicion++;
//		}
//	}
	//-----------------------------------------------------
	
	
	
	
	//Partido p1= new Partido(Equipo equipo1, Equipo equipo2, int golesEquipo1, int golesEquipo2) 
//	 int indice = -1;
//	 int indiceP = -1;
//	 String [] renglon= new String [4];//notar que no es un nro mágico, es la cantidad de columnas del archivo que voy a leer, lo define el formato del archivo que planeo leer
//	 List <Equipo> paises=new ArrayList<Equipo>();
// String equipoa="";
// String equipob="";
// int gola=0;
// int golb=0;
// int pais1=0;
// int pais2=0;
// ResultadoEnum estado= ResultadoEnum.empate;
 
//List<String> resultados = Files.readAllLines(Paths.get("resultados.txt"));
 	//List<String> pronosticos = Files.readAllLines(Paths.get("pronostico.txt"));
 	//int longitud = resultados.size();
 	//int longitudP= pronosticos.size();
 	//hago un arreglo de partidopara hacer la ronda
 	//Partido encuentros[]=new Partido [longitud];
 	//Ronda ronda1=new Ronda ("1",encuentros);
 
 	//hago un arreglo de pronosticos para hacer pronostico
 	//Pronostico apuestas[] =new Pronostico[longitudP];
 	
 	//ahora hago un arraylist con nombre de equipos o países
 	
 				 	
 	//}
								    
		//guardo los resultados en un arreglo encuentros
			
//			for (int j=0; j<=paises.size();j++){
//				if(paises.get(j).getNombre()==renglon[0]) {
//					pais1=j;
//				}else {
//					if(paises.get(j).getNombre()==renglon[3]){
//					 pais2=j;
//					};
			//};
							
								
		//encuentros [indice]= new Partido (paises.get(pais1), paises.get(pais2), Integer.parseInt(renglon[1]), Integer.parseInt(renglon[2])); 
		
			
			//};
			//}
	
//		//hago una ronda
//			Ronda r1= new Ronda ("1",encuentros);
//			
//			
//			
//		//bajo los pronosticoas ahora	
//			for(String linea:Files.readAllLines(Paths.get("pronosticos.txt"))){
//		 	 indiceP=indiceP+1;
//		 	 renglon=linea.split(" ");
//		 	 
//		 	for (int i=0; i<=paises.size();i++){
//				if(paises.get(i).getNombre()==renglon[0]) {
//					pais1=i;
//				};
//		 	}
//			
//		 	 
//		 	if(encuentros[indiceP].getGolesEquipo1()>encuentros[indiceP].getGolesEquipo2()){
//				estado=ResultadoEnum.ganador;
//			} else {
//				if(encuentros[indiceP].getGolesEquipo1()<encuentros[indiceP].getGolesEquipo2()){
//					estado=ResultadoEnum.perdedor;
//				} else {
//					estado=ResultadoEnum.empate;
//				}
//			};
//				
//			
//			
//			apuestas [indiceP] = new Pronostico (encuentros[indice],paises.get(pais1),estado);
//				
//			};
//	
//	

}
