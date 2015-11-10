package com.corba;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface HelloInterface extends Remote {
    public void sayHello(String guest) throws RemoteException;
}
