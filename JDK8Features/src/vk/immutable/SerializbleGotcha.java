package vk.immutable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializbleGotcha {

	public static void main(String[] args) {
		String filename = "person.ser";

		Child parent = new Child();
		// Serialization
		try (FileOutputStream fileOut = new FileOutputStream(filename);
				ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
			out.writeObject(parent);
			System.out.println("Serialized data is saved in person.ser");
		} catch (IOException i) {
			i.printStackTrace();
		}

		// Deserialization
		try (FileInputStream fileIn = new FileInputStream(filename);
				ObjectInputStream in = new ObjectInputStream(fileIn)) {
			Child deserializedPerson = (Child) in.readObject();
			System.out.println(
					"Deserialized Person: " + deserializedPerson.x + " = " + deserializedPerson.y);
		} catch (IOException | ClassNotFoundException i) {
			i.printStackTrace();
		}
	}

}

class Parent {
	int x = 5;

	Parent() {
	}
}

class Child extends Parent implements Serializable {
	transient int y = 10;

	Child() {
	}
}