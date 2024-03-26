/**
 * @author cosmincalin
 * @coauthor noacemeli
 *
 * 09:15:43 PM
 * 
 * Elefante.java
 */
// Clase que representa una ficha de elefante en el juego de ajedrez.
public class Elefante extends Ficha {
    public Elefante(Color color) {
        super(color);
    }

    @Override
    public String representacion() {
        return color == Color.BLANCO ? "e" : "E"; // Usamos "E" como representación de Elefante
    }

    @Override
    public boolean movimientoEsLegal(int filaOrigen, int colOrigen, int filaDestino, int colDestino, Ficha[][] tablero) {
        // Verifica que el movimiento sea exactamente dos casillas en diagonal
        int diffFila = Math.abs(filaDestino - filaOrigen);
        int diffCol = Math.abs(colDestino - colOrigen);
        boolean esMovimientoDiagonal = diffFila == 2 && diffCol == 2;

        // Asegurarse de que no hay piezas en la casilla intermedia
        int filaIntermedia = (filaOrigen + filaDestino) / 2;
        int colIntermedia = (colOrigen + colDestino) / 2;
        boolean casillaIntermediaLibre = tablero[filaIntermedia][colIntermedia] == null;

        return esMovimientoDiagonal && casillaIntermediaLibre;
    }
}
