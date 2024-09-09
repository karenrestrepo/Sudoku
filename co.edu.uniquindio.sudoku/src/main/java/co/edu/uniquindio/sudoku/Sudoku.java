package co.edu.uniquindio.sudoku;

public class Sudoku {
    
    private int[][] tablero;
    private static final int SIN_ASIGNAR = 0;
    
    public Sudoku(){
        tablero = new int[9][9];
    }
    
    public Sudoku(int sudoku[][]){
        this.tablero = sudoku;
    }
    
    public boolean resolverSudoku(){
        for (int fila = 0; fila < 9; fila++){
            for (int columna = 0; columna < 9; columna++){
                if (tablero[fila][columna] == SIN_ASIGNAR) {
                    for (int numero = 1; numero <= 9; numero++){
                        if (esValido(fila, columna, numero)) {
                            tablero[fila][columna] = numero;
                            if(resolverSudoku()){
                                return true;
                            } else{
                                tablero[fila][columna] = SIN_ASIGNAR;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean esValido(int fila, int columna, int numero) {
        return !(contieneFila(fila, numero) || contieneColumna(columna, numero) || contieneCaja(fila, columna, numero));
    }

    private boolean contieneFila(int fila, int numero) {
        for (int i = 0; i < 9; i++){
            if (tablero[fila][i] == numero){
                return true;
            }
        }
        return false;
    }

    private boolean contieneColumna(int columna, int numero) {
        for (int i = 0; i < 9; i++){
            if (tablero[i][columna] == numero){
                return true;
            }
        }
        return false;
    }

    private boolean contieneCaja(int fila, int columna, int numero) {
        int f = fila - fila % 3;
        int c = columna - columna % 3;
        for (int i = f; i < f+3; i++){
            for (int j = c; j < c+3; j++){
                if (tablero[i][j] == numero){
                    return true;
                }
            }
        }
        return false;
    }

    public void imprimirSudoku() {
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println("--------------------------------------");
            }
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0 && j != 0) {
                    System.out.print(" | ");
                }
                System.out.print(" " + tablero[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
