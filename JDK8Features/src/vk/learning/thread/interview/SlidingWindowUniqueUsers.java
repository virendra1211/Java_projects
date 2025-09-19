package vk.learning.thread.interview;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class SlidingWindowUniqueUsers {
	long windowSize = 10 * 60 * 1000; // 10 min
	Map<String, Integer> userCount = new HashMap<String, Integer>();
	Deque<Event> window = new ArrayDeque<>();

	public static void main(String[] args) throws InterruptedException {
		SlidingWindowUniqueUsers tracker = new SlidingWindowUniqueUsers();

		long now = System.currentTimeMillis();

		tracker.addEvent("user1", now);
		tracker.addEvent("user2", now + 1000);
		// Thread.sleep(11100);
		tracker.addEvent("user1", now + 2000);
		tracker.addEvent("user3", now + 3000);
		// Add something after 11 minutes -> should evict earlier ones
		tracker.addEvent("user4", System.currentTimeMillis() + (11 * 60 * 1000));

		System.out.println("Unique users in last 10 min: " + tracker.getUniqueUsers()); // 3
	}

	public int getUniqueUsers() {
		return userCount.size();
	}

	private void addEvent(String userId, long timeStamp) {

		while (!window.isEmpty() && window.peekFirst().timeStamp <= (timeStamp - windowSize)) {
			Event old = window.pollFirst();
			userCount.put(old.user, userCount.get(old.user) - 1);
			if (userCount.get(old.user) == 0) {
				userCount.remove(old.user);
			}
		}

		window.offerLast(new Event(userId, timeStamp));
		userCount.put(userId, userCount.getOrDefault(userId, 0) + 1);
	}

	static class Event {
		private String user;
		private long timeStamp;

		Event(String user, long timeStamp) {
			this.user = user;
			this.timeStamp = timeStamp;
		}
	}

}
