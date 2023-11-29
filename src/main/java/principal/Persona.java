package principal;

import java.util.ArrayList;

public class Persona {
	private String nombre;
	private int puntaje;

	public Persona(String nombre, int puntaje) {
		super();
		this.nombre = nombre;
		this.puntaje = puntaje;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getPuntaje() {
		return puntaje;
	}


	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", puntaje=" + puntaje + "]";
	}


	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
}