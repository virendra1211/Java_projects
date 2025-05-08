package vk.learning.algo;

public class CustomDequeue<E> {

	Node<E> head;
	Node<E> tail;

	static class Node<E> {
		Node<E> next, prev;
		E data;

		Node(E data) {
			this.data = data;
		}
	}

	void pushFirst(E data) {
		Node<E> newNode = new Node(data);
		if (head == null) {
			head = tail = newNode;
		} else {
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		}
	}

	// Remove and return the first element
	E popFirst() {
		if (head == null)
			throw new RuntimeException("Dequeue is empty ");

		E value = head.data;
		head = head.next;
		if (head != null) {
			head.prev = null;
		} else {
			tail = null;
		}
		return value;
	}

	// Return (but do not remove) the first element
	public E pullFirst() {
		if (head == null) {
			throw new RuntimeException("Deque is empty");
		}
		return head.data;
	}

	// Return (but do not remove) the last element
	public E pullLast() {
		if (tail == null) {
			throw new RuntimeException("Deque is empty");
		}
		return tail.data;
	}

	public static void main(String[] args) {
		CustomDequeue<Integer> deque = new CustomDequeue<>();

		deque.pushFirst(10);
		deque.pushFirst(20);

		System.out.println(deque.pullFirst()); // 20
		System.out.println(deque.pullLast()); // 10

		System.out.println(deque.popFirst()); // 20
		System.out.println(deque.pullFirst()); // 10
	}

}
