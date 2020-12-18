package M3.UF5.NF3.Activitat7;

import java.util.Scanner;

public class EmptySudokuTester {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int cantidad = teclado.nextInt();

        for (int i = 0; i < cantidad; i++) {
            char[][] sudoku = new char[9][9];
            for (int j = 0; j < sudoku.length; j++) {
                String valor;
                teclado.nextLine();
                valor = teclado.next();

                int caracter = 0;

                for (int k = 0; k < sudoku.length; k++) {
                    sudoku[j][k] = valor.charAt(caracter);
                    caracter++;
                }
            }

            System.out.println();

            int contadorNums = 0;

            boolean sudokuCorrecto = true;

            int x = 8;
            int y = 8;

            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < sudoku.length; k++) {

                    if ((sudoku[j][k] != '-' && sudoku[x][y] != '-')) {
                        contadorNums = contadorNums + 2;
                    } else if ((sudoku[x][y] == '-' && sudoku[j][k] == '-')) {

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
                System.out.println("SI\n");
            } else {
                System.out.println("NO\n");
            }
        }
        teclado.close();
    }
}
/** ---5-92-7
    67-3----4
    -----2---
    -492---85
     ---------
     23---416-
     ---1-----
     5----8-91
     8-49-7---
        SI

     ---5-92-7
     67-3----4
     -----2---
     -492---85
     ---------
     23---416-
     ---------
     5----8-91
     8-49-7---
        NO **/
