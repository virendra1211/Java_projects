package com.user;

public class Solution {public static void main(String[] args) {
	dosomething(new String[] {"white","Yellow","cat","blue"},4);
}

public  static void dosomething(String  []s, int n) {
	for(int i=1;i<n;i++)
	{
		String  temp =s[i];
		int j=i-1;
		while(j>-0 && temp.length()< s[j].length()) {
			s[j+1] = s[j];
					j--;
			
		}
		s[j+1] = temp;
		
	}
	
	for(int k=0;k<n;k++) {
		System.out.println(s[k]+" ");
	}
	
}
}
