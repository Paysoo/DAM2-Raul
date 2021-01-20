package M6.UF2.Activitat5;

public class Ficha {

	private char tipo;
	private String color;

	public Ficha(char tipo, String color) {
		this.tipo = tipo;
		this.color = color;

	}

	public Ficha() {

	}

	public boolean movimientoValido(int filaActual, int columnaActual, int filaNueva, int columnaNueva, Ficha[][] tablero, char tipo) {

		boolean movimientoValido = true;

		// PEONES (hacen falta dos condiciones porque solo se mueven en una direccion)
//		if (tipo == 'P') {
//
//
//			if (movimientoPeonBlanco(filaActual, columnaActual, filaNueva, columnaNueva, tablero)) {
//				movimientoValido = true;
//
//			} else {
//
//				movimientoValido = false;
//
//			}
//
//		} else if (tipo == 'p') {
//
//			if (movimientoPeonNegro(filaActual, columnaActual, filaNueva, columnaNueva, tablero)) {
//
//				movimientoValido = true;
//
//			} else {
//
//				movimientoValido = false;
//
//			}
//
//			// TORRES
//		} else if (tipo == 'T' || tipo == 't') {
//
//			if (movimientoTorre(filaActual, columnaActual, filaNueva, columnaNueva, tablero)) {
//
//				movimientoValido = true;
//
//			} else {
//
//				movimientoValido = false;
//
//			}
//
//		} else if (tipo == 'C' || tipo == 'c') {
//
//			if (movimientoCaballo(filaActual, columnaActual, filaNueva, columnaNueva, tablero)) {
//
//				movimientoValido = true;
//
//			} else {
//
//				movimientoValido = false;
//			}
//
//		} else if (tipo == 'A' || tipo == 'a') {
//
//			if (movimientoAlfil(filaActual, columnaActual, filaNueva, columnaNueva, tablero)) {
//
//				movimientoValido = true;
//
//			} else {
//
//				movimientoValido = false;
//			}
//
//		} else if (tipo == 'K' || tipo == 'k') {
//
//			if (movimientoRey(filaActual, columnaActual, filaNueva, columnaNueva, tablero)) {
//
//				movimientoValido = true;
//
//			} else {
//
//				movimientoValido = false;
//
//			}
//
//		} else if (tipo == 'Q' || tipo == 'q') {
//
//			if (movimientoReina(filaActual, columnaActual, filaNueva, columnaNueva, tablero)) {
//
//				movimientoValido = true;
//
//			} else {
//
//				movimientoValido = false;
//
//			}
//
//		}
		return  movimientoValido;
	}

	private boolean movimientoPeonBlanco(int filaActual, int columnaActual, int filaNueva, int columnaNueva,Ficha[][] tablero) {
		boolean valido = false;
		

		if ((filaNueva == filaActual-1 && columnaNueva == columnaActual) || (filaActual == 6 && (filaNueva == filaActual - 2) && columnaNueva == columnaActual)) {			
			valido = true;	

		} else if (tablero[filaNueva][columnaNueva] != null 
				&& !(tablero[filaNueva][columnaNueva].getColor().equals(tablero[filaActual][columnaActual].getColor()))
				&& (filaNueva == filaActual-1 && (columnaNueva == columnaActual+1 || columnaNueva == columnaActual-1))) {
			
			valido = true;

		} else {
			valido = false;

		}
		return valido;
	}

	private boolean movimientoPeonNegro(int filaActual, int columnaActual, int filaNueva, int columnaNueva,Ficha[][] tablero) {
		boolean valido = false;

		if ((filaNueva == filaActual+1 && columnaNueva == columnaActual) || (filaActual == 1 && (filaNueva == filaActual + 2) && columnaNueva == columnaActual)) {			
			valido = true;	

		} else if (tablero[filaNueva][columnaNueva] != null 
				&& !(tablero[filaNueva][columnaNueva].getColor().equals(tablero[filaActual][columnaActual].getColor()))
				&& (filaNueva == filaActual+1 && (columnaNueva == columnaActual-1 || columnaNueva == columnaActual+1))) {
			
			valido = true;

		} else {
			valido = false;

		}
		return valido;
	}

	private boolean movimientoTorre(int filaActual, int columnaActual, int filaNueva, int columnaNueva,Ficha[][] tablero) {
		boolean valido = false;

		if (((columnaActual == columnaNueva && (filaNueva <= 7 && filaNueva >= 0 )) || 
				(filaActual == filaNueva && (columnaNueva <= 7 && columnaNueva >= 0)))
				&& (tablero[filaNueva][columnaNueva] == null 
				|| !(tablero[filaNueva][columnaNueva].getColor().equals(tablero[filaActual][columnaActual].getColor())))) {
			
			valido = true;

			// Compruebo si hay fichas en su camino
			if (columnaActual == columnaNueva) {
				if (filaActual > filaNueva) {
					for (int i = filaNueva; i < filaActual-1; i++) {
						if (!(tablero[i][columnaNueva] == null)) {
							valido = false;
							break;
						}
					}
					
				} else {
					for (int i = filaNueva; i > filaActual+1; i--) {
						if (!(tablero[i][columnaNueva] == null)) {
							valido = false;
							break;
						}
					}
				}
				
			} else {
				if (columnaActual > columnaNueva) {
					for (int i = columnaNueva; i < columnaActual-1; i++) {
						if (!(tablero[filaNueva][i] == null)) {
							valido = false;
							break;
						}
					}
				} else {
					for (int i = columnaNueva; i > columnaActual+1; i--) {
						if (!(tablero[filaNueva][i] == null)) {
							valido = false;
							break;
						}
					}
				}
			}

		} else {
			valido = false;

		}
		return valido;
	}

	private boolean movimientoCaballo(int filaActual, int columnaActual, int filaNueva, int columnaNueva,Ficha[][] tablero) {
		boolean valido = false;

		if ((((columnaNueva == columnaActual+2) && (filaNueva == filaActual+1)) || ((columnaNueva == columnaActual+2) && (filaNueva == filaActual-1))
				|| ((columnaNueva == columnaActual-2) && (filaNueva == filaActual-1)) || ((columnaNueva == columnaActual-2) && (filaNueva == filaActual+1))
				|| ((columnaNueva == columnaActual+1) && (filaNueva == filaActual+2)) || ((columnaNueva == columnaActual+1) && (filaNueva == filaActual-2))
				|| ((columnaNueva == columnaActual-1) && (filaNueva == filaActual-2)) || ((columnaNueva == columnaActual-1) && (filaNueva == filaActual+2)))
				&& (tablero[filaNueva][columnaNueva] == null 
				|| !(tablero[filaNueva][columnaNueva].getColor().equals(tablero[filaActual][columnaActual].getColor())))) {

			valido = true;

		} else {

			valido = false;
		}

		return valido;
	}

	private boolean movimientoAlfil(int filaActual, int columnaActual, int filaNueva, int columnaNueva,Ficha[][] tablero) {
		boolean valido = false;

		if ((Math.abs(columnaNueva - columnaActual) == Math.abs(filaNueva - filaActual))
				&& (tablero[filaNueva][columnaNueva] == null 
				|| !(tablero[filaNueva][columnaNueva].getColor().equals(tablero[filaActual][columnaActual].getColor())))) {

			valido = true;
			
			// COMPROBAR OBSTACULOS
//			int casillas = Math.abs(columnaNueva - columnaActual);
//			
//			if (filaNueva < filaActual && columnaNueva < columnaActual) {
//				int columna = columnaNueva;
//				int fila = filaNueva;
//				
//				for (int i = 0; i < casillas-1; i++) {
//					
//					if (!(tablero[fila][columna] == null)) {
//						valido = false;
//						break;
//					}
//					fila++;
//					columna++;
//				}
//				
//			} else if (filaActual < filaNueva && columnaActual < columnaNueva) {
//				int columna = columnaNueva;
//				int fila = filaNueva;
//				
//				for (int i = 0; i > casillas-1; i--) {
//					
//					if (!(tablero[fila][columna] == null)) {
//						valido = false;
//						break;
//					}
//					fila++;
//					columna++;
//				}
//				
//			} else if (filaNueva < filaActual && columnaActual < columnaNueva) {
//				int columna = columnaActual;
//				int fila = filaNueva;
//				
//				for (int i = 0; i < casillas-1; i++) {
//					
//					if (!(tablero[fila][columna] == null)) {
//						valido = false;
//						break;
//					}
//					fila++;
//					columna++;
//				}
//			} else if (filaNueva < filaActual && columnaNueva < columnaActual) {
//				int columna = columnaNueva;
//				int fila = filaActual;
//				
//				for (int i = 0; i < casillas-1; i++) {
//					
//					if (!(tablero[fila][columna] == null)) {
//						valido = false;
//						break;
//					}
//					fila++;
//					columna++;
//				}
//			}

		} else {

			valido = false;
		}

		return valido;
	}

	private boolean movimientoRey(int filaActual, int columnaActual, int filaNueva, int columnaNueva,Ficha[][] tablero) {
		boolean valido = false;

		if (((filaNueva == filaActual+1) || (filaNueva == filaActual+1 && columnaNueva == columnaActual+1) 
				|| (columnaNueva == columnaActual+1) || (filaNueva == filaActual-1 && columnaNueva == columnaActual+1)
				|| (filaNueva == filaActual-1) || (filaNueva == filaActual-1 && columnaNueva == columnaActual-1)
				|| (columnaNueva == columnaActual-1) || (filaNueva == filaActual+1 && columnaNueva == columnaActual-1))
				&& (tablero[filaNueva][columnaNueva] == null 
				|| !(tablero[filaNueva][columnaNueva].getColor().equals(tablero[filaActual][columnaActual].getColor())))) {

			valido = true;

		} else {

			valido = false;

		} 

		return valido;
	}

	private boolean movimientoReina(int filaActual, int columnaActual, int filaNueva, int columnaNueva, Ficha[][] tablero) {
		boolean valido = false;

		if (((columnaNueva - columnaActual == filaNueva - filaActual) 
				|| (columnaActual == columnaNueva && (filaNueva <= 7 && filaNueva >= 0 )) 
				|| (filaActual == filaNueva && (columnaNueva <= 7 && columnaNueva >= 0)))
				&& (tablero[filaNueva][columnaNueva] == null 
				|| !(tablero[filaNueva][columnaNueva].getColor().equals(tablero[filaActual][columnaActual].getColor())))) {

			valido = true;

		} else {

			valido = false;

		}

		return valido;
	}
	
	public static boolean comprobarCamino() {
		
		
		
		return true;
	}

	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}



}