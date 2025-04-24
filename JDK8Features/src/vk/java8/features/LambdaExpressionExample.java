package vk.java8.features;

public class LambdaExpressionExample {

    public static void main(String[] args) {
	// TODO Auto-generated method stub

	MathOperation<Integer> multiply = (a, b) -> a * b;

	MathOperation<Double> addition = (a, b) -> a + b;

	MathOperation<Integer> subtraction = (a, b) -> a - b;

	System.out.println(multiply.operation(6, 10));
	System.out.println(addition.operation(6.0, 10.1));
	System.out.println(subtraction.operation(6, 10));
    }

}

interface MathOperation<T> {
    T operation(T a, T b);
}
