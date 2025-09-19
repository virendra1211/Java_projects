package vk.learning.verion.feature;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Java11Feature {

	public static void main(String[] args) {
		// 1. New String method to String class like isBlank, lines, strip
		// repeat,stripLeading, stripTailing
		String multipleString = "Virendra helps \n \n developers \n explore Java.";
		List<String> list = multipleString.lines().filter(lines -> !lines.isBlank()).map(String::strip)
				.collect(Collectors.toList());
		System.out.println(list);

		// 2. Collections to an Array
		List sampleList = Arrays.asList("java", "spring");
		String[] sampleArray = (String[]) sampleList.toArray(String[]::new);
		for (int i = 0; i < sampleArray.length; i++) {
			System.out.println(sampleArray[i]);
		}
		// 3. The Not predicate Method, Predicate.not, Big advantage is that we can also
		// use not with method reference.
		List<String> sampleList1 = Arrays.asList("Java", "\n \n", "Kotlin", " ");
		List withoutBlanks = sampleList1.stream().filter(Predicate.not(String::isBlank))
				.collect(Collectors.toList());
		System.out.println(withoutBlanks);
		// 4.Local-varialbe syntax for lambda
		List<String> sampleList2 = Arrays.asList("Java", "Kotlin", null);
		String resultString = sampleList2.stream().filter(Java11Feature::isNotNull)
				.map((@Nonnull var x) -> x.toUpperCase()).collect(Collectors.joining(","));
		System.out.println(resultString); // we cal also use java.util.Objects.nonnull
		// 5. HTTP API IMproves overall performance and provide support for both
		// HTTP/1.1 and HTTP/2

		// 6 we can use Java HellowWorld.java directly instad of adding javac and then
		// java
		// 7. add performance improvement

		// 8. No-Op Garbage collector , called Epsilon is available for use in java 11
		// as an experimental features it's called No-Op(no operations), it's available
		// for simulating out of memory errors.

	}

	public static boolean isNotNull(String str) {
		return str != null && str.trim().length() > 0;
	}

}

// user id and time stamp, we have to use sliding window of 10 minute, 
// answer time complexity, 