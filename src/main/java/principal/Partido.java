package principal;


public class Partido {
	private Equipo equipo1;
	private Equipo equipo2;
	private int golesEquipo1;
	private int golesEquipo2;
	
	
	public Partido(Equipo equipo1, Equipo equipo2, int golesEquipo1, int golesEquipo2) {
		super();
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
		this.golesEquipo1 = golesEquipo1;
		this.golesEquipo2 = golesEquipo2;
	}
	
	public Equipo getEquipo1() {
		return equipo1;
	}
	public void setEquipo1(Equipo equipo1) {
		this.equipo1 = equipo1;
	}
	public Equipo getEquipo2() {
		return equipo2;
	}
	public void setEquipo2(Equipo equipo2) {
		this.equipo2 = equipo2;
	}
	public int getGolesEquipo1() {
		return golesEquipo1;
	}
	public void setGolesEquipo1(int golesEquipo1) {
		this.golesEquipo1 = golesEquipo1;
	}
	public int getGolesEquipo2() {
		return golesEquipo2;
	}
	public void setGolesEquipo2(int golesEquipo2) {
		this.golesEquipo2 = golesEquipo2;
	}
	
	public Partido metodoPartido() {
		Equipo equipo2;
		Equipo equipo1;
		String [] renglon;
		Partido partido1 = null;
		Lectura lecturaDeResultados = new Lectura ();
for(String linea : lecturaDeResultados.getLecturaResultado()){
			
			renglon = linea.split(" ");
			 
				 equipo1 = new Equipo (renglon[0] ,"equipo de futbol");   
				 equipo2 = new Equipo (renglon[3] ,"equipo de futbol");
	 partido1 = new Partido (equipo1,equipo2,Integer.parseInt(renglon[1]) ,Integer.parseInt(renglon[2]));

}
return partido1;
}

	@Override
	public String toString() {
		return "Partido [equipo1=" + equipo1 + ", equipo2=" + equipo2 + ", golesEquipo1=" + golesEquipo1
				+ ", golesEquipo2=" + golesEquipo2 + "]";
	}
	
	public ResultadoEnum resultado(Equipo equipo) {
		
		
		    if (equipo.equals(equipo1)) {
		        if (golesEquipo1 > golesEquipo2) {
		            return ResultadoEnum.ganador;
		        } else if (golesEquipo2 > golesEquipo1) {
		            return ResultadoEnum.perdedor;
		        } else {
		            return ResultadoEnum.empate;
		        }
		    } else if (equipo.equals(equipo2)) {
		       
		    	if (golesEquipo2 > golesEquipo1) {
		            return ResultadoEnum.ganador;
		        } else if (golesEquipo1 > golesEquipo2) {
		            return ResultadoEnum.perdedor;
		        } else {
		            return ResultadoEnum.empate;
		        }
	    }
			return null;
	}
}
