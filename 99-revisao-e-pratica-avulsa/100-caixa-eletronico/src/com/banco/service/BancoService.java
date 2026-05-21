package com.banco.service;

import com.banco.model.ContaBancaria;
import com.banco.exception.ContaNaoEncontradaException;
import java.util.HashMap;
import java.util.Map;

public class BancoService {

    private Map<String, ContaBancaria> contasDB = new HashMap<>();

    public void cadastrarConta(ContaBancaria conta) {
        contasDB.put(conta.getNumero(), conta);
    }

    public ContaBancaria buscarConta(String numero) {
        ContaBancaria conta = contasDB.get(numero);
        if (conta == null) {
            throw new ContaNaoEncontradaException("A conta número " + numero + " não foi encontrada.");
        }
        return conta;
    }

    public void realizarTransferencia(String numeroOrigem, String numeroDestino, double valor) {
        ContaBancaria origem = buscarConta(numeroOrigem);
        ContaBancaria destino = buscarConta(numeroDestino);

        origem.sacar(valor);
        destino.depositar(valor);

        origem.registrarTransacao("Transferência enviada para " + destino.getTitular() + ": R$ " + valor);
        destino.registrarTransacao("Transferência recebida de " + origem.getTitular() + ": R$ " + valor);
    }
}