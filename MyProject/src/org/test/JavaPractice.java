package org.test;

public class JavaPractice {

	public static void main(String[] args) {
		System.out.println(isPrime(11));
		System.out.println(isPrime(8));
		System.out.println(isPrime(13));
		
		fibonacci(5);
System.out.println();
		System.out.println(multiply(4,24));
	}

	public static boolean isPrime(int num) {
		for (int i = num - 1; i > 1; i--) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void fibonacci(Integer n) {
		int n1=0,n2=1,n3,i,count=10;
		System.out.print(n1+" "+n2);
		int sum =0;
		for(i =0;i<count;i++) {
			n3 = n1+n2;
			System.out.print(" "+n3);
			if(n3%2 ==0)
				sum = sum + n3;
			n1 = n2;
			n2 = n3;
		}
		System.out.println("  even sum1 = "+sum);
	}
	
	public static int multiply(int A,int B) {
		int count =0;
		int j =0;
		// 5 10
		boolean flag = true;
		while(count < B) {
			count ++; // 1 , 3,
			j = A +j;
			if( j >= B && flag) {
				System.out.println("divide "+count);
				flag = false;
				}
			}
		return j;
	}

}