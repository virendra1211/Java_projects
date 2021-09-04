package org.serializable;
import java.io.Serializable;
  
public  class Student  implements Serializable{
	
    public String name = null;
    public String dept = null;
    public int id = 0;
    public String ss;
	public Student(String name, String dept, int id) {
		super();
		this.name = name;
		this.dept = dept;
		this.id = id;
	}
	 Student(){
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
    
}