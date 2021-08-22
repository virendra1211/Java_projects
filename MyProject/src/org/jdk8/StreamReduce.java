package org.jdk8;

import java.util.Arrays;
import java.util.List;

public class StreamReduce {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(23,12,11,18,28,37);
		Integer maxVal = list.stream().reduce(Integer::max).get();
		System.out.println(maxVal);
	}
}
