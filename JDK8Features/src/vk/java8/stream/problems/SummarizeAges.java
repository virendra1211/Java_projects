package vk.java8.stream.problems;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class SummarizeAges {
    public static void main(String[] args) {
	List<Integer> ages = Arrays.asList(24, 30, 28, 36, 24, 31);
	IntSummaryStatistics stats = ages.stream().collect(Collectors.summarizingInt(Integer::intValue));

	System.out.println("Count: " + stats.getCount());
	System.out.println("Sum: " + stats.getSum());
	System.out.println("Min: " + stats.getMin());
	System.out.println("Max: " + stats.getMax());
	System.out.println("Average: " + stats.getAverage());

    }
}
