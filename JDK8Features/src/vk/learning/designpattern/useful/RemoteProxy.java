package vk.learning.designpattern.useful;

public class RemoteProxy {
	public static void main(String[] args) {
		RemoteProxy1 remoteProxy = new RemoteProxy1("192.168.0.1");
		remoteProxy.request(); // Request is forwarded to the real object through the proxy
	}
}

class RealSubject {
	public void request() {
		System.out.println("Request received and processed by the real subject.");
	}
}

//Proxy Class
class RemoteProxy1 {
	private RealSubject realSubject;
	private String serverAddress;

	public RemoteProxy1(String serverAddress) {
		this.serverAddress = serverAddress;
	}

	public void request() {
		if (realSubject == null) {
			System.out.println("Connecting to the remote server at: " + serverAddress);
			realSubject = new RealSubject(); // Simulate remote object connection
		}
		realSubject.request(); // Forward the request to the real object
	}
}
/*
 * RealSubject simulates the actual remote object that can process requests. •
 * RemoteProxy acts as a proxy for RealSubject and handles the interaction with
 * the real object, such as connecting to a remote server
 */