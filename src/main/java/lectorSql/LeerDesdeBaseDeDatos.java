package lectorSql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LeerDesdeBaseDeDatos {

	
		private List <String> pronosticosSql;
		
		public LeerDesdeBaseDeDatos() {
			this.pronosticosSql = new ArrayList <String>();
		}
		

		public List<String> getPronosticosSql() {
			
			Connection conexion = null;
			java.sql.Statement consulta = null;
			
			try {
			//ABRIR LA CONEXION
				System.out.println("ESTABLECIENDO CONEXION");
													//URL			- 		USUARIO		   -  CONTRASEÑA  - SE LLAMA A LA CLASE CONECTOR
				conexion = DriverManager.getConnection(ConectorSql.DB_URL,ConectorSql.USER,ConectorSql.PASS);
				
				// Ejecutar una consulta
				System.out.println("\tcreando statment...\n");
				
				consulta = conexion.createStatement();
				String sql;
				
				sql = "SELECT * FROM pronosticos";
				
				 //En la variable resultado obtendremos las distintas filas que nos devolvió la base
				ResultSet pronostico = consulta.executeQuery(sql);
				
							
				 // Obtener las distintas filas de la consulta
				while (pronostico.next()) {
					 // Obtener el valor de cada columna (tiene que ser el nombre exacto de la columna)
					String equipo1 = pronostico.getString("equipo1");
					String ganaEquipo1 = pronostico.getString("ganaEquipo1");
					String empatan = pronostico.getString("empatan");
					String ganaEquipo2 = pronostico.getString("ganaEquipo2");
					String equipo2 = pronostico.getString("equipo2");
					String apostadores = pronostico.getString("apostadores");
					String linea = (equipo1+" "+ ganaEquipo1+" "+empatan+" "+ganaEquipo2+" "+equipo2+" "+apostadores);
					this.pronosticosSql.add(linea);
				}
				
			     // Esto se utiliza par cerrar la conexión con la base de datos (HACER SIEMPRE, RECORDAR!!)
				// SE PUEDE HACER UN METODO!!
				pronostico.close();
				consulta.close();
				conexion.close();
							
			}
			catch (SQLException e) {
			  
				e.printStackTrace();
			}
			
			finally {
	            // Esta sentencia es para que ante un problema con la base igual se cierren las conexiones
	            try {
	                if (consulta != null)
	                    consulta.close();
	            } catch (SQLException se2) {
	            }
	            try {
	                if (conexion != null)
	                    conexion.close();
	            } catch (SQLException se) {
	                se.printStackTrace();
	            }
	        }
			return pronosticosSql;
		}


		@Override
		public String toString() {
			return "LeerDesdeBaseDeDatos [pronosticosSql=" + pronosticosSql + "]";
		}

		
}


