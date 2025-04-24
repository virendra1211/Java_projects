package org.test;

import java.security.DomainCombiner;

public class Test1 {
	// 20251
	// 00111
	public static void main(String[] args) {
		int input[] = { 2, 0, 2, 5, 1 };
		System.out.println(f(input, 0));
	}

	int tempArray[] = new int[5];
	int count = 0;

	private static char[] f(int[] input, int index) {
		while (input[index] > input[index + 1]) {
			index++;
		}

		return null;
	}
}
