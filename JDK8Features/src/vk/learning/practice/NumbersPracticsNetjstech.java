package vk.learning.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*
 * o strings “Always” and “Be” are compared then only by comparing first character it 
 */
public class NumbersPracticsNetjstech {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(2, 35, 23, 6, 8);
		formLargestNum(list);
		// ans 8635232
	}

	private static void formLargestNum(List<Integer> list) {

		Collections.sort(list, new Comparator<Integer>() {
			@Override
			public int compare(Integer num1, Integer num2) {
				String a = num1.toString() + num2.toString();
				String b = num2.toString() + num1.toString();
				System.out.println("a -" + a);
				System.out.println("b -" + b);
				return b.compareTo(a);
			}
		});

		String result = list.stream().map(String::valueOf).collect(Collectors.joining());
		System.out.println(result);

	}
}
