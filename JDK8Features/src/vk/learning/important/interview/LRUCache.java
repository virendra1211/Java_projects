package vk.learning.important.interview;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class LRUCache {
	private static final int MAX_CAPACITY = 100;
	private static final long EXPIRY_TIME = 15 * 60 * 1000; // 15 minutes
	private final Map<Integer, Node> map = new HashMap<>();
	private Node head, tail;
	private final ScheduledExecutorService executor;

	public LRUCache() {
		executor = Executors.newScheduledThreadPool(1);

		// Schedule cleanup task every 15 minute
		executor.scheduleAtFixedRate(() -> cleanUpExpiredEntries(), 15, 15, TimeUnit.MINUTES);
	}

	class Node {
		int key, val;
		long timestamp;
		Node prev, next;

		Node(int k, int v) {
			key = k;
			val = v;
			timestamp = System.currentTimeMillis();
		}
	}

	public int get(int key) {
		if (!map.containsKey(key))
			return -1;

		Node node = map.get(key);
		if (isExpired(node)) {
			removeNode(node);
			map.remove(key);
			return -1;
		}

		node.timestamp = System.currentTimeMillis();
		moveToHead(node);
		return node.val;
	}

	public void put(int key, int value) {
		if (map.containsKey(key)) {
			Node node = map.get(key);
			node.val = value;
			node.timestamp = System.currentTimeMillis();
			moveToHead(node);
		} else {
			if (map.size() >= MAX_CAPACITY) {
				// Remove least recently used
				map.remove(tail.key);
				removeNode(tail);
			}
			Node newNode = new Node(key, value);
			addNodeToHead(newNode);
			map.put(key, newNode);
		}
	}

	private boolean isExpired(Node node) {
		return System.currentTimeMillis() - node.timestamp >= EXPIRY_TIME;
	}

	private void moveToHead(Node node) {
		removeNode(node);
		addNodeToHead(node);
	}

	private void removeNode(Node node) {
		if (node.prev != null)
			node.prev.next = node.next;
		else
			head = node.next;

		if (node.next != null)
			node.next.prev = node.prev;
		else
			tail = node.prev;
	}

	private void addNodeToHead(Node node) {
		node.next = head;
		node.prev = null;

		if (head != null)
			head.prev = node;
		head = node;

		if (tail == null)
			tail = node;
	}

	private void cleanUpExpiredEntries() {
		Node current = tail;
		while (current != null && isExpired(current)) {
			map.remove(current.key);
			removeNode(current);
			current = tail;
		}
	}

	public static void main(String[] args) throws InterruptedException {
		LRUCache cache = new LRUCache();

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
}
