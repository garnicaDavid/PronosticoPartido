
public class Pronostico {
	private Partido partido;
	private Equipo equipo;
	private ResultadoEnum resultado;
	
	
	
	public Pronostico(Partido partido2, Equipo equipo2, Enum estado) {
		// TODO Auto-generated constructor stub
	}


	public Partido getPartido() {
		return partido;
	}


	public void setPartido(Partido partido) {
		this.partido = partido;
	}


	public Equipo getEquipo() {
		return equipo;
	}


	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}


	public ResultadoEnum getResultado() {
		return resultado;
	}


	public void setResultado(ResultadoEnum resultado) {
		this.resultado = resultado;
	}


	public static int puntos() {
		return 0;
	}
}
