package org.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaEx {
	public static void main(String[] args) {
		Calculators p = (a,b) ->a*b;
		System.out.println(p.calculate(5, 6));
		
		Calculators p1 = (a,b) ->a+b;
		System.out.println(p1.calculate(5, 6));
		String s ="a b c d a";
		List<String> sss = Arrays.asList(s.split(" "));
		List<String> ss = sss.stream().distinct().collect(Collectors.toList());
		System.out.println(ss);
		
		Integer p11[] = {10,20,33,44,50,54,43,67};
		
		List<Integer> list = Arrays.asList(p11);
		
		list.stream().map(p3 -> p3%2==0 ? p3+1:p3*3+1);
		
		
		
		
	}
}

interface Calculators{
	int calculate(int a,int b);
}