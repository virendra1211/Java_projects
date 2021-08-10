package org.jdk8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamTest {

	static List<Integer> myList = new ArrayList<>();

	public static void main(String[] args) {

		for (int i = 0; i < 5000000; i++)
			myList.add(i);

		int result = 0;
		long loopStartTime = System.currentTimeMillis();
		for (int i : myList) {
			if (i % 2 == 0)
				result += i;
		}

		long loopEndTime = System.currentTimeMillis();

		System.out.println(result);

		System.out.println("Loop total Time = " + (loopEndTime - loopStartTime));

		long streamStartTime = System.currentTimeMillis();

		System.out.println(myList.stream().filter(value -> value % 2 == 0).mapToInt(Integer::intValue).sum());

		long streamEndTime = System.currentTimeMillis();
		System.out.println("Stream total Time = " + (streamEndTime - streamStartTime));

		long parallelStreamStartTime = System.currentTimeMillis();
		System.out.println(myList.parallelStream().filter(value -> value % 2 == 0).mapToInt(Integer::intValue).sum());

		long parallelStreamEndTime = System.currentTimeMillis();

		System.out.println("Parallel Stream total Time = " + (parallelStreamEndTime - parallelStreamStartTime));
//////////////////////
		List<Integer> number = Arrays.asList(2,3,4,5);
		// demonstration of reduce method
	    int even = number.stream().filter(x->x%2==0).reduce(0,(ans,i)-> ans+i);
	    System.out.println(even);
	  
	
	}
}