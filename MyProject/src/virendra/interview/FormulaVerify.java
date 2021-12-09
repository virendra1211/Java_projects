package virendra.interview;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class FormulaVerify {
	
	public static void main(String[] args) {
		String str= "[{}{()}]";
		str  = "(9*8)+(1-2)-[7/2]";
		//String str= "{{level 1 { sub} {sub2}}}";
		if(isValidate(str)) {
			System.out.println("Formula is correct");
		}else {
			System.out.println("Formula is Not correct");
		}
	}
	
	
	private static boolean isValidate(String str) {
		Deque<Character> deque = new ArrayDeque<>();
		for(int i=0;i<str.length();i++) {
			Character ch = str.charAt(i);
			if (ch == '(' || ch == '[' || ch == '{')
            {
				deque.push(ch);
				//list.add(x.toString());
            }else {
            	  if (!deque.isEmpty()
            	            && ((deque.peekFirst() == '{' && ch == '}')
            	            || (deque.peekFirst() == '[' && ch == ']')
            	            || (deque.peekFirst() == '(' && ch == ')'))) {
            	            deque.removeFirst();
            	        } else {
            	            return false;
            	        }
            }
			/*
			 * if (x == ')' || x == ']' || x == '}') {
			 * System.out.println("****** count** "+queue.size());
			 * 
			 * //queue.pop(); //list.remove(list.size()-1); }
			 */
		}
		if(deque.size() ==0) {
		//if(list.size() ==0) {
			return true;
		}
		
		return false;
	}
}
