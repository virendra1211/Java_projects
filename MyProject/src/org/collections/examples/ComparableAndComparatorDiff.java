package org.collections.examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparableAndComparatorDiff {
    public static void main(String[] args) {
	List<Employee> listOfEmployee = new ArrayList<Employee>();
	listOfEmployee.add(new Employee(10, "abcg"));
	listOfEmployee.add(new Employee(8, "abca"));
	listOfEmployee.add(new Employee(7, "abce"));
	listOfEmployee.add(new Employee(12, "abcs"));

	// Collections.sort(listOfEmployee);
	listOfEmployee.forEach((a) -> System.out.println(a.getId() + " " + a.getName()));
	System.out.println("=============");
	Collections.sort(listOfEmployee, new MyEmp());

	listOfEmployee.forEach((a) -> System.out.println(a.getId() + " " + a.getName()));

    }

}

class MyEmp implements Comparator<Employee> {

    @Override
    public int compare(Employee s1, Employee s2) {
	if (s1.getId() == s2.getId())
	    return 0;
	else if (s1.getId() > s2.getId())
	    return 1;
	else
	    return -1;
    }

}

class Employee implements Comparable<Employee> {
    private Integer id;
    private String name;

    public Employee(Integer id, String name) {
	super();
	this.id = id;
	this.name = name;
    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    @Override
    public int compareTo(Employee o) {

	return this.id.compareTo(o.getId());
    }

}
