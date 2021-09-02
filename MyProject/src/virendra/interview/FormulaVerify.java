package virendra.interview;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

public class FormulaVerify {
	
	public static void main(String[] args) {
		String str= "[{}{()}]";
		if(isValidate(str)) {
			System.out.println("Formula is correct");
		}else {
			System.out.println("Formula is Not correct");
		}
	}
	
	
	private static boolean isValidate(String str) {
		Deque<Character> queue = new ArrayDeque<>();
		
		for(int i=0;i<str.length();i++) {
			Character x = str.charAt(i);
			if (x == '(' || x == '[' || x == '{')
            {
				queue.push(x);
            }
			if (x == ')' || x == ']' || x == '}')
            {
            	queue.pop();
            }
		}
		if(queue.size() ==0) {
			return true;
		}
		
		return false;
	}
}
