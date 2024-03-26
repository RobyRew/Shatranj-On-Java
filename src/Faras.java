/**
 * @author cosmincalin
 * @coauthor noacemeli
 *
 * 09:19:22 PM
 * 
 * Faras.java
 */
//
public class Faras extends Ficha {
    public Faras(Color color) {
        super(color);
    }

    @Override
    public String representacion() {
        return color == Color.BLANCO ? "f" : "F"; // Usamos "C" como representación de Faras
    }

    @Override
    public boolean movimientoEsLegal(int filaOrigen, int colOrigen, int filaDestino, int colDestino, Ficha[][] tablero) {
        // Calcula la diferencia absoluta en fila y columna para determinar si el movimiento es en "L"
        int diffFila = Math.abs(filaDestino - filaOrigen);
        int diffCol = Math.abs(colDestino - colOrigen);

        // Verifica si el movimiento es legal para Faras (en "L")
        return (diffFila == 2 && diffCol == 1) || (diffFila == 1 && diffCol == 2);
    }
}
