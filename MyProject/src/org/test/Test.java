package org.test;

public class Test {
    public static void main(String[] args) {
	String str = "abc";
	String str1 = "abc";
	str.concat(str1);
	System.out.println(str);
	System.out.println(str.concat(str1));

	String s1 = "vire";
	String s2 = new String("vire");

	System.out.println(s1 == s2);
	System.out.println(s1 == s2.intern());

	String s11 = "abc";
	String s22 = "cdf";
	System.out.println("s1 == s3 is: " + s11 == s22);
	System.out.println(s11.compareTo(s22));
    }
}
