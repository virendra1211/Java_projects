package org.algoquestion;

import javax.swing.tree.TreeNode;


public class Binarytrequs {
	public static void main(String[] args) {
		
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
