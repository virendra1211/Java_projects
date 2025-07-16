package vk.learning.algo;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class GetMostPopulatContent_atlasian {

	private static class Content {
		String id;
		int popularity;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public int getPopularity() {
			return popularity;
		}

		public void setPopularity(int popularity) {
			this.popularity = popularity;
		}

		public long getTimestamp() {
			return timestamp;
		}

		public void setTimestamp(long timestamp) {
			this.timestamp = timestamp;
		}

		long timestamp;

		Content(String id, int popularity, long timestamp) {
			this.id = id;
			this.popularity = popularity;
			this.timestamp = timestamp;
		}
	}

	private final Map<String, Content> contentMap = new HashMap<>();
	private long time = 0;

	public void increment(String id) {
		time++;
		if (contentMap.containsKey(id)) {
			Content content = contentMap.get(id);
			content.popularity++;
			content.timestamp = time;
		} else {
			contentMap.put(id, new Content(id, 1, time));
		}
	}

	public void decrement(String id) {
		if (!contentMap.containsKey(id))
			return;

		time++;
		Content content = contentMap.get(id);
		content.popularity--;
		content.timestamp = time;

		if (content.popularity <= 0) {
			contentMap.remove(id);
		}
	}

	public String getMostPopularContent() {

		/*
		 * return contentMap.values().stream() .sorted(Comparator.comparingInt((Content
		 * c) -> c.popularity).reversed() .thenComparingLong(c -> -c.timestamp)) //
		 * morerecent wins tie .map(c -> c.id).findFirst().orElse(null);
		 */

		return contentMap.values().stream()
				.sorted(Comparator.comparing(Content::getPopularity).reversed()
						.thenComparing(Comparator.comparing(Content::getTimestamp).reversed()))
				.map(Content::getId).findFirst().orElse("Not Available");
	}

	// Test
	public static void main(String[] args) {
		GetMostPopulatContent_atlasian solution = new GetMostPopulatContent_atlasian();
		solution.increment("k1"); // k1 = 1
		solution.increment("k2"); // k2 = 1
		solution.increment("k3"); // k3 = 1
		solution.increment("k2"); // k2 = 2
		solution.increment("k3"); // k3 = 2
		System.out.println(solution.getMostPopularContent()); // Should print "k3"
	}
}
