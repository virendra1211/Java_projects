package com.test.codility;

import java.util.stream.IntStream;

public class SumTest {
    public static void main(String[] args) {
	// List<Integer> list = Arrays.stream(A).mapToObj(a ->
	// a).collect(Collectors.toList());
	String A = "abcdefae";
	IntStream.range(0, A.length()).map(g -> A.length() - 1 - g).mapToObj(p -> A.charAt(p)).map(Object::toString)
		.forEach(System.out::println);

	/*
	 * A.toCharArray()).mapToObj(a -> a).sorted().collect(Collectors.toList());
	 * 
	 * int result = 0; for (Integer integer : data) { integer = integer + 1; if
	 * (list.contains(integer) && integer > 0) { continue; } else { result =
	 * integer; break; } } if (result <= 0) { result = 1; }
	 */

    }
}