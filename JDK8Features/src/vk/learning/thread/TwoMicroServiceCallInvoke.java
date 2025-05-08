package vk.learning.thread;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class TwoMicroServiceCallInvoke {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newFixedThreadPool(2);

		Set<Callable<Employee>> set = new HashSet<>();
		set.add(() -> {
			TimeUnit.MILLISECONDS.sleep(100);
			return callMicroserviceA();
		});
		set.add(() -> {
			TimeUnit.MILLISECONDS.sleep(100);
			return callMicroserviceB();
		});

		List<Future<Employee>> e = executorService.invokeAll(set);
		for (Future<Employee> f : e) {
			System.out.println(f.get());
		}

		executorService.shutdown();

	}

	private static Employee callMicroserviceB() {
		// TODO Auto-generated method stub
		return new Employee("Veer", "Banglore");
	}

	private static Employee callMicroserviceA() {

		return new Employee("virendra", "pune");
	}
}

class Employee {
	private String name;

	public Employee(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}

	private String address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", address=" + address + "]";
	}

}
