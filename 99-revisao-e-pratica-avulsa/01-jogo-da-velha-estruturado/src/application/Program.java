package application;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] tabuleiro = new char[3][3];

        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                tabuleiro[i][j] = '-';
            }
        }
        imprimirTabuleiro(tabuleiro);
        System.out.println();


        boolean continuar = true;
        char jogadorAtual = 'X';


        while (continuar) {

            System.out.println("Jogador " + jogadorAtual + ", digite a linha e coluna [0-2]: ");

            int linha = sc.nextInt();
            int coluna = sc.nextInt();

            if (linha < 0 || linha > 2 || coluna < 0 || coluna > 2 || tabuleiro[linha][coluna] != '-') {
                System.out.println("Posição inválida. Tente novamente.");
                continue;
            } else {
                tabuleiro[linha][coluna] = jogadorAtual;
                imprimirTabuleiro(tabuleiro);
                System.out.println();
            }
            if (checarVencedor(tabuleiro, jogadorAtual)) {
                System.out.println("Jogador " + jogadorAtual + " venceu!");
                continuar = false;
            } else if (empate(tabuleiro)) {
                System.out.println("Empate!");
                continuar = false;
            } else {

                jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X';
            }
        }
    }

    public static void imprimirTabuleiro(char[][] tabuleiro) {
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                System.out.print(tabuleiro[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean checarVencedor(char[][] tabuleiro, char jogadorAtual) {

        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i][0] == jogadorAtual && tabuleiro[i][1] == jogadorAtual && tabuleiro[i][2] == jogadorAtual) {
                return true;
            }
        }

        for (int j = 0; j < 3; j++) {
            if (tabuleiro[0][j] == jogadorAtual && tabuleiro[1][j] == jogadorAtual && tabuleiro[2][j] == jogadorAtual) {
                return true;
            }
        }

        if (tabuleiro[0][0] == jogadorAtual && tabuleiro[1][1] == jogadorAtual && tabuleiro[2][2] == jogadorAtual) {
            return true;
        }
        if (tabuleiro[0][2] == jogadorAtual && tabuleiro[1][1] == jogadorAtual && tabuleiro[2][0] == jogadorAtual) {
            return true;
        }

        return false;
    }

    public static boolean empate(char[][] tabuleiro) {
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                if (tabuleiro[i][j] == '-') {
                    return false;
                }
            }

        }
        return true;
    }

}
