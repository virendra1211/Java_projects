package vk.learning.verion.feature;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Java9Feature implements I {

	public static void main(String[] args) throws FileNotFoundException {

		I in = new Java9Feature();
		in.div(8, 2);
		in.add(3, 1);
		var p = new ArrayList<Integer>();

		// II try-with-resource
		try (PrintWriter writer = new PrintWriter(new File("text.txt"))) {
			writer.println();
		}
		// III Jshell, developer run the script interactively
		/// IV HTTP/2 client -> offerng a more efficient and modern way to perform HTTP
		// communication.
		// V Introduced Factory Methods like List.of, Map.of
	}

	public void div(int a, int b) {
		// TODO Auto-generated method stub

	}

}

//static, default and abstract methods in interfaces 
interface I {
	public abstract void div(int a, int b);

	/*
	 * private methods will improve code re-usability inside interfaces and will
	 * provide choice to expose only our intended methods implementations to users.
	 */
	// I define private method in interface
	private void sub(int a, int b) {
		System.out.print("Answer by Private method = ");
		System.out.println(a - b);
	}

	public default void add(int a, int b) {
		// private method inside default method
		sub(a, b);
		// static method inside other non-static method
		div(a, b);
		System.out.print("Answer by Default method = ");
		System.out.println(a + b);
	}

}
