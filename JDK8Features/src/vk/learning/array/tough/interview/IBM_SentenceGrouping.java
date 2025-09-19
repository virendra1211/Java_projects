package vk.learning.array.tough.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class IBM_SentenceGrouping {
	public static void main(String[] args) {
		List<String> sentences = Arrays.asList("sky is blue", "blue is sky", "hello world", "world hello",
				"sky is    blue  ", "HELLO WORLD", "skyblue is", "sky lueb is");

		Map<String, List<String>> hashMap = new LinkedHashMap<>();

		for (String sentence : sentences) {
			if (sentence != null) {
				// Step 1: Normalize (lowercase + trim + collapse multiple spaces)
				String normalized = sentence.toLowerCase().trim().replaceAll("\\s+", " ");

				// Step 2: Split into words
				String[] words = normalized.split(" ");

				// Step 3: Sort words alphabetically
				Arrays.sort(words);

				// Step 4: Create key (sorted words joined back)
				String key = String.join(" ", words);

				// Step 5: Add to map
				hashMap.computeIfAbsent(key, k -> new ArrayList<>()).add(sentence);
			}
		}

		// Print the results
		// hashMap.forEach((k, v) -> System.out.println(k + " -> " + v));
		hashMap.values().forEach(System.out::println);
		List<List<String>> groupValues = new ArrayList<>(hashMap.values());
		System.out.println(" = ===== ");
		groupValues.forEach(System.out::println);

		Map<Object, List<String>> result1 = sentences.stream().collect(Collectors.groupingBy(p -> {
			String normalized = p.toString().toLowerCase().trim().replaceAll("\\s+", " ");
			String[] words = normalized.split(" ");
			Arrays.sort(words);
			String key = String.join(" ", words);
			return key;
		}, LinkedHashMap::new, Collectors.toList()));

		List<List<String>> list1 = new ArrayList<>(result1.values());
		System.out.println(" ------- by group by function ");
		list1.forEach(System.out::println);

	}
}
