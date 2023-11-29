package principal;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CrearArchivo {
	private String registro="";
	
	public void guardar(ArrayList<Persona> listPersona, String path) {
		File file = new File(path);
		listPersona.forEach(persona->{
			registro+=persona.getNombre()+" "+persona.getPuntaje()+"\n";
		});
		
		try {
			file.createNewFile();
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(registro);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
