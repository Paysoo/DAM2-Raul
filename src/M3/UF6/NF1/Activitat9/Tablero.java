package activitat9m3uf6;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Tablero {
		
	private Ficha[][] fichas = new Ficha[8][8];
	

	Ficha ficha = new Ficha();
	EscacsGUI escacsGUI;
	
	public Tablero() {
		
		fichas[0][0] = new Ficha('t', "negra");
		fichas[0][1] = new Ficha('c', "negra");
		fichas[0][2] = new Ficha('a', "negra");
		fichas[0][3] = new Ficha('q', "negra");
		fichas[0][4] = new Ficha('k', "negra");
		fichas[0][5] = new Ficha('a', "negra");
		fichas[0][6] = new Ficha('c', "negra");
		fichas[0][7] = new Ficha('t', "negra");
		fichas[1][0] = new Ficha('p', "negra");
		fichas[1][1] = new Ficha('p', "negra");
		fichas[1][2] = new Ficha('p', "negra");
		fichas[1][3] = new Ficha('p', "negra");
		fichas[1][4] = new Ficha('p', "negra");
		fichas[1][5] = new Ficha('p', "negra");
		fichas[1][6] = new Ficha('p', "negra");
		fichas[1][7] = new Ficha('p', "negra");
		
		fichas[7][0] = new Ficha('T', "blanca");
		fichas[7][1] = new Ficha('C', "blanca");
		fichas[7][2] = new Ficha('A', "blanca");
		fichas[7][3] = new Ficha('K', "blanca");
		fichas[7][4] = new Ficha('Q', "blanca");
		fichas[7][5] = new Ficha('A', "blanca");
		fichas[7][6] = new Ficha('C', "blanca");
		fichas[7][7] = new Ficha('T', "blanca");
		fichas[6][0] = new Ficha('P', "blanca");
		fichas[6][1] = new Ficha('P', "blanca");
		fichas[6][2] = new Ficha('P', "blanca");
		fichas[6][3] = new Ficha('P', "blanca");
		fichas[6][4] = new Ficha('P', "blanca");
		fichas[6][5] = new Ficha('P', "blanca");
		fichas[6][6] = new Ficha('P', "blanca");
                fichas[6][7] = new Ficha('P', "blanca");

		
	}
	
        public Ficha[][] getFichas() {
		return fichas;
	}
	
	public Tablero(Ficha[][]  fichas) {
		this.fichas = fichas;	
	}
	
	public boolean moverFicha(int filaActual, int columnaActual, int filaNueva, int columnaNueva, String jugador) {
		boolean posicionActualValida = false;
		boolean posicionNuevaValida = false;
                boolean movimientoHecho = false;
		
		char tipo = '.';
		String color = null;

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
						
			// Si la posicion indicada es una posicion valida
			if (filaNueva >= 0 && filaNueva <= 7 && columnaNueva >= 0 && columnaNueva <= 7) {
				posicionNuevaValida = true;
				
					// Llamo al metodo de la clase Ficha para comprobar si el movimiento es valido
					if (ficha.movimientoValido(filaActual, columnaActual, filaNueva, columnaNueva, fichas, tipo)) {
						
						fichas[filaActual][columnaActual] = null;
						fichas[filaNueva][columnaNueva] = new Ficha(tipo, color);
						posicionNuevaValida = true;
						movimientoHecho = true;
					} else {
						posicionNuevaValida = false;
					
					}

			} else {
				
				System.out.println("La posicion indicada no existe");
				posicionNuevaValida = false;

			}
                
                return movimientoHecho;

	}
	
	public boolean partidaEnCurso() {
		boolean reyesVivos = false;

		int reyes = 0;
		int reyBlanco = 0;
		int reyNegro = 0;

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {

				if (this.fichas[i][j] != null) {

					char ficha = this.fichas[i][j].getTipo();

					if (ficha == 'K' || ficha == 'k') {
						reyes++;
						if (ficha == 'K') {
							reyBlanco++;
						} else {
							reyNegro++;
						}
					}
				}

			}
		}

		if (reyes == 2) {
			reyesVivos = true;

		} else {
			
			if (reyBlanco == 1) {
				System.out.println("La partida ha terminado, ganan las blancas");
                                JOptionPane.showMessageDialog(null, "GANAN LAS BLANCAS");
			} else {
				System.out.println("La partida ha terminado, ganan las negras");
                                JOptionPane.showMessageDialog(null, "GANAN LAS NEGRAS");

			}
			
			reyesVivos = false;
		}

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
