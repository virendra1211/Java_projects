package p1;


public class c2 {
	public static void main(String[] args)
	{
		c2 ref1=new c2();
		ref1.abc();
		ref1.pqr();
		ref1.abc();
		
	}
	public void abc(){
		c1 ref=new c1();
		System.out.println(ref.a);
		System.out.println(ref.d);
		
	}
	
	public void pqr() {
		String variable="value";
		System.out.println(variable);
	}

	}
	


