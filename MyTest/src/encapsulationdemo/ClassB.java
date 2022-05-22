package encapsulationdemo;




public class ClassB extends ClassA {

	public static void main(String[] args) {
		ClassA cA = new ClassA();
		System.out.println(cA.getA());
		cA.setA(130);
		System.out.println(cA.getA());
	}
	
}
