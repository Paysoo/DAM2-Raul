package M6.UF2.Activitat5;

import java.util.Scanner;

public class Tablero {
	
	Scanner teclado = new Scanner(System.in);
	
	private Ficha[][] fichas = new Ficha[8][8];
	
	public Ficha[][] getFichas() {
		return fichas;
	}

	Ficha ficha = new Ficha();
	
	Main main = new Main(null);
	
	public Tablero() {
		
		fichas[0][0] = new Ficha('N', "negra");
		fichas[0][2] = new Ficha('N', "negra");
		fichas[0][4] = new Ficha('N', "negra");
		fichas[0][6] = new Ficha('N', "negra");
		fichas[1][1] = new Ficha('N', "negra");
		fichas[1][3] = new Ficha('N', "negra");
		fichas[1][5] = new Ficha('N', "negra");
		fichas[1][7] = new Ficha('N', "negra");
		fichas[2][0] = new Ficha('N', "negra");
		fichas[2][2] = new Ficha('N', "negra");
		fichas[2][4] = new Ficha('N', "negra");
		fichas[2][6] = new Ficha('N', "negra");
		
		fichas[5][1] = new Ficha('B', "blanca");
		fichas[5][3] = new Ficha('B', "blanca");
		fichas[5][5] = new Ficha('B', "blanca");
		fichas[5][7] = new Ficha('B', "blanca");
		fichas[6][0] = new Ficha('B', "blanca");
		fichas[6][2] = new Ficha('B', "blanca");
		fichas[6][4] = new Ficha('B', "blanca");
		fichas[6][6] = new Ficha('B', "blanca");
		fichas[7][1] = new Ficha('B', "blanca");
		fichas[7][3] = new Ficha('B', "blanca");
		fichas[7][5] = new Ficha('B', "blanca");
		fichas[7][7] = new Ficha('B', "blanca");
		
	}
	
	
	public Tablero(Ficha[][]  fichas) {
		this.fichas = fichas;	
	}
	
	public void moverFicha(int partidaId, MovimientosEntity movimiento) {
		boolean posicionActualValida = false;
		boolean posicionNuevaValida = false;
		
		char tipo = '.';
		String color = null;
		int filaActual = 0;
		int columnaActual = 0;
		int filaNueva = 0;
		int columnaNueva = 0;
		String jugador = main.getJugador();

		do {
			System.out.println("En que posicion est� la ficha que quieres mover?");
			System.out.print("Fila: ");
			filaActual = teclado.nextInt();
			System.out.print("Columna: ");
			columnaActual = teclado.nextInt();

			if (filaActual <= 7 && filaActual >= 0 && columnaActual <= 7 && columnaActual >= 0 && !(fichas[filaActual][columnaActual] == null)) {
				tipo = fichas[filaActual][columnaActual].getTipo();						
				color = fichas[filaActual][columnaActual].getColor();

				if (color.equals("negra") && jugador.equals("negro") || color.equals("blanca") && jugador.equals("blanco")) {
					posicionActualValida = true;
				} else {
					System.out.println("Esa no es una de tus fichas.");
					posicionActualValida = false;
				}

			} else {
				System.out.println("Posicion fuera del tablero.");
				posicionActualValida = false;
			}
		} while(!posicionActualValida);
			
		do {
			System.out.println("A que posicion quieres mover la ficha?");
			System.out.print("Fila: ");
			filaNueva = teclado.nextInt();
			System.out.print("Columna: ");
			columnaNueva = teclado.nextInt();
			
			// Si la posicion indicada es una posicion valida
			if (filaNueva >= 0 && filaNueva <= 7 && columnaNueva >= 0 && columnaNueva <= 7) {
				posicionNuevaValida = true;
				
					// Llamo al metodo de la clase Ficha para comprobar si el movimiento es valido
					if (ficha.movimientoValido(filaActual, columnaActual, filaNueva, columnaNueva, fichas, tipo)) {

						movimiento.setIdPartida(partidaId);
						movimiento.setFilaOrigen(filaActual);
						movimiento.setColumnaOrigen(columnaActual);
						movimiento.setFilaDestino(filaNueva);
						movimiento.setColumnaDestino(columnaNueva);

						fichas[filaActual][columnaActual] = null;
						fichas[filaNueva][columnaNueva] = new Ficha(tipo, color);
						posicionNuevaValida = true;
						
					} else {
						posicionNuevaValida = false;
					
					}

			} else {
				
				System.out.println("La posicion indicada no existe");
				posicionNuevaValida = false;

			}

		} while (!posicionNuevaValida);

	}
	
	public boolean partidaEnCurso() {
		boolean reyesVivos = true;

//		int reyes = 0;
//		int reyBlanco = 0;
//		int reyNegro = 0;
//
//		for (int i = 0; i < 8; i++) {
//			for (int j = 0; j < 8; j++) {
//
//				if (this.fichas[i][j] != null) {
//
//					char ficha = this.fichas[i][j].getTipo();
//
//					if (ficha == 'K' || ficha == 'k') {
//						reyes++;
//						if (ficha == 'K') {
//							reyBlanco++;
//						} else {
//							reyNegro++;
//						}
//					}
//				}
//
//			}
//		}
//
//		if (reyes == 2) {
//			reyesVivos = true;
//
//		} else {
//
//			if (reyBlanco == 1) {
//				System.out.println("La partida ha terminado, ganan las blancas");
//
//			} else {
//				System.out.println("La partida ha terminado, ganan las negras");
//
//			}
//
//			reyesVivos = false;
//		}

		return reyesVivos;

	}
	
	// METODO MOSTRAR TABLERO
	public void mostrar() {
		char letras = 'A';
		System.out.print("  ");
		
		for (int i = 0; i < 8; i++) {
			System.out.print("_" + letras);
			letras++;
		}
		
		System.out.println();
		
		for (int i = 0; i < 8; i++) {
			System.out.print(i + "| ");
			
			for (int j = 0; j < 8; j++) {
				
				if ( this.fichas[i][j] == null) {
					System.out.print('·' + " ");
				}
				else {
					System.out.print(this.fichas[i][j].getTipo() + " ");
				}
			}
			System.out.println();;
		}
		
	}
	
}
