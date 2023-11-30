/**
 * 
 */
package principal;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import lectorSql.LeerDesdeBaseDeDatos;

/**
 * 
 */
public class Test1 {

	//TEST PARA COMPROBAR QUE SE RECIBAN DATOS DE RESULTADOS DESDE SQL
@Test
	public void resultadosDesdeSql () {
		LeerDesdeBaseDeDatos lectura = new LeerDesdeBaseDeDatos();
		ArrayList<String> datosResultados = new ArrayList<String> (lectura.getResultadosSql());
		
		assertNotNull(datosResultados); 

	}

	//TEST PARA COMPROBAR QUE SE RECIBAN DATOS DE PRONOSTICOS DESDE SQL
@Test
	public void pronosticosDesdeSql () {
	LeerDesdeBaseDeDatos lectura = new LeerDesdeBaseDeDatos();
	ArrayList<String> datosPronosticos = new ArrayList<String> (lectura.getPronosticosSql());
	
	assertNotNull(datosPronosticos); 

	}

	//TEST PARA COMPROBAR QUE NO SON EL MISMO ARCHIVO DEL QUE SE LEE 
@Test
	public void compararTxtConSql () {
	LeerDesdeBaseDeDatos lecturaSql = new LeerDesdeBaseDeDatos();
	ArrayList<String> datosPronosticosSql = new ArrayList<String> (lecturaSql.getPronosticosSql());
	
	Lectura lecturaTxt = new Lectura();
	ArrayList<String> datosPronosticosTxt = new ArrayList<String> (lecturaTxt.getLecturaPronostico());
	
	assertNotSame(datosPronosticosSql, datosPronosticosTxt);
	}

	//TEST PARA VER SI EL PUNTAJE ES EL ESPERADO 
@Test
	public void puntajeEsperado() {
	Logica logica = new Logica();
	ArrayList<Persona> puntajes = new ArrayList<Persona> (logica.leerDesdeSql());
	
	assertEquals(20, puntajes.get(0).getPuntaje());
	assertEquals(9, puntajes.get(1).getPuntaje());
	assertEquals(17, puntajes.get(2).getPuntaje());
	}
}
