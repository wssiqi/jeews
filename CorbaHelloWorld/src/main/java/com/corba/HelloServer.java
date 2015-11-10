package com.corba;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

public class HelloServer {
    public static void main(String[] args) {
        try {
            // Step 1: Instantiate the Hello servant
            HelloImpl helloRef = new HelloImpl();
            // Step 2: Publish the reference in the Naming Service
            // using JNDI API
            Properties environment = new Properties();
            environment.setProperty("java.naming.factory.initial", "com.sun.jndi.cosnaming.CNCtxFactory");
            environment.setProperty("java.naming.provider.url", "iiop://localhost:1050");
            Context initialNamingContext = new InitialContext(environment);
            initialNamingContext.rebind("HelloService", helloRef);

            System.out.println("Hello Server: Ready...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}