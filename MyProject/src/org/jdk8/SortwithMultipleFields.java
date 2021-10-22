package org.jdk8;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
 
public class SortwithMultipleFields 
{
    public static void main(String[] args) 
    {
    	 //first name comparator
    	 Comparator<Employee> compareByFirstName = Comparator.comparing( Employee::getName );
    	  
    	 //last name comparator
    	 Comparator<Employee> compareByLastName = Comparator.comparing( Employee::getLname );
    	  
    	 //Compare by first name and then last name (multiple fields)
    	 Comparator<Employee> compareByFullName = compareByFirstName.thenComparing(compareByLastName);
    	  
    	 //Using Comparator - pseudo code
    	 //list.stream().sorted( compareByFullName).collect();
    	 
        ArrayList<Employee> employees = getUnsortedEmployeeList();
         
        //Compare by first name and then last name
        Comparator<Employee> compareByName = Comparator
                                                .comparing(Employee::getName)
                                                .thenComparing(Employee::getLname);
         
        List<Employee> sortedEmployees = employees.stream()
                                        .sorted(compareByName)
                                        .collect(Collectors.toList());
         
        sortedEmployees.forEach(p -> System.out.println(p.getName() +" "+p.getLname()));
    }
 
    private static ArrayList<Employee> getUnsortedEmployeeList() 
    {
        ArrayList<Employee> list = new ArrayList<>();
        list.add( new Employee(21, "Lokesh", "Gupta") );
        list.add( new Employee(13, "Alex", "Gussin") );
        list.add( new Employee(44, "Brian", "Sux") );
        list.add( new Employee(55, "Neon", "Piper") );
        list.add( new Employee(36, "David", "Beckham") );
        list.add( new Employee(77, "Alex", "Beckham") );
        list.add( new Employee(62, "Brian", "Suxena") );
        return list;
    }
}