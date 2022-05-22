package vk.learning.basics;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LamdaExample {
	public static void main(String[] args) {
		
		List<Integer> list = List.of(70000,99882,88001,99522,70000,20000);
		// max salary
		Integer longMax = list.stream().max(Integer::compare).get();
		System.out.println(longMax);
		
		// max salary
		Integer minSalary = list.stream().min(Integer::compare).get();
		System.out.println(minSalary);
		
		// average salary
		double averageSalary = list.stream().mapToInt(Integer::intValue).average().orElse(Double.NaN);

		System.out.println(averageSalary);
		
		List<Integer> list1 = list.stream().map( p -> p*2).collect(Collectors.toList());
		System.out.println(list1);
		
		Optional<Integer> d  = list.stream().sorted(Comparator.comparingInt(Integer::intValue).reversed()).skip(1).findFirst();
		System.out.println(d.get());
	}
}
