package org.test;

import java.util.HashMap;
import java.util.Map;

public class Snippet {
	
	public static void main(String[] args) {
		String s[] = {"ADD:i","SIZE:j"};
		System.out.println(solution(s));
	}
	
	@Override
	public boolean equals(Object obj) {
        return (this == obj);
    }
	public static String solution(String[] A) {
			StringBuilder sb = new StringBuilder();
			String[] tokens;
			final String ADD = "i";
			final String SIZE = "k";
			final String PRINT = "j";
			final String REMOVE = "l";
			Map<String, String> map = new HashMap<>();
	
			for (int i = 0; i < A.length; i++) {
				tokens = A[i].split(":");
				System.out.println(tokens.toString());
				switch (tokens[1]) {
				case ADD:
					map.put(tokens[0], tokens[1]);
					break;
				case PRINT:
					if (map.containsKey(tokens[0])) {
						sb.append(map.get(tokens[1]));
					} else {
						sb.append("-1");
					}
					sb.append(" ");
					break;
				case SIZE:
					sb.append(map.size()).append(" ");
					break;
				case REMOVE:
					map.remove(tokens[1]);
					break;
				}
	
			}
			return sb.toString();
		}
}

