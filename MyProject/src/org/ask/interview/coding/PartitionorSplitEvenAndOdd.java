package org.ask.interview.coding;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartitionorSplitEvenAndOdd {
    public static void main(String[] args) {
	Integer[] arr = { 8, 5, 11, 4, 6, 5, 8, 9, 11 };
	List<Integer> list = Arrays.asList(arr);
	Map<Boolean, List<Integer>> collect = list.stream().collect(Collectors.partitioningBy(p -> p % 2 == 0));

	System.err.println(collect);

    }
}
