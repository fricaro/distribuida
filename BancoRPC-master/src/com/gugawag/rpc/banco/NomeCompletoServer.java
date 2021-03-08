package com.gugawag.rpc.banco;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class NomeCompletoServer extends UnicastRemoteObject implements INomeCompleto {
    protected NomeCompletoServer() throws RemoteException {
    }

    @Override
    public String getNomeCompleto() throws RemoteException {
        return "Francisco Ícaro Cipriano Silva";
    }
}
