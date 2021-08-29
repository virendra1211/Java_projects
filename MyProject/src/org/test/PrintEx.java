package org.test;

public class PrintEx {
	public static void main(String[] args) {
		String str = "abcdedf";
		display(str,str.length());
	}

	private static void display(String str, int length) {
		
		System.out.println(str.substring(0,length));
		if(length<=0)return;
		display(str,length-1);
		
	}
}
