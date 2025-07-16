package vk.learning.designpattern.useful;

// It provide an object representation of another object.
/* Proxy control  access to the real object and can add additoinal functionality like lazy
initializatoin, access control, logging, or monitoring. It acts as an intermediatary between
the client and the real object 
client ->   proxy      -> real object
VPRC: virtual, protected, remote and cache
 Types of Proxy Patterns:
 1. Virtual Proxy: Used to delay the creation of an expensive object until it's needed. *****
 2. Protection Proxy: Controls access to the real object based on permissions or security checks.
 3. Remote Proxy: Used when an object resides in a different address space (e.g., in a different
 machine or server).
 4. Cache Proxy: Caches the result of expensive computations or remote calls to avoid
 recomputation or re-fetching

*/
class RealImage {
	private String fileName;

	public RealImage(String fileName) {
		this.fileName = fileName;
		loadImageFromDisk(); // simulating the expensive operation of loadind an image
	}

	public void loadImageFromDisk() {
		System.out.println("Loading Image:" + fileName);
	}

	public void display() {
		System.out.println("Display Image:" + fileName);
	}

}

class ImageProxy {
	private RealImage realImage;
	private String fileName;

	public ImageProxy(String fileName) {
		this.fileName = fileName;
	}

	public void display() {
		if (realImage == null) {
			realImage = new RealImage(fileName);
		}
		realImage.display();
	}

}

public class ProxyPatternVirtual {
	public static void main(String[] args) {
		ImageProxy image1 = new ImageProxy("image1.jpg");
		image1.display(); // Image will be loaded and displayed
		image1.display(); // Image will not be loaded again, it will just be displayed
	}
}