
package controlador;

//Necesarios.
import modelo.Torneo;
import vista.VistaTorneo;
import excepciones.NumeroEquiposInvalidoException; //excepción personalizada 1 
import excepciones.SorteoInvalidoException; //excepción personalizada 2
import java.util.ArrayList;
import modelo.Equipo;
import java.io.IOException;

public class ControladorTorneo {

	private Torneo torneo;
	private VistaTorneo vista;

	// Constructor
	public ControladorTorneo(Torneo torneo, VistaTorneo vista) {
		this.torneo = torneo;
		this.vista = vista;
	}

	// Ejecutar todas las etapas del torneo
	public void ejecutarTorneo(ArrayList<Equipo> participantes) {

		String[] etapas = { "Octavos de final", "Cuartos de final", "Semifinales", "Final" }; // arreglo con todas las
																								// etapas.

		try {

			for (String etapa : etapas) {

				// Realizar el sorteo de la etapa
				torneo.sortearEtapa(participantes, etapa);

				// Mostrar los enfrentamientos
				vista.mostrarPartidos(torneo.getHistorialPartidos(), etapa);

				// Seleccionar los ganadores
				participantes = torneo.seleccionarGanadores(etapa); // actualizo la lista de participantes por los
																	// ganadores de la etapa anterior.
			}

		} catch (NumeroEquiposInvalidoException | SorteoInvalidoException e) {

			vista.mostrarError(e.getMessage());
		}
	}

	// Guardar el torneo
	public void guardarTorneo(String nombreArchivo) {

		try {
			torneo.guardarTorneo(nombreArchivo);

		} catch (IOException e) {
			vista.mostrarError("Error al guardar el torneo: " + e.getMessage());
		}
	}

	// Cargar el torneo
	public void cargarTorneo(String nombreArchivo) {

		try {
			torneo = Torneo.cargarTorneo(nombreArchivo);
			System.out.println();
			System.out.println("Torneo recuperado correctamente. El cual es-->");
			// Mostrar el torneo recuperado
			String[] etapas = { "Octavos de final", "Cuartos de final", "Semifinales", "Final" };

			for (String etapa : etapas) {
				vista.mostrarPartidos(torneo.getHistorialPartidos(), etapa);
			}
		} catch (IOException | ClassNotFoundException e) {
			vista.mostrarError("Error al cargar el torneo: " + e.getMessage());
		}
	}

}
