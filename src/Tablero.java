/**
 * @author cosmincalin
 * @coauthor noacemeli
 *
 * 08:46:32 PM
 * 
 * Tablero.java
 */
// Clase que representa el tablero de juego.
public class Tablero {
	public static final String ANSI_BOLD = "\u001B[1m";
	public static final String ANSI_RESET = "\u001B[0m";
	
	private Ficha[][] tableroObj;

	public Tablero() {
		this.tableroObj = new Ficha[8][8];
		inicializarTablero();
		// Debug: Tablero inicializado
		// System.out.println("[Debug] Tablero inicializado correctamente.");
	}

	// Inicialización de piezas específicas de Shatranj en sus posiciones iniciales
	private void inicializarTablero() {
		// Baidaq (Peones)
		for (int i = 0; i < 8; i++) {
			tableroObj[1][i] = new Baidaq(Color.NEGRO);
			tableroObj[6][i] = new Baidaq(Color.BLANCO);
		}

		// Ruhk (Torres)
		tableroObj[0][0] = new Ruhk(Color.NEGRO);
		tableroObj[0][7] = new Ruhk(Color.NEGRO);
		tableroObj[7][0] = new Ruhk(Color.BLANCO);
		tableroObj[7][7] = new Ruhk(Color.BLANCO);

		// Faras (Caballos)
		tableroObj[0][1] = new Faras(Color.NEGRO);
		tableroObj[0][6] = new Faras(Color.NEGRO);
		tableroObj[7][1] = new Faras(Color.BLANCO);
		tableroObj[7][6] = new Faras(Color.BLANCO);

		// Elefantes (equivalentes a los alfiles en el ajedrez moderno, pero con
		// movimientos diferentes)
		tableroObj[0][2] = new Elefante(Color.NEGRO);
		tableroObj[0][5] = new Elefante(Color.NEGRO);
		tableroObj[7][2] = new Elefante(Color.BLANCO);
		tableroObj[7][5] = new Elefante(Color.BLANCO);

		// Ministro (Reina) (equivalentes a la dama en el ajedrez moderno, pero con
		// movimientos limitados)
		tableroObj[0][3] = new Ministro(Color.NEGRO);
		tableroObj[7][3] = new Ministro(Color.BLANCO);

		// Xa (Rey)
		tableroObj[0][4] = new Xa(Color.NEGRO);
		tableroObj[7][4] = new Xa(Color.BLANCO);
	}

	// Se pide para imprimir el tablero actual
	public void imprimirTablero() {
		System.out.println(" ----------------------------\n");
		System.out.println(ANSI_BOLD + "   a b c d e f g h" + ANSI_RESET);
		System.out.println(ANSI_BOLD + " +-----------------+" + ANSI_RESET);
		int hackModificadorInicialFila = 8;
		for (int fila = 0; fila <= 7; fila++) { // Empezamos desde la fila 8 hacia la 1 (índices del 7 al 0)
			System.out.print(ANSI_BOLD + (hackModificadorInicialFila) + "|" + ANSI_RESET); // Imprime el número de fila al inicio, ajustando el
																	// índice
			for (int columna = 0; columna < 8; columna++) {
				if (tableroObj[fila][columna] == null) {
					System.out.print(" ."); // Espacio vacío
				} else {
					System.out.print(" " + tableroObj[fila][columna].representacion() + ANSI_RESET); // Representación de la pieza
				}
			}
			System.out.println(" |" + (ANSI_BOLD + hackModificadorInicialFila-- + ANSI_RESET)); // Cierra la fila con su número
		}
		System.out.println(ANSI_BOLD + " +-----------------+" + ANSI_RESET);
		System.out.println(ANSI_BOLD + "   a b c d e f g h\n" + ANSI_RESET);
	}

	public boolean moverPieza(int filaOrigen, int colOrigen, int filaDestino, int colDestino) {
		Ficha pieza = getPieza(filaOrigen, colOrigen);

		// Debug: Intentando mover pieza
		// System.out.println("[Debug] Intentando mover pieza de " + filaOrigen + "," +
		// colOrigen + " a " + filaDestino + "," + colDestino);

		if (pieza != null && pieza.movimientoEsLegal(filaOrigen, colOrigen, filaDestino, colDestino, tableroObj)) {
			tableroObj[filaDestino][colDestino] = pieza;
			tableroObj[filaOrigen][colOrigen] = null;

			// Debug: Movimiento realizado
			// System.out.println("[Debug] Movimiento realizado con éxito.");

			return true;
		}

		// Debug: Movimiento fallido
		// System.out.println("[Debug] Movimiento fallido o ilegal.");
		return false;
	}

	public Ficha getPieza(int fila, int columna) {
		// Debug: Obteniendo pieza en posición
		// System.out.println("[Debug] Obteniendo pieza en posición " + fila + "," +
		// columna);

		if (fila >= 0 && fila < 8 && columna >= 0 && columna < 8) {
			return tableroObj[fila][columna];
		} else {
			return null; // Fuera del tablero
		}
	}

	public boolean juegoTerminado() {
		boolean blancoTieneXa = false;
		boolean negroTieneXa = false;

		for (int fila = 0; fila < tableroObj.length; fila++) {
			for (int columna = 0; columna < tableroObj[fila].length; columna++) {
				Ficha pieza = tableroObj[fila][columna];
				if (pieza instanceof Xa) {
					if (pieza.esBlanco()) {
						blancoTieneXa = true;
					} else {
						negroTieneXa = true;
					}
				}
			}
		}

		// Si alguno de los jugadores no tiene su Xa, el juego termina.
		if (!blancoTieneXa || !negroTieneXa) {
			System.out.println("¡Juego terminado! " + (blancoTieneXa ? "Ganan las blancas" : "Ganan las negras"));
			return true;
		}

		// Verificar si alguno de los jugadores se ha quedado sin piezas.
		boolean blancoTienePiezas = false;
		boolean negroTienePiezas = false;
		for (int fila = 0; fila < tableroObj.length; fila++) {
			for (int columna = 0; columna < tableroObj[fila].length; columna++) {
				Ficha pieza = tableroObj[fila][columna];
				if (pieza != null) {
					if (pieza.esBlanco()) {
						blancoTienePiezas = true;
					} else {
						negroTienePiezas = true;
					}
				}
			}
		}

		if (!blancoTienePiezas || !negroTienePiezas) {
			System.out.println("¡Juego terminado! " + (blancoTienePiezas ? "Ganan las blancas" : "Ganan las negras"));
			return true;
		}

		// Si no se cumple ninguna condición de terminación, el juego continúa.
		return false;
	}
	
	
	// VERIFICADORES DE JAQUE Y JAQUE MATE ESTAN EN BETA AUN ESTOY HACIENDO PRUEBAS.
	
	// Verifica si el jugador actual está en jaque
	public boolean estaEnJaque(boolean turnoBlanco) {
	    // Identifica la posición del Xa del jugador actual
	    int filaXa = -1, colXa = -1;
	    for (int fila = 0; fila < 8; fila++) {
	        for (int col = 0; col < 8; col++) {
	            Ficha pieza = tableroObj[fila][col];
	            if (pieza instanceof Xa && pieza.esBlanco() == turnoBlanco) {
	                filaXa = fila;
	                colXa = col;
	                break;
	            }
	        }
	        if (filaXa != -1) break; // Salir del bucle si ya encontramos al Xa
	    }

	    // Verifica si alguna de las piezas del oponente puede capturar al Xa
	    for (int fila = 0; fila < 8; fila++) {
	        for (int col = 0; col < 8; col++) {
	            Ficha pieza = tableroObj[fila][col];
	            if (pieza != null && pieza.esBlanco() != turnoBlanco) {
	                if (pieza.movimientoEsLegal(fila, col, filaXa, colXa, tableroObj)) {
	                    return true; // El Xa está en jaque
	                }
	            }
	        }
	    }
	    return false; // El Xa no está en jaque
	}
	
	// Verifica si el jugador actual está en jaque mate
	public boolean esJaqueMate(boolean turnoBlanco) {
	    if (!estaEnJaque(turnoBlanco)) {
	        return false; // No puede ser jaque mate si el Xa no está en jaque
	    }

	    // Intenta todos los movimientos posibles para sacar al Xa del jaque
	    for (int filaOrigen = 0; filaOrigen < 8; filaOrigen++) {
	        for (int colOrigen = 0; colOrigen < 8; colOrigen++) {
	            Ficha pieza = tableroObj[filaOrigen][colOrigen];
	            if (pieza != null && pieza.esBlanco() == turnoBlanco) {
	                for (int filaDestino = 0; filaDestino < 8; filaDestino++) {
	                    for (int colDestino = 0; colDestino < 8; colDestino++) {
	                        if (pieza.movimientoEsLegal(filaOrigen, colOrigen, filaDestino, colDestino, tableroObj)) {
	                            // Realiza el movimiento hipotéticamente
	                            Ficha piezaCapturada = tableroObj[filaDestino][colDestino];
	                            tableroObj[filaOrigen][colOrigen] = null;
	                            tableroObj[filaDestino][colDestino] = pieza;
	                            if (!estaEnJaque(turnoBlanco)) {
	                                // Deshacer el movimiento
	                                tableroObj[filaOrigen][colOrigen] = pieza;
	                                tableroObj[filaDestino][colDestino] = piezaCapturada;
	                                return false; // Existe al menos un movimiento que saca al Xa del jaque
	                            }
	                            // Deshacer el movimiento
	                            tableroObj[filaOrigen][colOrigen] = pieza;
	                            tableroObj[filaDestino][colDestino] = piezaCapturada;
	                        }
	                    }
	                }
	            }
	        }
	    }
	    return true; // Ningún movimiento puede sacar al Xa del jaque, es jaque mate
	}


	

}
