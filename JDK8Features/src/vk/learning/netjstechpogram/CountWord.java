package vk.learning.netjstechpogram;

import java.util.stream.Stream;

public class CountWord {
	public static void main(String[] args) {
		System.out.println("Count using split logic "
				+ countWordsUsingSplit("         Life     is       beautiful  "));
		System.out.println("Count using split logic "
				+ countWordsUsingStream("         Life     is       beautiful  "));
	}

	private static long countWordsUsingStream(String string) {
		return Stream.of(string.trim().split("\\s+")).count();
	}

	private static int countWordsUsingSplit(String string) {

		String[] str = string.trim().split("\\s+");

		return str.length;
	}
}
