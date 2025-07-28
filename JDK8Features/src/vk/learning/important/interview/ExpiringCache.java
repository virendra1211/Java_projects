package vk.learning.important.interview;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExpiringCache<K, V> {
	private final ConcurrentHashMap<K, CacheEntry<V>> cache = new ConcurrentHashMap<>();
	private final ScheduledExecutorService cleaner = Executors.newSingleThreadScheduledExecutor();

	// Time unit in milliseconds
	public ExpiringCache(long cleanupIntervalMillis) {
		// Schedule asynchronous cleanup
		cleaner.scheduleAtFixedRate(this::cleanup, cleanupIntervalMillis, cleanupIntervalMillis,
				TimeUnit.MILLISECONDS);
	}

	public void put(K key, V value, long ttlMillis) {
		long expiryTime = System.currentTimeMillis() + ttlMillis;
		cache.put(key, new CacheEntry<>(value, expiryTime));
	}

	public V get(K key) {
		CacheEntry<V> entry = cache.get(key);
		if (entry == null || entry.isExpired()) {
			cache.remove(key); // optional eager cleanup
			return null;
		}
		return entry.value;
	}

	private void cleanup() {
		long now = System.currentTimeMillis();
		for (Map.Entry<K, CacheEntry<V>> entry : cache.entrySet()) {
			if (entry.getValue().expiryTime < now) {
				cache.remove(entry.getKey());
			}
		}
	}

	public void shutdown() {
		cleaner.shutdown();
	}

	private static class CacheEntry<V> {
		final V value;
		final long expiryTime;

		CacheEntry(V value, long expiryTime) {
			this.value = value;
			this.expiryTime = expiryTime;
		}

		boolean isExpired() {
			return System.currentTimeMillis() > expiryTime;
		}
	}

	// Demo
	public static void main(String[] args) throws InterruptedException {
		ExpiringCache<String, String> cache = new ExpiringCache<>(2000);

		cache.put("key1", "value1", 3000); // expires in 3 seconds
		System.out.println("Initial: " + cache.get("key1")); // value1

		Thread.sleep(4000);
		System.out.println("After 4s: " + cache.get("key1")); // null (expired)

		cache.shutdown(); // stop background cleanup
	}
}
