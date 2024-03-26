/**
 * @author cosmincalin
 * @coauthor noacemeli
 *
 * 08:44:11 PM
 * 
 * Xatranj.java
 */
// Clase que representa una pieza de ajedrez de tipo Xa.
import java.util.Scanner;

public class Shatranj {
	// Definir los códigos de color al inicio de tu clase (Pijadas de Java muy
	// chulas).
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_BOLD = "\u001B[1m";

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Tablero tablero = new Tablero();
		// Indicador del turno del jugador, true para Blanco, false para Negro
		boolean turnoBlanco = true;

		// Continuar el juego hasta que se cumpla que el estado es true
		boolean estadoDelJuego = true;
		while (estadoDelJuego) {
			tablero.imprimirTablero();

			// Indicar de quién es el turno
			int[] filaColOrigen = new int[2];
			int[] filaColDestino = new int[2];
			
			if (tablero.estaEnJaque(turnoBlanco)) {
                System.out.println((turnoBlanco ? ANSI_YELLOW + "El Xa blanco" : "El Xa negro") + " está en jaque!" + ANSI_RESET);
            }

			System.out.println("Turno de " + (turnoBlanco ? "Blanco (minúsculas)" : "Negro (mayúsculas)"));
			// Debug: Mostrar turno actual
			// System.out.println("[Debug] Turno actual: " + (turnoBlanco ? "Blanco" :
			// "Negro"));

			System.out.println("Posicion" + ANSI_BOLD + " ORIGEN " + ANSI_RESET + "(ejemplo: 8b): ");
			String origen = scanner.nextLine();
			// Debug: Mostrar posición de origen introducida
			// System.out.println("[Debug] Posición de origen introducida: " + origen);

			if (!validarPosicion(origen, filaColOrigen)) {
				continue;
			}

			System.out.println("Posicion" + ANSI_BOLD + " DESTINO " + ANSI_RESET + "(ejemplo: 6c): ");
			String destino = scanner.nextLine();
			// Debug: Mostrar posición de destino introducida
			// System.out.println("[Debug] Posición de destino introducida: " + destino);

			if (!validarPosicion(destino, filaColDestino)) {
				continue;
			}

			int filaOrigen = filaColOrigen[0];
			int colOrigen = filaColOrigen[1];
			int filaDestino = filaColDestino[0];
			int colDestino = filaColDestino[1];

			Ficha pieza = tablero.getPieza(filaOrigen, colOrigen);
			// Verificar si la pieza corresponde al jugador del turno actual
			if (pieza != null && pieza.esBlanco() == turnoBlanco) {
				boolean movimientoExitoso = tablero.moverPieza(filaOrigen, colOrigen, filaDestino, colDestino);
				if (movimientoExitoso) {
					System.out.println(ANSI_GREEN + "\nMovimiento realizado con éxito.\n\n" + ANSI_RESET);
					// Cambiar el turno
					turnoBlanco = !turnoBlanco;
				} else {
					System.out.println(ANSI_RED + "\nMovimiento ilegal o posición inválida.\n\n" + ANSI_RESET);
				}
			} else {
				System.out.println(ANSI_YELLOW
						+ "\nLa pieza seleccionada no corresponde al jugador actual o la casilla está vacía.\n\n"
						+ ANSI_RESET);
			}
			
			// Añadido: Comprobaciones para terminar el juego
			
			if (tablero.esJaqueMate(turnoBlanco)) {
			    System.out.println("¡Jaque Mate! " + (turnoBlanco ? "Ganan las negras" : "Ganan las blancas"));
			    estadoDelJuego = false; // Termina el juego
			}
			if (tablero.juegoTerminado()) {
				estadoDelJuego = false; // Salir del bucle si el juego ha terminado
			}
		}
		scanner.close(); // Cerrar el Scanner cuando ya no se necesita
	    System.out.println("Gracias por jugar. ¡Hasta la próxima!");
	}

	private static boolean validarPosicion(String posicion, int[] filaCol) {
		if (posicion == null || posicion.length() != 2) {
			System.out.println(ANSI_YELLOW + "Formato de posición incorrecto. Debe ser como '8b'.\n\n" + ANSI_RESET);
			return false;
		}

		char filaChar = posicion.charAt(0);
		char colChar = posicion.charAt(1);

		if (filaChar < '1' || filaChar > '8' || colChar < 'a' || colChar > 'h') {
			System.out.println(
					ANSI_YELLOW + "Posición fuera de rango. La fila debe ser 1-8 y la columna a-h.\n\n" + ANSI_RESET);
			return false;
		}

		filaCol[0] = '8' - filaChar;
		filaCol[1] = colChar - 'a';

		return true;
	}

}
