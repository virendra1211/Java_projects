package virendra.interview;

class A{
	{
		System.out.println("super Initializer block");
	}
	static{
		System.out.println("static super block");
	}
	static{
		System.out.println("static super block 1");
	}
}
public class InitializestaticandOtherblock extends A{
	private int i;
	
	{
		System.out.println("sub Initializer"+i++);
	}
	
	static {
		System.out.println("static simple block");
	}
	static {
		System.out.println("static simple block 1");
	}
	InitializestaticandOtherblock(){
		System.out.println("constructor"+i++);
	}
	public static void main(String[] args) {
		
		  InitializestaticandOtherblock obj = new InitializestaticandOtherblock();
		  System.out.println("--------- "); 
		  InitializestaticandOtherblock obj1 = new InitializestaticandOtherblock();
		  System.out.println("--------- #"); 
		  InitializestaticandOtherblock obj2 = new InitializestaticandOtherblock();
			 
	}
	
}
