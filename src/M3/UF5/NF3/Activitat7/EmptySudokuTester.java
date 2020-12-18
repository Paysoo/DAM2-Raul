package M3.UF5.NF3.Activitat7;

import java.util.Scanner;

public class EmptySudokuTester {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int cantidad = teclado.nextInt();

        for (int i = 0; i < cantidad; i++) {
            char sudoku[][] = new char[9][9];
            String valor;
            valor = teclado.next();
            int caracter = 0;

            for (int j = 0; j < sudoku.length; j++) {
                for (int k = 0; k < sudoku.length; k++) {
                    sudoku[j][k] = valor.charAt(caracter);
                    caracter++;
                }
            }

            int contadorNums = 0;

            boolean sudokuCorrecto = true;

            int x = sudoku.length;
            int y = sudoku.length;

            for (int j = 0; j < sudoku.length; j++) {
                for (int k = 0; k < sudoku.length; k++) {

                    // Si hay un numero en la casilla y en su casilla opuesta suma 2 numeros al contador y se mantiene
                    // en correcto
                    if ((sudoku[j][k] != '-' && sudoku[j][k] != '-')) {
                        contadorNums += 2;

                        // Si no hay un numero en la casilla ni en su casilla opuesta se mantiene en correcto
                    } else if ((sudoku[x][y] == '-' && sudoku[x][y] == '-')) {

                        // Si el valor de la casilla y su casilla opuesta son diferentes, marca el sudoku como
                        // incorrecto y termina los bucles for
                    } else {
                        sudokuCorrecto = false;
                        j = sudoku.length;
                        k = sudoku.length;
                    }
                    y--;
                }
                y=8;
                x--;
            }

            if (sudokuCorrecto && contadorNums <33) {
                System.out.println("SI");
            } else {
                System.out.println("NO");
            }
        }
    }
}
// ---5-92-767-3----4-----2----492---85---------23---416----1-----5----8-918-49-7--- (SI)
// ---5-92-767-3----4-----2----492---85---------23---416----------5----8-918-49-7--- (NO)
// 2--5-92-767-3----4-----2----492---85---------23---416----1-----8----5-918-49-7--6 (SI)
// -----92-767-3----4-----2----499---85-3-----2-28---416----4-----5----8-918-49----- (SI)
// 1-------2---------------------------------------------------------------3-------4 (SI)
// 123456789234567891345678912456789123567891234678912345789123456891234567987654321 (NO)