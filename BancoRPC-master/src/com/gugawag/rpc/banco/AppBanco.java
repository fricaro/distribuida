package com.gugawag.rpc.banco;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class AppBanco {

    public static void main(String[] args) throws RemoteException {

        // Cria uma instância do serviço com.gugawag.rpc.banco.BancoServiceServer...
        BancoServiceIF bancoService = new BancoServiceServer();
        INomeCompleto nomeCompleto = new NomeCompletoServer();

        // instanciando o registro
        Registry registry = LocateRegistry.createRegistry(1099);

        // liga (bind) o serviço ao RMI Registry
        registry.rebind("BancoService", bancoService);
        registry.rebind("nomeCompleto", nomeCompleto);

        System.out.println("Service de banco registrado ....");
    }
}
