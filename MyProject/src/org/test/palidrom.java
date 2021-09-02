package org.test;

public class palidrom {
	public static void main(String[] args) {
	int num = 121;
	if(num == reverseOrder(num)) {
			System.out.println("palidrom");
		}else {
			System.out.println("Not palidrom");
		}
	}
	public static int reverseOrder(Integer number) {
		int remainder; 
		int reversenum = 0;
		while(number!=0) {
			remainder = number %10;
			reversenum = reversenum * 10 + remainder;
			number = number/10;
		}
		
		return reversenum;
	}
}
