package vk.learning.array.tough.interview;

import java.util.Arrays;
import java.util.stream.Collectors;

public class GenerateBigNumberByArray {
	public static void main(String[] args) {
		Integer[] nums = { 3, 30, 34, 5, 9 };
		byStreamWay(nums);
		byNormalWay(nums);
	}

	private static void byNormalWay(Integer[] nums) {
		String[] newStrNums = new String[nums.length];
		int index = 0;
		for (Integer num : nums) {
			newStrNums[index++] = String.valueOf(num);
		}

		Arrays.sort(newStrNums, (a, b) -> (b + a).compareTo(a + b));

		StringBuilder result = new StringBuilder();
		for (String str : newStrNums) {
			result.append(str);
		}
		System.out.println("normal way " + result.toString());
	}

	private static void byStreamWay(Integer[] nums) {
		Arrays.stream(nums).mapToInt(pa -> pa).mapToObj(String::valueOf).collect(Collectors.toList());

		String result = Arrays.stream(nums).mapToInt(num -> num).mapToObj(String::valueOf)
				.sorted((a, b) -> (b + a).compareTo(a + b)).collect(Collectors.joining());
		System.out.println(result);
		// Ans 9534330
	}
}
