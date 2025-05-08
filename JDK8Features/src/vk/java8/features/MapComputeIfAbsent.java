package vk.java8.features;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MapComputeIfAbsent {
	public static void main(String[] args) {
		addPair("INDIA", "DELHI");
		addPair("INDIA", "PUNE");
		addPair("INDIA", "MUMBAI");
		addPair("USA", "DALLAS");
		addPair("USA", "Chicago");
		System.out.println(citiesInCountry);
		characterFrequency();
	}

	private static void characterFrequency() {
		Map<String, String> map = new HashMap<>() {
			public String put(String key, String value) {
				return putIfAbsent(key, value);
			};
		};
		map.put("a", "abc");
		map.put("a", "abc234");
		System.out.println(map);

		String input = "aAbcdBef";
		Map<Character, List<Integer>> frequencyMap = new HashMap<>();

		Map<Character, Long> result = input.chars().mapToObj(c -> (char) c)
				.map(Character::toUpperCase)
				.collect(Collectors.groupingBy(c -> c, Collectors.counting()));
		System.out.println(result);

		Map<Character, List<Integer>> charIndices = new LinkedHashMap<>();

		IntStream.range(0, input.length()).forEach(j -> {
			char lowerCaseChar = Character.toLowerCase(input.charAt(j)); // Convert to lowercase
			charIndices.computeIfAbsent(lowerCaseChar, k -> new ArrayList<>()).add(j);
		});

		System.out.println(charIndices);

	}

	private static final Map<String, List<String>> citiesInCountry = new HashMap<>();

	private static void addPair(String country, String city) {

		// citiesInCountry.computeIfAbsent(country, k -> new ArrayList<>()).add(city);

		if (citiesInCountry.containsKey(country)) {
			citiesInCountry.get(country).add(city);
		} else {
			citiesInCountry.put(country, new ArrayList<>(List.of(city)));
		}

	}
}

class KeyValue {
	private int count;
	private List<Integer> indexes;

	public KeyValue() {
		this.count = 0;
		this.indexes = new ArrayList<>();
	}

	public void addIndex(int index) {
		this.count++; // Increase count
		this.indexes.add(index); // Add index
	}

	@Override
	public String toString() {
		return count + " : indexes " + indexes;
	}

}
