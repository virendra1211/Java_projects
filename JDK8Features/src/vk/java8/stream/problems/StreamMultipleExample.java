package vk.java8.stream.problems;

import java.util.Arrays;
import java.util.List;

public class StreamMultipleExample {
	public static void main(String[] args) {
		streamToArray();
	}

	static void streamToArray() {
		List<Integer> strList = Arrays.asList(1, 2, 3, 4, 5, 6);
		Integer[] intArray = strList.stream().toArray(Integer[]::new);
		System.out.println("Array elements- " + Arrays.toString(intArray));
		otherWay(strList);
	}

	private static void otherWay(List<Integer> strList) {
		strList.stream().mapToInt(e -> e).toArray();
	}

}
