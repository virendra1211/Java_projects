package org.jdk8;

public class FunctionalInterfaceWhyCome {

	public static void main(String[] args) {

		Calculator<Integer> calcAddition = (num1, num2) -> { return num1 + num2; };
		System.out.println(calcAddition.calculate(4, 5));
		
		Calculator<Integer> calcMultiply = (num1, num2) -> { return num1 * num2; };
		System.out.println(calcMultiply.calculate(4, 5));

	}
}

@FunctionalInterface
interface Calculator<T> {
	public T calculate(T num1, T num2);
}


