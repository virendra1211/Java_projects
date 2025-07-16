package org.ask.interview.coding;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeativeCharacter {
	public static void main(String args[]) {
		String inputStr = "teeter";
		// inputStr = "stress";
		inputStr = "STreEs";
//		inputStr = inputStr.toUpperCase();
		for (char i : inputStr.toCharArray()) {
			if (inputStr.indexOf(i) == inputStr.lastIndexOf(i)) {
				System.out.println("First non-repeating character is: " + i);

				String.valueOf(i);
				break;
			}
		}

		// Other approach by Streams

		Map<Character, Long> map = inputStr.chars().mapToObj(c -> (char) Character.toUpperCase(c))
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,
						Collectors.counting()));

		System.out.println(map);
		int result = (int) add(10, 20);
		System.out.println(result);
	}

	/*
	 * static int add(int a, int b) { System.out.println("1**"); return a + b; }
	 */
	static float add(long a, long b) {
		System.out.println("$$");
		return (float) 50;
	}

}
