package co.edu.uniquindio.sudoku;

public class Principal {
    public static void main(String[] args) {

        int[][] tablero = {
                {3,0,0,0,0,1,0,0,0},
                {0,6,8,0,0,0,5,4,0},
                {0,0,0,0,5,0,0,3,6},
                {0,0,0,0,6,0,4,0,0},
                {0,3,1,0,0,5,0,0,2},
                {6,0,7,0,8,2,0,0,0},
                {5,0,6,3,9,0,1,2,4},
                {0,0,0,7,1,0,8,0,0},
                {8,1,9,5,2,0,0,6,7},
        };
        Sudoku misudoku = new Sudoku(tablero);
        misudoku.resolverSudoku();
        misudoku.imprimirSudoku();
    }
}