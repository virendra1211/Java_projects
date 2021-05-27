package org.jdk8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
		le.add(new Employee(300)); le.add(new Employee(783));le.add(new Employee(349));le.add(new Employee(366));
		le.add(new Employee(420));

			System.out.println(" ======================================== ");
		le.stream().filter(s ->s.getSalary() >350).forEach(System.out::println);
	}
}
class Employee {
	int salary;

	public Employee(int i) {
		salary =i;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	  @Override
	    public String toString() {
	 
	        return " | salary: "+this.salary;
	    }
}