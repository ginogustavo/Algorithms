package queue;
import java.util.LinkedList;
import java.util.Queue;

public class Queue01 {
	public static void main(String[] args) {
		// PriorityQueue or LinkedList

		Queue<Integer> queue = new LinkedList<Integer>();

		for (int i = 0; i < 5; i++) {
			queue.add(i);
		}
		System.out.println(queue);

		// Remove element(HEAD) from queue.
		int removed = queue.remove(); // if queue is empty throws exception
		//if there are multiple objects, then the first is removed
		System.out.println("Head removed with remove: "+ removed);
		System.out.println(queue);

		
		int removed2 = queue.poll(); // return null if queue is empty
		System.out.println("Head removed with poll: "+ removed2);
		System.out.println(queue);

		
		
		// View the HEAD of the queue.
		System.out.println("current Head with peek: " + queue.peek());
		
		System.out.println(queue.isEmpty());
		System.out.println(queue.contains(3));

		
		
//		queue.poll();

		// enqueue or push
		// dequeue or pop
		// peek or front
		// is empty

	}
}
