package com.corba;

import javax.rmi.PortableRemoteObject;

public class HelloImpl extends PortableRemoteObject implements HelloInterface {
	public HelloImpl() throws java.rmi.RemoteException {
		super(); // invoke rmi linking and remote object initialization
	}

	public void sayHello(String guestName) throws java.rmi.RemoteException {
		System.out.println("Hello, " + guestName + "!");
	}
}