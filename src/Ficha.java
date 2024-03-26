/**
 * @author cosmincalin
 * @coauthor noacemeli
 *
 * 08:45:21 PM
 * 
 * Ficha.java
 */
// Clase abstracta que representa una ficha de ajedrez.
public abstract class Ficha {
	protected Color color;

	public Ficha(Color color) {
		this.color = color;
	}

	public abstract String representacion();

	public abstract boolean movimientoEsLegal(int filaOrigen, int colOrigen, int filaDestino, int colDestino,
			Ficha[][] tablero);

	public boolean esBlanco() {
		return this.color == Color.BLANCO;
	}
}
