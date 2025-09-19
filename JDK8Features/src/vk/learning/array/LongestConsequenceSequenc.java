package vk.learning.array;

import java.util.HashSet;
import java.util.Set;

public class LongestConsequenceSequenc {

	public static void main(String[] args) {
		int[] nums = { 50, 10, 60, 11, 12, 13 };
		System.out.println(longestConsecutive(nums));
	}

	public static int longestConsecutive(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int i : nums) {
			set.add(i);
		}
		int maxLength = 0;
		for (int num : nums) {

			if (!set.contains(num - 1)) {
				int count = 1;
				int currentNum = num;
				while (set.contains(currentNum + 1)) {
					count++;
					currentNum++;
				}
				maxLength = Math.max(maxLength, count);

			}
		}
		return maxLength;
	}

}
