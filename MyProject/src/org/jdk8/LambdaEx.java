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
	}
}

interface Calculators{
	int calculate(int a,int b);
}