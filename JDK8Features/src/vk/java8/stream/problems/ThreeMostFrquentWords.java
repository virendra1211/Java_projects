package vk.java8.stream.problems;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ThreeMostFrquentWords {

    public static void main(String[] args) {
	List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple", "mango");

	Map<String, Long> freqMap = words.stream().collect(Collectors.groupingBy(w -> w, Collectors.counting()));

	List<Map.Entry<String, Long>> top3 = freqMap.entrySet().stream()
		.sorted(Map.Entry.<String, Long>comparingByValue().reversed()).limit(3).collect(Collectors.toList());

	top3.forEach(entry -> System.out.println("Word: " + entry.getKey() + ", Count: " + entry.getValue()));
    }

}
