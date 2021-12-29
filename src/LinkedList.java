public class LinkedList {

	/*
	 * static class for node element.
	 */
	static class Node {
		int key;
		Node next;
		Node prev;
		
		Node(int x){
			key = x;
			next = null;
			prev = null;
		}
	}
	
	// head node of the linked list
	private Node head;
	
	/*
	 * public method to insert a number in the list.
	 * @param k The number to be inserted.
	 */
	public void listInsert(int k) {
		Node nNode = new Node(k);
		nNode.next = head;
		
		if (head != null) {
			head.prev = nNode;
		}
		head = nNode;
		nNode.prev = null;
	}
	
	/*
	 * public method to search a key in the list. 
	 * @param k The key to be found.
	 * @return x The node with the corresponding key.
	 */
	public Node listSearch(int k) {
		Node x = head;
		while ((x != null) && (x.key != k)){
			x = x.next;
		}
		return x;
	}
	
	/*
	 * public method to delete a node in the list.
	 * @param x The node to be deleted.
	 */
	public void listDelete(Node x) {
		if (x.prev != null) {
			x.prev.next = x.next;
		}
		else head = x.next;
		if (x.next != null) {
			x.next.prev = x.prev;
		}
	}
		
	/*
	 * public helper method to print the linked list.
	 */
	public void listPrint() {
		Node x = head;
		while (x != null) {
			System.out.print("["+x.key+"]");
			x = x.next;
		}
		System.out.println();
	}

	/*
	 * public method main to test the implementation.
	 */
	public static void main(String[] args) {
		LinkedList l = new LinkedList();
		
		System.out.println("Add 5 and 6.");
		l.listInsert(5);
		l.listInsert(6);
		l.listPrint();
		System.out.println("\nAdd 0.");
		l.listInsert(0);
		l.listPrint();
		System.out.println("\nAdd 11, 12 and 14.");
		l.listInsert(11);
		l.listInsert(12);
		l.listInsert(14);
		l.listPrint();
		
		System.out.println("\nDelete 12 and 6.");
		l.listDelete(l.listSearch(12));
		l.listDelete(l.listSearch(6));
		l.listPrint();
	}
		
}
