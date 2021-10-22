package virendra.interview;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Virendra
 *
 * @param <E>
 */

public class StackUsingQueue<E> {

	Queue<E> queue = new LinkedList<E>();
	
	public static void main(String[] args) {
		StackUsingQueue<String> stack = new StackUsingQueue<>();
		stack.push("A"); stack.push("B"); stack.push("C"); stack.push("D"); 
		System.out.println("first element of stack : " + stack.pop());
		System.out.println("Second element of stack : " + stack.pop());
		//FIFO: 1 ,2 ,3 ,4 -> ou
	}
	
	public boolean push(E element) {
		int size = queue.size();
		
		queue.add(element);
		
		//leave current added element and add all previous element towards rear
		for (int i = 0; i < size; i++) {
			E data  = queue.remove();
			queue.add(data);
		}
		return true;
	}
	
	public E pop() {
		if (!queue.isEmpty()) {
			return queue.remove();
		} else {
			return null;
		}
	}
	

}
