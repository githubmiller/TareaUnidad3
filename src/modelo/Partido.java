
package modelo;

import java.io.Serializable;

public class Partido implements Serializable {

	private static final long serialVersionUID = 1L;

	private Equipo equipo1;
	private Equipo equipo2;
	private String etapa;
	private Equipo ganador;

	// Constructor
	public Partido(Equipo equipo1, Equipo equipo2, String etapa) {
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
		this.etapa = etapa;
	}

	// Obtener el primer equipo
	public Equipo getEquipo1() {
		return equipo1;
	}

	// Obtener el segundo equipo
	public Equipo getEquipo2() {
		return equipo2;
	}

	// Obtener la etapa
	public String getEtapa() {
		return etapa;
	}
	
	// Obtener el ganador del partido
	public Equipo getGanador() {
	    return ganador;
	}

	// Establecer el ganador del partido
	public void setGanador(Equipo ganador) {
	    this.ganador = ganador;
	}

	// Mostrar el enfrentamiento
	@Override
	public String toString() {
		return equipo1 + " vs " + equipo2;
	}
}
