package principal;


public class Equipo {
	private String nombre;
	private String descripcion;
	
	@Override
	public String toString() {
		return "Equipo [nombre=" + nombre +  "]";
	}

	public Equipo(String nombre) {
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return this.descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
