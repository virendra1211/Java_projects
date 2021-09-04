package org.serializable;
import java.io.File;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/*
	if static is defined in the pojo then updated value get retrieved in the serializatin process
 
 */
public class ClientTest {

	public static void main(String[] args) {

		String fileName = "employee.ser";
		serializeObject(fileName);
		deserializeObject(fileName);
		// -- if serialVersionUID specified and changed the value it's working but when it was not present and 
		// pojo has been modified then will face InvalidClassException
		
		
	}

	private static void deserializeObject(String fileName) {
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(fileName)))) {
			Object object = ois.readObject();
			Employee employee=(Employee)object;
			System.out.println("Employee Object is deserialized..");
			System.out.println("ID:"+employee.getId());
			System.out.println("Name:"+employee.getName());
			System.out.println("Email:"+employee.getEmail());
			System.out.println("myid:"+employee.getMyid());
			System.out.println("stu:"+employee.getStu().getDept());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void serializeObject(String fileName) {
		Employee employee = new Employee();
		employee.setId(1001);
		employee.setName("KK");
		employee.setEmail("kishan.javatrainer@gmail.com");
		Student st = new Student("a","b",22);
	// java.io.WriteAbortedException: and NoSerializableException happened
		employee.setStu(st);
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(fileName)))) {
			oos.writeObject(employee);
			System.out.println("Employee Object is serialized..");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}