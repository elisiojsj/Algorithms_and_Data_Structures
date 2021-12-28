
public class InsertionSort {

	/*
	 * public method insertion sort algorithm implementation.
	 * @param A The array to be sorted.
	 */
	public void insertionSort(int A[]) {
		  for (int j = 1; j < A.length; ++j) {
		      int key = A[j];
		      int i = j - 1;
		      while (i >= 0 && A[i] > key) {
		           A[i + 1] = A[i];
		           i = i - 1;
		      }
		      A[i + 1] = key;
		   }
		}
	

	/*
	 * public main method to test the algorithm.
	 */
	public static void main (String args[]) {

		InsertionSort isort=new InsertionSort();
		int [] ar = {20, 14, 9, 11, 18, 5, 12};
		System.out.print("Original array: ");
		for (int i = 0 ; i < ar.length ; i++) {
			System.out.print(ar[i]+" ");
		}

		isort.insertionSort(ar);

		System.out.print("\nSorted array: ");
		for (int i = 0 ; i < ar.length ; i++) {
			System.out.print(ar[i]+" ");
		}
	}
	
}
