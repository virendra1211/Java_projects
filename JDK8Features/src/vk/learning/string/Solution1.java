package vk.learning.string;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution1 {
	public static void main(String[] args) {
		Solution1 obj = new Solution1();
		int[] p1 = { 1, -2, -2 };
		int[] p2 = { 1, -2, 2 };

		int[] g1 = { 1, -1, 2 };
		int[] g2 = { 1, -1, -2 };
		System.out.println(obj.solution("CCD", g1, g2));
		/*
		 * System.out.println(obj.solution("ABB", p1, p2));
		 * 
		 * int[] k1 = { 2, -1, -4, -3, 3 }; int[] k2 = { 2, -2, 4, 1, -3 };
		 * 
		 * System.out.println(obj.solution("ABDCA", k1, k2));
		 */
	}

	public int solution(String S, int[] X, int[] Y) {
		int N = S.length();
		List<Point> points = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			int distSq = X[i] * X[i] + Y[i] * Y[i];
			points.add(new Point(distSq, S.charAt(i)));
		}

		// Sort by distance from origin
		points.sort(Comparator.comparingInt(p -> p.distSq));

		Set<Character> usedTags = new HashSet<>();
		int maxCount = 0;

		for (Point p : points) {
			if (!usedTags.contains(p.tag)) {
				usedTags.add(p.tag);
				maxCount++;
			} else {
				maxCount--;
			}
		}

		return maxCount;
	}

	static class Point {
		int distSq;
		char tag;

		Point(int distSq, char tag) {
			this.distSq = distSq;
			this.tag = tag;
		}
	}
}
