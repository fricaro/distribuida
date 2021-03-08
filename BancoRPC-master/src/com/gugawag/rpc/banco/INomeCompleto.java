package com.gugawag.rpc.banco;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface INomeCompleto extends Remote {

    String getNomeCompleto() throws RemoteException;
}
