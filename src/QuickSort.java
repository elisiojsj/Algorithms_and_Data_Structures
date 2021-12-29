public class QuickSort {
	
	private int A[];

	// constructor
	public QuickSort(int arr[]) {
		this.A = arr;
	}

	/*
	 * public method for the quick sort algorithm.
	 * @param p The minimum index of the array.
	 * @param r The maximum index of the array.
	 */
	public void quicksort(int p, int r) {
		if (p<r) {
			int q = partition(p, r);
			quicksort(p, q-1);
			quicksort(q+1, r);
		}
	}
	
	/*
	 * public method for partition of the quick sort algorithm.
	 * @param p The minimum index of the array.
	 * @param r The maximum index of the array.
	 * @return i+1 The middle of the array.
	 */
	public int partition(int p, int r) {
		int x = this.A[r];
		int i = p-1;

		//debug
		System.out.println("Pivot="+x);
		printArray(p, r);
		
		for (int j=p; j<=(r-1); j++) {
			if (this.A[j] <= x) {
				i++;
				int t = this.A[i];
				this.A[i] = this.A[j];
				this.A[j] = t;
			}
		}
		int t = this.A[i+1];
		this.A[i+1] = this.A[r];
		this.A[r] = t;
		
		//debug
		System.out.println("Result:");
		printArray(p, r);
		System.out.println("-------------");

		return i+1;
	}
	
	/*
	 * public helper method to print the array.
	 */
	public void printArray(int a, int b) {
		for (int j=a; j<=b; j++) {
			System.out.print("[" + this.A[j] + "]");
		}
		System.out.println();
	}
	
	/*
	 * public main method to test the algorithm.
	 */
	public static void main (String args[]) {
		int [] ar = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
		QuickSort q=new QuickSort(ar);

		System.out.print("The original array: ");
		q.printArray(0, ar.length-1);
		System.out.println("----------------------");

		q.quicksort(0, ar.length-1);
		System.out.print("The sorted array: ");
		q.printArray(0, ar.length-1);
	}
	
	
}
