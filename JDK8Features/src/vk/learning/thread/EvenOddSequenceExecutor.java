package vk.learning.thread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EvenOddSequenceExecutor {
	final Object obj = new Object();
	final int max = 10;
	int number = 1;

	public static void main(String[] args) {
		functionIdentityAlsoUsedInfilter();
		collectorsToMapMergeRequire();

		ExecutorService executor = Executors.newFixedThreadPool(2);
		EvenOddSequenceExecutor print = new EvenOddSequenceExecutor();
		executor.submit(print::printOdd);
		executor.submit(print::printEven);
	}

	private static EvenOddSequenceExecutor printOdd() {
		// TODO Auto-generated method stub
		return null;
	}

	private static void collectorsToMapMergeRequire() {
		List<String> list = Arrays.asList("apple", "banana", "pineable", "peru", "pulse");
		Map<Character, String> map = list.stream().collect(Collectors.toMap(s -> s.charAt(0),
				s -> s, (existing, replacement) -> existing + ", " + replacement));
		map.forEach((k, v) -> System.out.println(k + " " + v));
	}

	private static void functionIdentityAlsoUsedInfilter() {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);

		list.stream().map(Function.identity()).forEach(System.out::println);
		System.out.println("after " + list.size());
	}
}

interface I {
}

record abc(String abc) implements I {
	public String getDisplayName() {
		return "abc";
	}
}