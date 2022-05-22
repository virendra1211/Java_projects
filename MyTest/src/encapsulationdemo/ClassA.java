package encapsulationdemo;



public class ClassA {
	
	private int a =125;
	private String myVariable ="test";
	//private  String ab ="Manjushree";
	public  int getA() {
		ClassA cA = new ClassA();
		return cA.a;
	}
	
	public String getMyVariable() {
		return myVariable;
	}
	
	public void setMyVariable(String myVariable) {
		this.myVariable = myVariable;
	}
	
	public  void setA(int a) {
		this.a = a;
	}
//	public static String getAb() {
//		return ab;
//	}
//	public static void setAb(String ab) {
//		ClassA.ab = ab;
//	}
	

}
