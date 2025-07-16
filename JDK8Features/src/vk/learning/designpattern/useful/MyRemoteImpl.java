package vk.learning.designpattern.useful;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {
	public MyRemoteImpl() throws RemoteException {
		super();
	}

	public void sayHello() throws RemoteException {
		System.out.println("Hello from the remote object!");
	}
}
// Client Code
