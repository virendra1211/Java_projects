package org.datastructure;

//Java program to implement a Singly Linked List
public class LinkedList1 {
	Node head;

	static class Node {
		Node next;
		int d;

		Node(int data) {
			this.d = data;
			next = null;
		}
	}

	void insert(int data) {
		Node newNode = new Node(data);
		newNode.next = null;

		if (head == null) {
			head = newNode;
		} else {
			Node last = head;
			while (last.next != null) {
				last = last.next;
			}
			last.next = newNode;
		}
	}
// 1 ,2 ,3 4

	Node reverse() {
		Node current = head;
		Node prev = null;

		while (current != null) {
			Node temp = current.next;
			current.next = prev;
			prev = current;
			current = temp;
		}
		return prev;
	}

	void printList() {
		Node current = head;
		while (current != null) {
			System.out.println(current.d);
			current = current.next;
		}
	}

	// Driver code
	public static void main(String[] args) {
		// Start with the empty list.
		LinkedList1 list = new LinkedList1();

		// ****** INSERTION ******
		list.insert(1);
		list.insert(2);
		list.insert(3);
		list.insert(4);
		list.insert(5);
		list.insert(6);
		list.insert(7);
		list.insert(8);

		// Print the LinkedList
		list.printList();
		Node node = list.reverse();
		list.head = node;
		System.out.println("**********");
		list.printList();
	}
}
