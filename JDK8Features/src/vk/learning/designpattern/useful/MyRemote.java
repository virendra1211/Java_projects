package vk.learning.designpattern.useful;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MyRemote extends Remote {
	void sayHello() throws RemoteException;
}
