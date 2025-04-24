package org.test;

import java.io.*;

// Java program to implement
// a Singly Linked List
public class LinkedList {

	Node head; // head of list

	// Linked list Node.
	// This inner class is made static
	// so that main() can access it
	static class Node {

		int data;
		Node next;

		// Constructor
		Node(int d)
		{
			data = d;
			next = null;
		}
		
	}
	
	static boolean doSomething(Node firstList,Node secondList) {
		Node ptr1 = firstList, ptr2 = secondList;
		
		while(secondList !=null) {
			ptr2 = secondList;
			while(ptr1 != null) {
				if(ptr2 ==null)
					return false;
				else if (ptr1.data == ptr2.data) {
					ptr1 = ptr1.next;
					ptr2 = ptr2.next;
				}else
					break;
			}
			if( ptr1 == null)
					return true;
			
			ptr1 = firstList;
			secondList = secondList.next;
		}
		return false;
	}

	// Method to insert a new node
	public static LinkedList insert(LinkedList list, int data)
	{
		// Create a new node with given data
		Node new_node = new Node(data);
		new_node.next = null;

		// If the Linked List is empty,
		// then make the new node as head
		if (list.head == null) {
			list.head = new_node;
		}
		else {
			// Else traverse till the last node
			// and insert the new_node there
			Node last = list.head;
			while (last.next != null) {
				last = last.next;
			}

			// Insert the new_node at last node
			last.next = new_node;
		}

		// Return the list by head
		return list;
	}

	// Method to print the LinkedList.
	public static void printList(LinkedList list)
	{
		Node currNode = list.head;
	
		System.out.print("LinkedList: ");
	
		// Traverse through the LinkedList
		while (currNode != null) {
			// Print the data at current node
			System.out.print(currNode.data + " ");
	
			// Go to next node
			currNode = currNode.next;
		}
	}
	

	// Driver code
	public static void main(String[] args)
	{
		
		
		
		/* Start with the empty list. */
		LinkedList list = new LinkedList();
		Node first = new Node(2);
		first.next = new Node(3);
		first.next.next = new Node(4);
		first.next.next.next = new Node(7);
		first.next.next.next.next = new Node(8);
		first.next.next.next.next.next = new Node(9);
		//first.next.next = new Node(4);
		// 2 3 4 7 8 9 
		// 2 3 4
		Node second = new Node(2);
		second.next = new Node(3);
		second.next.next = new Node(4);
		/*
*//*
		 * second.next.next.next.next.next = new Node(4);
		 * second.next.next.next.next.next.next = new Node(5);
		 * second.next.next.next.next.next.next.next = new Node(9);
		 */
		
		System.out.println(list.doSomething(first, second));
		
		/*
		 * 
		 * // // ******INSERTION****** //
		 * 
		 * // Insert the values list = insert(list, 1); list = insert(list, 2); list =
		 * insert(list, 3); list = insert(list, 4); list = insert(list, 5); list =
		 * insert(list, 6); list = insert(list, 7); list = insert(list, 8);
		 * 
		 * // Print the LinkedList printList(list);
		 */
	}
}
