
package vista;

import java.util.ArrayList;// para trabajar con lista de elementos
import modelo.Partido; //necesario 

public class VistaTorneo {

	// Mostrar los partidos de una etapa
	public void mostrarPartidos(ArrayList<Partido> partidos, String etapa) {// se recibe la lista de partidos y la
																			// guardo en partidos.Ademas recibo la etapa que debo mostrar.

		System.out.println("\n========== " + etapa.toUpperCase() + " =========="); // para que se vea mejo y en mayusuclas.
		for (Partido partido : partidos) { // recorro la coleccion
			if (partido.getEtapa().equals(etapa)) { // para mostrar los partidos correspondientes a la etapa solicitada. 
				System.out.println(partido);//muestro el partido
			}
		}
		System.out.println("============================");
	}

	// Mostrar mensajes de error
	public void mostrarError(String mensaje) {
		System.out.println("ERROR: " + mensaje);
	}

}
