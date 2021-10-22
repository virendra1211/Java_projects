package org.jdk8;

public class LambdaEx {
	public static void main(String[] args) {
		Calculators p = (a,b) ->a*b;
		System.out.println(p.calculate(5, 6));
		
		Calculators p1 = (a,b) ->a+b;
		System.out.println(p1.calculate(5, 6));
		
	}
}

interface Calculators{
	int calculate(int a,int b);
}