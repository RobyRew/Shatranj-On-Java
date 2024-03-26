/**
 * @author cosmincalin
 * @coauthor noacemeli
 *
 * 09:15:57 PM
 * 
 * Ruhk.java
 */
// Clase que representa una ficha de torre en el juego de ajedrez.
public class Ruhk extends Ficha {
    public Ruhk(Color color) {
        super(color);
    }

    @Override
    public String representacion() {
        return color == Color.BLANCO ? "r" : "R";
    }

    @Override
    public boolean movimientoEsLegal(int filaOrigen, int colOrigen, int filaDestino, int colDestino, Ficha[][] tablero) {
        // Verificar movimiento horizontal
        if (filaOrigen == filaDestino) {
            int inicio = Math.min(colOrigen, colDestino) + 1;
            int fin = Math.max(colOrigen, colDestino);
            for (int col = inicio; col < fin; col++) {
                if (tablero[filaOrigen][col] != null) {
                    return false; // Movimiento bloqueado
                }
            }
            return true;
        }
        // Verificar movimiento vertical
        else if (colOrigen == colDestino) {
            int inicio = Math.min(filaOrigen, filaDestino) + 1;
            int fin = Math.max(filaOrigen, filaDestino);
            for (int fila = inicio; fila < fin; fila++) {
                if (tablero[fila][colOrigen] != null) {
                    return false; // Movimiento bloqueado
                }
            }
            return true;
        }
        // No es ni horizontal ni vertical
        return false;
    }
}