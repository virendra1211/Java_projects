package vk.learning.string;

class Solution {
	public static void main(String[] args) {
		Solution obj = new Solution();
		System.out.println(obj.solution("A2Le", "2pL1"));
		/*
		 * System.out.println(obj.solution("a10", "10a"));
		 * System.out.println(obj.solution("ba1", "1Ad"));
		 * System.out.println(obj.solution("3x2x", "8"));
		 */
	}

	public boolean solution(String S, String T) {
		return match(S, T, 0, 0, 0, 0);
	}

	private boolean match(String S, String T, int i, int j, int skipS, int skipT) {
		int n = S.length(), m = T.length();

		// Base case: both strings are done
		if (i == n && j == m)
			return skipS == 0 && skipT == 0;

		// If S has remaining skip characters
		if (skipS > 0) {
			if (i < n)
				return match(S, T, i + 1, j, skipS - 1, skipT);
			return false;
		}

		// If T has remaining skip characters
		if (skipT > 0) {
			if (j < m)
				return match(S, T, i, j + 1, skipS, skipT - 1);
			return false;
		}

		// If S has a digit (wildcard skip)
		if (i < n && Character.isDigit(S.charAt(i))) {
			int val = 0;
			for (int k = i; k < n && Character.isDigit(S.charAt(k)); k++) {
				val = val * 10 + (S.charAt(k) - '0');
				if (match(S, T, k + 1, j, val, skipT))
					return true;
			}
			return false;
		}

		// If T has a digit (wildcard skip)
		if (j < m && Character.isDigit(T.charAt(j))) {
			int val = 0;
			for (int k = j; k < m && Character.isDigit(T.charAt(k)); k++) {
				val = val * 10 + (T.charAt(k) - '0');
				if (match(S, T, i, k + 1, skipS, val))
					return true;
			}
			return false;
		}

		// Match letters
		if (i < n && j < m && S.charAt(i) == T.charAt(j)) {
			return match(S, T, i + 1, j + 1, skipS, skipT);
		}

		return false;
	}
}
