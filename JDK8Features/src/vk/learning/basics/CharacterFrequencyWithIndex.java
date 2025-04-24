package vk.learning.basics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CharacterFrequencyWithIndex {
    public static void main(String[] args) {
	// Given input string
	String input = "JavaJavaeE";

	// Store character frequencies and their indices (case-insensitive key)
	Map<Character, List<Integer>> charIndices = new LinkedHashMap<>();

	// Iterate through the string and collect indices
	IntStream.range(0, input.length()).forEach(j -> {
	    char lowerCaseChar = Character.toLowerCase(input.charAt(j)); // Convert to lowercase
	    charIndices.computeIfAbsent(lowerCaseChar, k -> new ArrayList<>()).add(j);
	});

	Map<Character, List<Integer>> charIndices1 = new LinkedHashMap<>();
	for (int i = 0; i < input.length(); i++) {
	    char lcase = input.charAt(i);
	    if (charIndices1.containsKey(lcase)) {
		charIndices1.put(lcase, charIndices1.get(lcase)).add(i);
	    } else {
		List<Integer> list = new ArrayList<>();
		list.add(i);
		charIndices1.put(lcase, list);
	    }
	}
	System.out.println(charIndices1);
	Map<String, String> productDetails = new HashMap<>();
	String description = productDetails.computeIfAbsent("Shirt", key -> "Default description for " + key);

	System.out.println("Description for Shirt: " + description);

	// Print characters that appear more than once with their indices
	charIndices.forEach((ch, indices) -> {
	    if (indices.size() > 1) {
		System.out.println(ch + " : " + indices.size() + " | Indices: " + indices);
	    }
	});

	// Filter characters that appear more than once but less than 3 times
	Map<Character, List<Integer>> filteredResult = charIndices.entrySet().stream()
		.filter(entry -> entry.getValue().size() > 1 && entry.getValue().size() < 3)
		.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (o, n) -> o, LinkedHashMap::new));

	// Print filtered results
	filteredResult
		.forEach((ch, indices) -> System.out.println(ch + " = " + indices.size() + " | Indices: " + indices));
    }
}
