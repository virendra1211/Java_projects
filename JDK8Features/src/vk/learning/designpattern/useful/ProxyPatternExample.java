package vk.learning.designpattern.useful;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

interface MyRemote1 extends Remote {
	void sayHello() throws RemoteException;
}

class MyRemoteImpl extends UnicastRemoteObject implements MyRemote1 {
	public MyRemoteImpl() throws RemoteException {
		super();
	}

	public void sayHello() throws RemoteException {
		System.out.println("Hello from the remote object!");
	}
}

// Client Code
public class ProxyPatternExample {
	public static void main(String[] args) {
		try {
			MyRemote remote = (MyRemote) Naming.lookup("//localhost/RemoteHello");
			remote.sayHello(); // Proxy forwards the request to the real remote object
		} catch (Exception e) {
		}
	}
}
