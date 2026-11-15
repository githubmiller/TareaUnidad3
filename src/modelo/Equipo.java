
package modelo;

import java.io.Serializable; 

public class Equipo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nombre;

	// Constructor
	public Equipo(String nombre) {
		this.nombre = nombre;
	}

	// Metodo para obtener el nombre
	public String getNombre() {
		return nombre;
	}

	// Metodo para mostrar el equipo
	@Override
	public String toString() {
		return nombre;
	}
}
