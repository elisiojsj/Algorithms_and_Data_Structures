
public class HeapSort {
	
	private int [] A;
	
	// constructor
	public HeapSort(int numbers[]) {
		this.A = numbers;
	}
	

	/*
	 * private method to calculate the index of the left node.
	 * @param i The index of the current node.
	 * @return The index of the left node.
	 */
	private int left(int i) {
		return 2*i+1;
	}
	
	/*
	 * private method to calculate the index of the right node.
	 * @param i The index of the current node.
	 * @return The index of the right node.
	 */
	private int right(int i) {
		return 2*i +2;
	}
	
	/*
	 * public method to maintain the max-heap property.
	 * @param i The node of the subtree to be max-heapified.
	 */
	public void maxHeapify(int i) {
		int l = left(i);
		int r = right(i);
		int largest = 0;
		
		if ((l<=(this.A.length-1)) && (this.A[l]>this.A[i])) {
			largest = l;
		}
		else largest = i;

		if ((r<=(this.A.length-1)) && (this.A[r]>this.A[largest])) {
			largest = r;
		}

		if (largest != i) {
			int a = this.A[i];
			this.A[i] = this.A[largest];
			this.A[largest] = a;
			maxHeapify(largest);
		}
	}
	
	/*
	 * public method to convert the array A into a max-heap. 
	 */
	public void buildMaxHeap() {
		for(int i=(Math.floorDiv(A.length, 2)-1); i>=0; i--) {
			
			maxHeapify(i);

			// debug
			System.out.println("node::["+i+"] " + A[i]);
			printHeap();
			System.out.println("----------------");
		}
	}
	
	/*
	 * public helper method to print the heap.
	 */
	public void printHeap() {
		for (int j=0; j<this.A.length; j++) {
			System.out.print("[" + A[j] + "]");
		}
		System.out.println();
	}
	
	
	/*
	 * public method main to test the implementation.
	 */
	public static void main (String args[]) {
		int [] ar = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
		HeapSort h=new HeapSort(ar);

		System.out.print("Original array: ");
		h.printHeap();
		System.out.println("----------------------------------\n");
		h.buildMaxHeap();
		System.out.print("\nMax-heap: ");
		h.printHeap();
	}
}
