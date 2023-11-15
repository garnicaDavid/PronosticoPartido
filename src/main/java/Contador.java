//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.Map;
//import java.util.Set;
//
//public class Contador {
//    public static void main(String[] args) throws NoEsEnteroException {
//        // Ruta al archivo TXT en el escritorio
//    	
//    	Lectura lecturaDePronosticos = new Lectura ();
//    	ArrayList<String> datosResultados = new ArrayList<String> (lecturaDePronosticos.getLecturaResultado());
//    	
//        String archivoTXT = "resultados.txt";
//
//        try (BufferedReader br = new BufferedReader(new FileReader(archivoTXT))) {
//            Map<Integer, String> nacionalidades = new HashMap<>();
//            int ultimoNumeroRondas = 0;
//
//            String linea;
//            while ((linea = br.readLine()) != null) {
//                String[] partes = linea.split(" ");
//                int num = convertirAEntero(partes[1]);
//                if (partes.length >= 3) {
//                    String numeroRondasStr = partes[4].trim();
//                    if (numeroRondasStr.matches("\\d+")) {
//                        int numeroRondas = Integer.parseInt(numeroRondasStr);
//                        ultimoNumeroRondas = numeroRondas;
//
//                        String nacionalidad = partes[1].trim();
//                        nacionalidades.put(numeroRondas, nacionalidad);
//                    }
//                }
//            }
//
//            // Obtener las nacionalidades distintas
//            Set<String> nacionalidadesDistintas = new HashSet<>(nacionalidades.values());
//
//            System.out.println("Último número de rondas: " + ultimoNumeroRondas);
//            //System.out.println("Nacionalidades distintas: " + nacionalidadesDistintas.size());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    
//    
//    public static int convertirAEntero(String cadena) throws NoEsEnteroException {
//        try {
//            return Integer.parseInt(cadena);
//        } catch (NumberFormatException e) {
//            throw new NoEsEnteroException("La cadena no representa un número entero válido.");
//        }
//    }
//}