package com.banco.model;

import java.util.ArrayList;
import java.util.List;

public class ContaBancaria {
    private String numero;
    private String titular;
    private double saldo;
    private List<String> historicoTransacoes;

    public ContaBancaria(String numero, String titular, double saldoInicial) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldoInicial;
        this.historicoTransacoes = new ArrayList<>();
        registrarTransacao("Conta criada com saldo inicial de: R$ " + saldoInicial);
    }

    public String getNumero() {
        return numero;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public List<String> getHistoricoTransacoes() {
        return historicoTransacoes;
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor do depósito deve ser positivo.");
        }
        this.saldo += valor;
        registrarTransacao("Depósito recebido: R$ " + valor);
    }

    public void sacar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor do saque deve ser positivo.");
        }
        if (valor > this.saldo) {
            throw new com.banco.exception.SaldoInsuficienteException("Saldo insuficiente para realizar a operação.");
        }
        this.saldo -= valor;
        registrarTransacao("Saque realizado: R$ " + valor);
    }

    public void registrarTransacao(String mensagem) {
        this.historicoTransacoes.add(mensagem);
    }
}