package virendra.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Test {
	
	static String treeString = ""
			+ "(Level 1\r\n"
			+ "    (Level 1.1\r\n"
			+ "        (Level 1.1.1)\r\n"
			+ "        (Level 1.1.2\r\n"
			+ "            (Level 1.1.2.1)\r\n"
			+ "            (Level 1.1.2.2)\r\n"
			+ "            (Level 1.1.2.3)\r\n"
			+ "            (Level 1.1.2.4)\r\n"
			+ "        )\r\n"
			+ "        (Level 1.1.3)\r\n"
			+ "    )\r\n"
			+ "    (Level 1.2\r\n"
			+ "        (Level 1.2.1)\r\n"
			+ "        (Level 1.2.2)\r\n"
			+ "        (Level 1.2.3)\r\n"
			+ "    )\r\n"
			+ "    (Level 1.3)\r\n"
			+ "    (Level 1.4)\r\n"
			+ ")";

	public static void main(String[] args) {
		int a[] = {1 , 3,5,6};
		int b[] = {6,7,9};

		String[] nodes = treeString.split("\n");
		
		// Trim off whitespaces on all elements
		System.out.println("*************");
		for (int i = 0; i < nodes.length; i++) {
		    nodes[i] = nodes[i].trim();
		    System.out.println(nodes[i]);
		}
		System.out.println("*************");
		System.out.println(nodes);
	    System.out.println(getLevel(nodes,2));
	}
	
	private static String getLevel(String[] nodes, int level) {
		Map<Integer, ArrayList<String>> map = new HashMap<Integer,ArrayList<String>>();
		Stack<String> stack = new Stack<>();
		List<String> nodePaths = new ArrayList<>();
		Integer count =0;
		String str = "";
		
	    for (int i = 0; i < nodes.length; i++) {
	        if (nodes[i].startsWith("(") && !nodes[i].endsWith(")")) {
	            stack.push(nodes[i].substring(1));
	            ArrayList<String> list = new ArrayList<String>();
	            list.add(nodes[i].substring(1));
	            count = count +1;
	            map.put(count, list);
	            System.out.println(count +"  + "+nodes[i].substring(1));
	        }
	        else if (nodes[i].startsWith("(") && nodes[i].endsWith(")")) {
	            stack.push(nodes[i].substring(1, (nodes[i].length() - 1)));
	            String nodePath = "";
	            Iterator<String> iterator = stack.iterator();
	            while (iterator.hasNext()) {
	                String value = iterator.next();
	                nodePath += nodePath.equals("") ? value : "/" + value;
	            }
	            stack.pop();
	            ArrayList<String> list = map.get(count);
	            list.add(nodePath);
	            map.put(count,list);
	            nodePaths.add(nodePath);
	        }
	        else if (nodes[i].equals(")")) {
	            stack.pop();
	        }
	    }

	   nodePaths.forEach(System.out::println);
	   System.out.println("=====");


	   List<String> list = map.get(level);
	   String res = String.join("", list);
	   return res;
	}
	
}

