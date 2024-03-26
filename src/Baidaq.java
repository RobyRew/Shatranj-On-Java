/**
 * @author cosmincalin
 * @coauthor noacemeli
 *
 * 09:23:32 PM
 * 
 * Baidaq.java
 */
// Clase que representa una ficha de Baidaq en el juego de ajedrez.
public class Baidaq extends Ficha {
    public Baidaq(Color color) {
        super(color);
    }

    @Override
    public String representacion() {
        return color == Color.BLANCO ? "b" : "B"; // Usamos "P" como representación de Baidaq
    }

    @Override
    public boolean movimientoEsLegal(int filaOrigen, int colOrigen, int filaDestino, int colDestino, Ficha[][] tablero) {
        // Calcula la dirección del movimiento basado en el color de la pieza
        int direccion = this.color == Color.BLANCO ? -1 : 1; // Blanco se mueve hacia "arriba" en el tablero

        // Movimiento simple hacia adelante
        boolean movimientoSimple = colOrigen == colDestino && filaDestino - filaOrigen == direccion && tablero[filaDestino][colDestino] == null;

        // Captura diagonal
        boolean movimientoDiagonal = Math.abs(colDestino - colOrigen) == 1 && filaDestino - filaOrigen == direccion && tablero[filaDestino][colDestino] != null && tablero[filaDestino][colDestino].color != this.color;

        return movimientoSimple || movimientoDiagonal;
    }
}
