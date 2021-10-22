package virendra.interview;

public class InitializestaticandOtherblock {
	private int i;
	
	{
		System.out.println("simple block"+i++);
	}
	
	static {
		System.out.println("static simple block");
	}
	InitializestaticandOtherblock(){
		System.out.println("constructor"+i++);
	}
	public static void main(String[] args) {
		InitializestaticandOtherblock obj = new InitializestaticandOtherblock();
	}
	
}
