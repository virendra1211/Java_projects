package virendra.interview;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

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
		List<String> list = new ArrayList<String>();
		for(int i=0;i<str.length();i++) {
			Character x = str.charAt(i);
			if (x == '(' || x == '[' || x == '{')
            {
				queue.push(x);
				//list.add(x.toString());
            }
			if (x == ')' || x == ']' || x == '}')
            {
            	queue.pop();
				//list.remove(list.size()-1);
            }
		}
		if(queue.size() ==0) {
		//if(list.size() ==0) {
			return true;
		}
		
		return false;
	}
}
