package M3.UF5.NF3.Activitat7;

public class EmptySudokuTester {
    public static void main(String[] args) {

        char sudoku[][] = { {'2','-','-','5','-','9','2','-','7'},
                            {'6','7','-','3','-','-','-','-','4'},
                            {'-','-','-','-','-','2','-','-','-'},
                            {'-','4','9','2','-','-','-','8','5'},
                            {'-','-','-','-','-','-','-','-','-'},
                            {'2','3','-','-','-','4','1','6','-'},
                            {'-','-','-','1','-','-','-','-','-'},
                            {'8','-','-','-','-','5','-','9','1'},
                            {'8','-','4','9','-','7','-','-','6'}};

        int contadorNums = 0;

        boolean sudokuCorrecto = true;

        int x = 8;
        int y = 8;

        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku.length; j++) {

                System.out.print(sudoku[i][j]);

                if (sudoku[i][j] != '-') {
                    contadorNums++;

                }

                if ((sudoku[i][j] != '-' && sudoku[i][j] != '-') || (sudoku[x][y] == '-' && sudoku[x][y] == '-')) {

                } else {
                    sudokuCorrecto = false;

                }
                y--;
            }
            System.out.println();
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
