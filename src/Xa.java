/**
 * @author cosmincalin
 * @coauthor noacemeli
 *
 * 08:44:11 PM
 * 
 * Xa.java
 */
// Clase que representa una pieza de ajedrez de tipo Xa.
public class Xa extends Ficha {
    public Xa(Color color) {
        super(color);
    }

    @Override
    public String representacion() {
        return color == Color.BLANCO ? "x" : "X"; // Usamos "X" como representación del Xa (Rey)
    }

    @Override
    public boolean movimientoEsLegal(int filaOrigen, int colOrigen, int filaDestino, int colDestino, Ficha[][] tablero) {
        // Verifica que el movimiento sea dentro de una casilla de distancia en cualquier dirección
        int diffFila = Math.abs(filaDestino - filaOrigen);
        int diffCol = Math.abs(colDestino - colOrigen);

        // El Rey puede moverse una casilla en cualquier dirección
        boolean esMovimientoValido = (diffFila <= 1) && (diffCol <= 1);

        // Asegurarse de que no se está intentando un movimiento nulo (quedarse en la misma casilla)
        boolean esMovimientoNulo = diffFila == 0 && diffCol == 0;

        return esMovimientoValido && !esMovimientoNulo;
    }
}
