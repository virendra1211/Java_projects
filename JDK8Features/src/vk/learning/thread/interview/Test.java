package vk.learning.thread.interview;

import java.util.HashSet;
import java.util.Set;

class MyDto {
	int id;
	String dtoName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDtoName() {
		return dtoName;
	}

	public void setDtoName(String dtoName) {
		this.dtoName = dtoName;
	}

	public MyDto(int id, String dtoName) {
		super();
		this.id = id;
		this.dtoName = dtoName;
	}

}

public class Test {

	public static void main(String[] args) {
		Set<MyDto> set = new HashSet<>();
		MyDto obj = new MyDto(44, "John");
		MyDto obj1 = new MyDto(45, "John1");
		// hash set
		set.add(obj);
		set.add(obj1);
		obj.id = 45;
		obj.dtoName = "John1";
		System.out.println(set.size());
	}
}