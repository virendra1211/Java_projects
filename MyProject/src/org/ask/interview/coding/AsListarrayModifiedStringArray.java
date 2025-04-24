package org.ask.interview.coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AsListarrayModifiedStringArray {
    public static void main(String[] args) {
	String str[] = { "pune", "mumbai", "delhi", "pane", "pabne", "pabce" };

	// List<String> list = Arrays.asList(str);
	/*
	 * above code return pune, indore,delhi based on str[1] = "indore" return list
	 * is backed by original array
	 */
	List<String> list = new ArrayList<>(Arrays.asList(str));
	str[1] = "indore";
	// list.forEach(System.out::println);
	list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }
}
