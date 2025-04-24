package vk.learning.basics;

public class LRUCache1 {

    private final int max_age = 15 * 60 * 1000;
    private final int max_limit = 100;
    Node head, tail;

    public void moveToHead(Node node) {
	removeNode(node);
	addNodeToHead(node);

    }

    private void removeNode(Node currentNode) {
	if (currentNode.prev != null)
	    currentNode.prev.next = currentNode.next;
	else
	    head = currentNode.next;

	if (currentNode.next != null)
	    currentNode.next.prev = currentNode.prev;
	else
	    tail = currentNode.prev;

    }

    private void addNodeToHead(Node node) {
	node.next = head;
	node.prev = null;

	if (head != null) {
	    head.prev = node;
	}
	head = node;

	if (tail == null)
	    tail = node;

    }

    public static void main(String[] args) {

	LRUCache1 cache = new LRUCache1();

	for (int i = 1; i <= 105; i++) {
	    cache.put(i, i * 10);
	    cache.put(i, i * 11);
	}

	// Should return -1 for first inserted item since it was evicted
	System.out.println(cache.get(1)); // -1
	System.out.println(cache.get(100)); // should be valid
	Thread.sleep(61000);
	System.out.println(cache.get(1)); // -1
	System.out.println(cache.get(100)); // should be valid
    }

    static class Node {
	int k, v;
	long currentTimeMillis;
	Node prev, next;

	Node(int k, int v) {
	    this.k = k;
	    this.v = v;
	    this.currentTimeMillis = System.currentTimeMillis();
	}
    }
}
