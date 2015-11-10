package com.corba;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;

public class HelloClient {

    public static void main(String args[]) {
        try {
            Properties environment = new Properties();
            environment.setProperty("java.naming.factory.initial", "com.sun.jndi.cosnaming.CNCtxFactory");
            environment.setProperty("java.naming.provider.url", "iiop://localhost:1050");
            Context initialNamingContext = new InitialContext(environment);

            Object objref = initialNamingContext.lookup("HelloService");
            HelloInterface hi = (HelloInterface) PortableRemoteObject.narrow(objref, HelloInterface.class);
            System.out.println("Client: Obtained a ref. to Hello server.");

            hi.sayHello(" MARS ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}