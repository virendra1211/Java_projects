package org.jdk8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
//* test
*/

public class JKD8Feature {
	public static void main(String[] args) {
/*
		List<String> names = Arrays.asList("Reflection", "Collection", "Stream");
		List<String> result = names.stream().filter(s -> s.startsWith("S")).collect(Collectors.toList());
		
		result.forEach(x -> System.out.println(x) );
		
		List<String> list = Arrays.asList("ac", "ba", "ab","ca","cd","cc");
			
		List<String> l = list.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
		l.forEach(x -> System.out.println(x) );
	*/
		List<Employee> le = new ArrayList<Employee>();
		le.add(new Employee(300,"abc")); le.add(new Employee(783,"bca"));le.add(new Employee(349,"bca"));le.add(new Employee(366,"bca"));
		le.add(new Employee(420,"tba"));

		System.out.println(" ======================================== ");
		le.stream().filter(s ->s.getSalary() >350).forEach(System.out::println);
		
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("A3", 9);
		map.put("A5", 4);
		map.put("A8", 5);
		map.put("A2", 6);
		map.put("A9", 8);
		map.put("A1", 7);
		
		Map<String,Integer> result = map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(oldvalue,newvalue) -> oldvalue,
						LinkedHashMap::new));
	
		
		result.forEach((k,v) -> System.out.println("Key = "+ k + ", Value = " + v));
	
	}
}
class Employee {
	int salary;
	String name;
	String lname;
	int id;
	
	public Employee(int id, String name, String lname) {
		this.name = name;
		this.lname = lname;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Employee(int i,String name) {
		this.salary =i;
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	  @Override
	    public String toString() {
	 
	        return this.id +" | "+this.name+" | "+this.lname;
	    }
}