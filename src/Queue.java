
public class Queue {
	
	final int queueSize = 10;
	private int [] Q = new int[queueSize];
	private int tail = 0;
	private int head = 0;

	// constructor
	public Queue() {
		tail = 0;
		head = 0;
	}
	
	
	/*
	 * public method to enqueue number.
	 * @param x The number to be enqueued.
	 * @return false If the queue is full.
	 * @return true If the queue was successful.
	 */
	public boolean enqueue(int x) {
		// check for full queue, overflow
		if (head == tail+1) {
			System.out.println("Queue is full!");
			return false;
		}

		Q[tail] = x;
		if (tail == (Q.length-1)) {
			tail = 0;
		}
		else tail = tail + 1;
		return true;
	}
	
	/*
	 * public method to dequeue. 
	 * @return x The number dequeued.
	 */
	public int dequeue() {
		//check for empty queue, underflow
		if (head == tail) {
			System.out.println("Queue is empty!");
			return 0;
		}
		
		// queue is not empty
		int x = Q[head];
		Q[head] = 0; //this is just for debugging purposes
		if (head == (Q.length - 1)) {
			head = 0;
		}
		else head = head + 1;
		return x;
	}
	
	/*
	 * public helper method to print the queue for dbg purposes.
	 */
	public void printQueue() {

		for(int i=0; i<Q.length; i++) {
			System.out.print("["+Q[i]+"]");
		}
		System.out.println("\tQ.head="+head+"  Q.tail="+tail);
	}
	
	/*
	 * public main metho to test the queue.
	 */
	public static void main(String[] args) {

		Queue q = new Queue();
		
		System.out.println("Empty queue");
		q.printQueue();
		
		System.out.println("\nQueue 5");
		q.enqueue(5);
		q.printQueue();
		System.out.println("\nQueue 8");
		q.enqueue(8);
		q.printQueue();
		System.out.println("\nQueue 11");
		q.enqueue(11);
		q.printQueue();
		
		System.out.println("\nDequeue: " + q.dequeue());
		q.printQueue();
		
		System.out.println("\nQueue 15, 16, 17, 18, 19, 20");
		q.enqueue(15);
		q.enqueue(16);
		q.enqueue(17);
		q.enqueue(18);
		q.enqueue(19);
		q.enqueue(20);
		q.printQueue();
		System.out.println("\nQueue 21");
		q.enqueue(21);
		q.printQueue();
		System.out.println("\nQueue 22");
		q.enqueue(22);
		q.printQueue();
		System.out.println("\nQueue 23");
		q.enqueue(23);
		q.printQueue();
		
		
		System.out.println("\nDequeue: " + q.dequeue());
		q.printQueue();
		System.out.println("\nQueue 25");
		q.enqueue(25);
		q.printQueue();
		System.out.println("\nQueue 26");
		q.enqueue(26);
		q.printQueue();
	}
}
