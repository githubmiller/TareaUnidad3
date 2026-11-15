package principal;

//Necesarios
import java.util.ArrayList;
import modelo.Equipo; // conecto con equipo
import modelo.Torneo;//conecto con torneo
import vista.VistaTorneo;//conecto con vista
import controlador.ControladorTorneo;//conecto con controlador

public class Main {

	public static void main(String[] args) {
		// Crear los equipos del torneo
		ArrayList<Equipo> equipos = new ArrayList<>(); // creo una lista de equipos y luego añado sus elementos.
		equipos.add(new Equipo("Barcelona SC"));
		equipos.add(new Equipo("Emelec"));
		equipos.add(new Equipo("Liga de Quito"));
		equipos.add(new Equipo("Independiente del Valle"));
		equipos.add(new Equipo("Aucas"));
		equipos.add(new Equipo("Delfin"));
		equipos.add(new Equipo("Orense"));
		equipos.add(new Equipo("Macara"));
		equipos.add(new Equipo("Universidad Catolica"));
		equipos.add(new Equipo("Mushuc Runa"));
		equipos.add(new Equipo("El cuenquita"));
		equipos.add(new Equipo("El Nacho"));
		equipos.add(new Equipo("Tecnico Universitario"));
		equipos.add(new Equipo("Libertad FC"));
		equipos.add(new Equipo("Manta FC"));
		equipos.add(new Equipo("Cebollitas FC"));

		// Creo el torneo
		Torneo torneo = new Torneo(equipos); // le paso la lista de equipos

		// Crear la vista
		VistaTorneo vista = new VistaTorneo(); // muestro los resultados de las asignaciones aleatorias

		// Crear el controlador
		ControladorTorneo controlador = new ControladorTorneo(torneo, vista); // le paso la lista de equipos y la vista

		// Ejecutar el sorteo de octavos
		controlador.ejecutarTorneo(equipos);// por ejemplo.
		
		// Guardar el torneo
		controlador.guardarTorneo("torneo.ser");// ordena guardar en el archivo torneo.ser
		
		// Recuperar el torneo
		controlador.cargarTorneo("torneo.ser");
	}

}
