package org.design.pattern;

/*
 * In Strategy pattern, a class behavior or its algorithm can be changed at run time. 
 * This type of design pattern comes under behavior pattern.
 * In Strategy pattern, we create objects which represent various strategies and a context 
 * object whose behavior varies as per its strategy object. The strategy object changes the executing algorithm of the context object.
 */
public class StrategyPatternDemo {
	public static void main(String[] args) {
		Context context = new Context(new OperationAdd());
		System.out.println(" + operation "+context.executeStrategy(10,5));
		
		context = new Context(new OperationSubtract());
		System.out.println(" - operation "+context.executeStrategy(10,5));
		
		context = new Context(new OperationMultiply());
		System.out.println(" X operation "+context.executeStrategy(10,5));
	}
}

interface Strategy{
	public int doOperation(int num1,int num2);
}

class Context{
	private Strategy strategy;
	
	public Context(Strategy strategy) {
		this.strategy = strategy;
	}
	public int executeStrategy(int num1,int num2) {
		return strategy.doOperation(num1, num2);
	}
}

class OperationAdd implements Strategy{
	@Override
	public int doOperation(int num1, int num2) {
		return num1 +num2;
	}
}
class OperationSubtract implements Strategy{
	@Override
	public int doOperation(int num1, int num2) {
		return num1 - num2;
	}
}
class OperationMultiply implements Strategy{
	@Override
	public int doOperation(int num1, int num2) {
		return num1 * num2;
	}
}