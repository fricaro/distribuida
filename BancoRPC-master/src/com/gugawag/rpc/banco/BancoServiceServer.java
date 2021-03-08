package com.gugawag.rpc.banco;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BancoServiceServer extends UnicastRemoteObject implements BancoServiceIF {

    private List<Conta> contas = new ArrayList();

    public BancoServiceServer() throws RemoteException {
        contas.add(new Conta("Francisco", 100.0));
        contas.add(new Conta("Joao", 200.0));
        contas.add(new Conta("Pedro", 400.0));
        contas.add(new Conta("Clara", 700.0));
        contas.add(new Conta("Maria", 650.0));
    }

    @Override
    public double saldo(String nomeConta) throws RemoteException {
        Conta conta = contas.stream().filter(c -> c.getNome() == nomeConta).findFirst().orElseThrow();
        return conta.getSaldo();
    }

    @Override
    public int quantidadeContas() throws RemoteException {
        return contas.size();
    }

    @Override
    public void cadastrarNovaConta(String nomeDaConta, double valorInicial) throws RemoteException {
        Conta conta = new Conta(nomeDaConta, valorInicial);
        contas.add(conta);
    }
}
