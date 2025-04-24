package org.jdk8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class EmployeeSecondsalary {
    public static void main(String[] args) {
	List<Employee1> list = new ArrayList<Employee1>();
	list.add(new Employee1("a", 552));
	list.add(new Employee1("a3", 652));
	list.add(new Employee1("a6", 522));
	list.add(new Employee1("a2", 512));
	list.add(new Employee1("a2", 5111));

	// below code used to remove duplicate name, already override hashcode and
	// equals method
	// List<Employee1> distinctEmployeeList =
	// list.stream().distinct().collect(Collectors.toList());

	Optional<Employee1> ss = list.stream().sorted(Comparator.comparingDouble(Employee1::getSalary).reversed())
		.skip(1).findFirst();

	Optional<Employee1> emp = list.stream().sorted(Comparator.comparingDouble(Employee1::getSalary).reversed())
		.skip(1).findFirst();

	System.out.println("--------- " + emp.get().getSalary());
	// List<Employee1> sortedList =
	list.stream().sorted(Comparator.comparingInt(Employee1::getSalary))
		.forEach((a) -> System.out.println(a.getSalary()));

	// sortedList.forEach((a) ->System.out.println(a.getSalary()));

    }
}

class Employee1 {

    public Employee1(String name, int salary) {
	this.name = name;
	this.salary = salary;
    }

    private String name;
    private int salary;

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public int getSalary() {
	return salary;
    }

    public void setSalary(int salary) {
	this.salary = salary;
    }

    @Override
    public int hashCode() {
	return Objects.hash(name);
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Employee1 other = (Employee1) obj;
	return Objects.equals(name, other.name);
    }

}