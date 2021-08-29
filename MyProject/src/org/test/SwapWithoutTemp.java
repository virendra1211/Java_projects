package org.test;

public class SwapWithoutTemp {
	public static void main(String[] args) {
		int a=10,b=20;
		
		a = a+b; // 30
		b = a - b; // 10
		a =  a-b;
		System.out.println(a+" "+b);
	}
}
