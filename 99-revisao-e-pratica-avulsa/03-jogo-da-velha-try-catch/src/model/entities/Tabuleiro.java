package model.entities;

import model.exceptions.JogoException;

public class Tabuleiro {

    private char[][] matriz = new char[3][3];

    public Tabuleiro() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matriz[i][j] = '-';
            }
        }
    }

    public void registrarJogada(int linha, int coluna, char simbolo) {
        if (linha < 0 || linha > 2 || coluna < 0 || coluna > 2) {
            throw new JogoException("Erro: Posição fora dos limites do tabuleiro (use de 0 a 2)!");
        }
        if (matriz[linha][coluna] != '-') {
            throw new JogoException("Erro: Esta posição já está ocupada!");
        }

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