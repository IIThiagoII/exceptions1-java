package model.entities;

import model.exceptions.JogoException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Jogo {
    private Scanner ler = new Scanner(System.in);
    private Tabuleiro tabuleiro = new Tabuleiro();
    private Jogador jogador1, jogador2, jogadorAtual;
    private boolean jogoEmAndamento = true;

    public Jogo() {
        jogador1 = new Jogador("Jogador 1", 'X');
        jogador2 = new Jogador("Jogador 2", 'O');
        jogadorAtual = jogador1;

        tabuleiro.imprimeTabuleiro();
        System.out.println();

        while (jogoEmAndamento) {
            try {
                System.out.println("Vez do " + jogadorAtual.getNome() + " (" + jogadorAtual.getSimbolo() + ")");
                System.out.println("Digite a linha e coluna [0-2]:");
                int linha = ler.nextInt();
                int coluna = ler.nextInt();

                tabuleiro.registrarJogada(linha, coluna, jogadorAtual.getSimbolo());

                tabuleiro.imprimeTabuleiro();
                System.out.println();

                if (verificarVitoria(jogadorAtual.getSimbolo())) {
                    System.out.println("Parabéns! " + jogadorAtual.getNome() + " venceu!");
                    jogoEmAndamento = false;
                }
                else if (empate()) {
                    System.out.println("Empate! O tabuleiro está cheio.");
                    jogoEmAndamento = false;
                }
                else {
                    jogadorAtual = (jogadorAtual == jogador1) ? jogador2 : jogador1;
                }

            }
            catch (JogoException e) {
                System.out.println(e.getMessage());
                System.out.println("Tente novamente!\n");
            }
            catch (InputMismatchException e) {
                System.out.println("Erro: Você deve digitar apenas números inteiros!");
                ler.nextLine();
                System.out.println("Tente novamente!\n");
            }
        }
        ler.close();
    }

    private boolean verificarVitoria(char simbolo) {
        char[][] m = tabuleiro.getMatriz();
        for (int i = 0; i < 3; i++) {
            if (m[i][0] == simbolo && m[i][1] == simbolo && m[i][2] == simbolo) return true;
            if (m[0][i] == simbolo && m[1][i] == simbolo && m[2][i] == simbolo) return true;
        }
        if (m[0][0] == simbolo && m[1][1] == simbolo && m[2][2] == simbolo) return true;
        if (m[0][2] == simbolo && m[1][1] == simbolo && m[2][0] == simbolo) return true;
        return false;
    }

    private boolean empate() {
        char[][] m = tabuleiro.getMatriz();
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j] == '-') return false;
            }
        }
        return true;
    }
}