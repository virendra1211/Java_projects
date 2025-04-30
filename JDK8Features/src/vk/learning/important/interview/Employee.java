package vk.learning.important.interview;

public class Employee {
	@Override
	public boolean equals(Object obj) {
		Employee ob = (Employee) obj;
		return this.id.equals(ob.getId()) && this.empName.equals(ob.getEmpName());
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	private Integer id;
	private String empName;

	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", empName=" + empName + "]";
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Employee(Integer id, String empName) {
		super();
		this.id = id;
		this.empName = empName;
	}

}
