package org.algoquestion;

import javax.swing.tree.TreeNode;

class A{
	public static void m() {
		System.out.println("static method");
	}
}
public class Binarytrequs {
	public static void main(String[] args) {
		A a2 = null;
		a2.m();
			A a1 = new A() ;
			if(a1 instanceof A) {
				System.out.println("AA");
			}
	}
	
	public boolean iStrictTree(TreeNode node) {
		if (node == null) {
		    return true;
		}
		return false;
		/*if ((node.left() == null && node.right() != null) || (node.left() != null && node.right() == null)) {
		    return false;
		}
		return isStrictTree(node.left()) && isStrictTree(node.right());*/
	}
}
