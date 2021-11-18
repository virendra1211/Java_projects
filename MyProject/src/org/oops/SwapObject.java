package org.oops;

/**
 * https://www.geeksforgeeks.org/swap-exchange-objects-java/?ref=lbp
 * @author Virendra khade
 How to swap or exchange objects in Java?
 If we would like to swap object can't be possible if we don't know the attribute name.
 attibute can be swap like below
  public static void swap(Car c1, Car c2)
    {
        int temp = c1.no;
        c1.no = c2.no;
        c2.no = temp;
    }
 swap solution is work when we know member of car attriute but can't work when we swap object if we are using other class
 and don't the attriute
 
 
 */
public class SwapObject {
	public static void main(String[] args) {
		
		Car11 c1 = new Car11(101,1011);
		Car11 c2 = new Car11(201,2011);
		CarWrapper cw1 = new CarWrapper(c1);
		CarWrapper cw2 = new CarWrapper(c2);
		
		swap(cw1,cw2);
		cw1.c.print();
		cw2.c.print();
		
	}
	public static void swap(CarWrapper cw1,CarWrapper cw2) {
		Car11 temp = cw1.c;
		cw1.c = cw2.c;
		cw2.c = temp;
	}
}
class CarWrapper{
	Car11 c;
	CarWrapper(Car11 c){
		this.c = c;
	}
}
class Car11{
	int model,no;

	public Car11(int model2, int no2) {
		this.model = model2;
		this.no = no2;
	}
		public void print() {
		System.out.println("no ="+no+" model= "+model);
	}

	public int getModel() {
		return model;
	}

	public void setModel(int model) {
		this.model = model;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}
	
}