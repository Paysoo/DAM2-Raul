package M6.UF2.Activitat5;

public class Damas {

	private static String jugador;

	public Damas(String jugador) {
		this.jugador = jugador;
	}
	
	public static void main(String[] args) {

		Tablero tablero = new Tablero();

		jugador = "blanco";
		
		do {
			System.out.println("Turno jugador: " + jugador);
			
			tablero.mostrar();

			tablero.moverFicha();

			cambiarTurno();
			
		} while (tablero.partidaEnCurso());

	}

	// METODO CAMBIAR DE TURNO
	private static void cambiarTurno() {
		if (jugador.equals("blanco")) {
			jugador = "negro";
			
		} else {
			jugador = "blanco";

		}


	}

	public String getJugador() {
		return jugador;
	}

}
