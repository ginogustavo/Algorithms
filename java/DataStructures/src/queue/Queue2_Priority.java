package queue;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Queue2_Priority {
	public static void main(String[] args) {

		// Testing priority of Strings
		Queue<String> queue = new PriorityQueue<String>();
		queue.add("Mark");
		queue.add("Beny");
		queue.add("Petter");
		queue.add("Charles");
		System.out.println(queue);

		// Testing priority of Integers
		Queue<Integer> pQueue = new PriorityQueue<Integer>();
		pQueue.add(3);
		pQueue.add(1);
		pQueue.add(2);
		pQueue.add(4);
		pQueue.add(2);
		System.out.println(pQueue);

		// Iterate over elements of the queue.
		Iterator<Integer> iterator = pQueue.iterator();
		while (iterator.hasNext()) {
			int item = iterator.next();
			System.out.println("Customer # " + item);
		}

	}
}
