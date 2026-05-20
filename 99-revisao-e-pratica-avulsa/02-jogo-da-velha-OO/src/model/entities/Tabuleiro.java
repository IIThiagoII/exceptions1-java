package model.entities;

public class Tabuleiro {

    private char[][] matriz = new char[3][3];

    public Tabuleiro() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matriz[i][j] = '-';
            }
        }
    }
    public boolean posicaoValida(int linha, int coluna) {
        if (linha < 0 || linha > 2 || coluna < 0 || coluna > 2) {
            return false;
        }
        return matriz[linha][coluna] == '-';
    }
    public void registrarJogada(int linha, int coluna, char simbolo) {
        matriz[linha][coluna] = simbolo;
    }
    public char[][] getMatriz() {
        return matriz;
    }
    public void imprimeTabuleiro() {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}