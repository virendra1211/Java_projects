package org.serializable;
import java.io.Serializable;
import java.util.Objects;

public class Employee implements Serializable,Comparable<Employee> {

	private static final long serialVersionUID = -179812851346930637L;
	private int id;
	private String name;
	private String email;
	private Double salary;
	private double ids;
	private static int myid=5001;
	private String lname;
	public double getIds() {
		return ids;
	}
	public void setIds(double ids) {
		this.ids = ids;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	/*
		if student is not serialized then will get java.io.NotSerializableException: while deserializing or serializing the object
	 */
	/// private  transient Student stu = new Student(); ** even when deserialize will get null
	private   Student stu = new Student();
	public Student getStu() {
		return stu;
	}
	public void setStu(Student stu) {
		this.stu = stu;
	}
	public static int getMyid() {
		return myid;
	}
	public static void setMyid(int myid) {
		Employee.myid = myid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Employee(int id, String name, String email, Double salary, double ids, Student stu) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.salary = salary;
		this.ids = ids;
		this.stu = stu;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, lname);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return id == other.id && Objects.equals(lname, other.lname);
	}
	public Employee(int id,String name, String lname) {
		this.id = id;
		this.name = name;
		this.lname = lname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	Employee(){
		
	}
	@Override
	public int compareTo(Employee o) {
		if(id > o.getId()) {
			return 1;
		}else if(id < o.getId()){
			return -1;
		}else {
			return 0; 
		}
	}
}