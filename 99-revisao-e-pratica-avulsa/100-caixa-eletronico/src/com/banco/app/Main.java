package com.banco.app;

import com.banco.model.ContaBancaria;
import com.banco.service.BancoService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BancoService banco = new BancoService();

        banco.cadastrarConta(new ContaBancaria("111", "Thiago Backend", 1000.0));
        banco.cadastrarConta (new ContaBancaria("222", "Manoel Gomes", 500.0));

        System.out.println("=== BEM-VINDO AO TERMINAL ATM JAVA ===");

        ContaBancaria contaAtiva = null;
        String numeroLogado = "";

        while (contaAtiva == null) {
            System.out.print("Digite o número da sua conta para acessar: ");
            numeroLogado = scanner.nextLine().trim();

            try {
                contaAtiva = banco.buscarConta(numeroLogado);
                System.out.println("✅ Login realizado com sucesso!");
            } catch (RuntimeException e) {
                System.out.println("\n❌ FALHA NO LOGIN: " + e.getMessage() + " Tente novamente.\n");
            }
        }

        boolean rodando = true;
        while (rodando) {
            System.out.println("\n-------------------------------------");
            System.out.println("Cliente: " + contaAtiva.getTitular() + " | Saldo Atual: R$ " + contaAtiva.getSaldo());
            System.out.println("1. Sacar");
            System.out.println("2. Depositar");
            System.out.println("3. Transferir");
            System.out.println("4. Ver Extrato");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            String entradaOpcao = scanner.nextLine().trim();

            if (entradaOpcao.isEmpty()) {
                continue;
            }

            try {
                int opcao = Integer.parseInt(entradaOpcao);

                switch (opcao) {
                    case 1:
                        System.out.print("Valor do saque: R$ ");
                        double valorSaque = Double.parseDouble(scanner.nextLine());
                        contaAtiva.sacar(valorSaque);
                        System.out.println("✅ Saque realizado com sucesso!");
                        break;

                    case 2:
                        System.out.print("Valor do depósito: R$ ");
                        double valorDeposito = Double.parseDouble(scanner.nextLine());
                        contaAtiva.depositar(valorDeposito);
                        System.out.println("✅ Depósito realizado com sucesso!");
                        break;

                    case 3:
                        System.out.print("Digite o número da conta de destino: ");
                        String destino = scanner.nextLine().trim();

                        System.out.print("Valor da transferência: R$ ");
                        double valorTransf = Double.parseDouble(scanner.nextLine());

                        banco.realizarTransferencia(numeroLogado, destino, valorTransf);
                        System.out.println("✅ Transferência concluída com sucesso!");
                        break;

                    case 4:
                        System.out.println("\n=== EXTRATO BANCÁRIO ===");
                        for (String transacao : contaAtiva.getHistoricoTransacoes()) {
                            System.out.println("- " + transacao);
                        }
                        break;

                    case 5:
                        rodando = false;
                        System.out.println("Obrigado por utilizar o nosso sistema bancário!");
                        break;

                    default:
                        System.out.println("⚠️ Opção inválida. Tente novamente.");
                }

            } catch (NumberFormatException e) {
                System.out.println("\n⚠️ Erro: Digite apenas números válidos.");
            } catch (RuntimeException e) {
                String msgErro = (e.getMessage() != null) ? e.getMessage() : e.toString();
                System.out.println("\n❌ OPERAÇÃO NEGADA: " + msgErro);
            }
        }

        scanner.close();
    }
}