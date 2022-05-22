package ifelseconcept;

public class Ifelsedemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int age = 30;
		int age1 = 40;

		if (age==30) {
			System.out.println("You are and adult");
		} else {
			System.out.println("You are not an adult");
		}

		if (age1>30 && age1<60) {
			System.out.println("You are and adult age1");
		} else {
			System.out.println("You are not an adult");
		}

		if(age1!=40)
		{
			System.out.println("it is correct");
		}
		else {
			System.out.println("it is 40");
		}

	}

}
