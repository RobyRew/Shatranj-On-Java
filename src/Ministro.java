/**
 * @author cosmincalin
 * @coauthor noacemeli
 *
 * 09:18:49 PM
 * 
 * Ministro.java
 */
//
public class Ministro extends Ficha {
    public Ministro(Color color) {
        super(color);
    }

    @Override
    public String representacion() {
        return color == Color.BLANCO ? "m" : "M"; // Usamos "M" como representación del Ministro
    }

    @Override
    public boolean movimientoEsLegal(int filaOrigen, int colOrigen, int filaDestino, int colDestino, Ficha[][] tablero) {
        // Verifica que el movimiento sea exactamente una casilla en diagonal
        int diffFila = Math.abs(filaDestino - filaOrigen);
        int diffCol = Math.abs(colDestino - colOrigen);
        boolean esMovimientoDiagonal = diffFila == 1 && diffCol == 1;

        return esMovimientoDiagonal;
    }
}
