
package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import excepciones.NumeroEquiposInvalidoException; //permite usar mi excepción personalizada
import java.util.Collections; //nos permitirá mezclar aleatoriamente los equipos mediante Collections.shuffle().
import excepciones.SorteoInvalidoException;
import java.util.Random; // necesario  para definir el equipo ganador de forma aleatoria. 
//Necesarios para serializar
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;

public class Torneo implements Serializable {
	private static final long serialVersionUID = 1L;
	private ArrayList<Equipo> equipos;
	private ArrayList<Partido> historialPartidos;
	// Constructor
	public Torneo(ArrayList<Equipo> equipos) {
		this.equipos = equipos;
		this.historialPartidos = new ArrayList<>();
	}
	// Validar la cantidad de equipos
	public void validarEquipos(ArrayList<Equipo> participantes) throws NumeroEquiposInvalidoException {

		int cantidad = participantes.size();

		if (cantidad < 2 || (cantidad & (cantidad - 1)) != 0) { // si el numero ingresado no es potencia de 2
			throw new NumeroEquiposInvalidoException("La cantidad de equipos debe ser una potencia de 2.");
		}
	}
	// Iniciar el sorteo de una etapa
	public void sortearEtapa(ArrayList<Equipo> participantes, String etapa)
			throws NumeroEquiposInvalidoException, SorteoInvalidoException {
		validarEquipos(participantes);
		ArrayList<Equipo> equiposDisponibles = new ArrayList<>(participantes);
		Collections.shuffle(equiposDisponibles); //mezcla aleatorianente los elementos de la lista equipos. 
		sortearRecursivo(equiposDisponibles, etapa);
	}
	// Método recursivo para emparejar equipos
	private void sortearRecursivo(ArrayList<Equipo> equiposDisponibles, String etapa) throws SorteoInvalidoException {
		// Condición de finalización
		if (equiposDisponibles.isEmpty()) {
			return;
		}
		// Comprobar que queden equipos en parejas
		if (equiposDisponibles.size() % 2 != 0) {
			throw new SorteoInvalidoException("No es posible realizar el emparejamiento.");
		}
		// Seleccionar los dos primeros equipos y los elimina de la lista disponible
		// para que no se repitan.
		Equipo equipo1 = equiposDisponibles.remove(0);
		Equipo equipo2 = equiposDisponibles.remove(0);
		// Registrar el partido
		historialPartidos.add(new Partido(equipo1, equipo2, etapa));
		// Llamada recursiva con los equipos restantes
		sortearRecursivo(equiposDisponibles, etapa);
	}

	// Obtener el historial de partidos
	public ArrayList<Partido> getHistorialPartidos() {
		return historialPartidos;
	}

	// Seleccionar aleatoriamente los ganadores de una etapa
	public ArrayList<Equipo> seleccionarGanadores(String etapa) {
		ArrayList<Equipo> ganadores = new ArrayList<>();
		Random aleatorio = new Random(); // creo un numero aleatorio
		for (Partido partido : historialPartidos) {

			if (partido.getEtapa().equals(etapa)) {
				Equipo ganador;
				if (aleatorio.nextBoolean()) { // devuelve aleatoriamente true o false.
					ganador = partido.getEquipo1();
				} else {
					ganador = partido.getEquipo2();
				}
				partido.setGanador(ganador); // establece el equipo ganador.
				ganadores.add(ganador);
			}
		}
		return ganadores;
	}
	
	//Serializando para guardar el torneo en un archivo
	public void guardarTorneo(String nombreArchivo) throws IOException {

	    ObjectOutputStream salida = new ObjectOutputStream( // para escribir ojjetos dentro del archivo
	            new FileOutputStream(nombreArchivo)); //creo o abro el archivo 

	    salida.writeObject(this); // guardo el objeto tornero representado por el this. es decir, guardo el torneo completo incluyendo partidos e historial.

	    salida.close();//cierro el archivo después de escribir
	}
	
	// para cargar el torneo desde un archivo
	public static Torneo cargarTorneo(String nombreArchivo)
	        throws IOException, ClassNotFoundException {

	    ObjectInputStream entrada = new ObjectInputStream( // leo objeto
	            new FileInputStream(nombreArchivo)); // abre el archivo

	    Torneo torneo = (Torneo) entrada.readObject();//recupera el objeto almacenado en entrada.

	    entrada.close(); // cierro el objeto

	    return torneo; // devulve el objeto torno con trodo su contenido.
	}
	
	
	
}
