package com.gugawag.rpc.banco;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class AppClienteBanco {

    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1099);
        BancoServiceIF banco = (BancoServiceIF) registry.lookup("BancoService");
        INomeCompleto nomeCompleto = (INomeCompleto) registry.lookup("nomeCompleto");

        System.out.println(nomeCompleto.getNomeCompleto());
        menu();
        Scanner entrada = new Scanner(System.in);
        int opcao = entrada.nextInt();

        while(opcao != 9) {
            switch (opcao) {
                case 1: {
                    System.out.println("Digite o número da conta:");
                    String conta = entrada.next();
                    //chamada ao método remoto, como se fosse executar localmente
                    System.out.println(banco.saldo(conta));
                    break;
                }
                case 2: {
                    //chamada ao método remoto, como se fosse executar localmente
                    System.out.println(banco.quantidadeContas());
                    break;
                }
                case 3: {
                    System.out.println("Digite o nome da nova conta:");
                    String nome = entrada.next();
                    System.out.println("Digite o saldo inicial da nova conta:");
                    double saldoInicial = entrada.nextDouble();
                    banco.cadastrarNovaConta(nome, saldoInicial);
                    System.out.println("Conta cadastrada com sucesso");
                    break;
                }
            }
            menu();
            opcao = entrada.nextInt();
        }
    }

    public static void menu() {
        System.out.println("\n=== BANCO RMI (ou FMI?!) ===");
        System.out.println("1 - Saldo da conta");
        System.out.println("2 - Quantidade de contas");
        System.out.println("2 - Criar conta");
        System.out.println("9 - Sair");
    }

}
