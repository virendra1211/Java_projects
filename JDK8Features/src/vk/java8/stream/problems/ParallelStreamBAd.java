package vk.java8.stream.problems;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelStreamBAd {
	public static void main(String[] args) {
		// List<Integer> list = new ArrayList<>();
		CopyOnWriteArrayList list = new CopyOnWriteArrayList();
		IntStream.range(0, 1000).parallel().forEach(list::add); // BAD IDEA
		System.out.println("size " + list.size());

		// better we can use below code

		List<Integer> safeList = IntStream.range(0, 1000).parallel().boxed()
				.collect(Collectors.toList());
		System.out.println("Safe List Size: " + safeList.size());
	}
}
