
public class MergeSort {
	// variable to select the version with sentinel
	final boolean withSentinel = false;
	
	/*
	 * public method to recursively divide the array, call merge sort algorithm 
	 * and merge the subarrays.
	 * @param A The array to be sorted.
	 * @param p The lower index.
	 * @param r The upper index.
	 */
	public void mergeSort(int A[], int p, int r) {
        if (p < r) {
                int q = Math.floorDiv(p+r, 2);
                mergeSort(A, p, q);
                mergeSort(A, q + 1, r);

                // choose the version with or without sentinels
                if(withSentinel) {
					merge(A, p, q, r);
                }
                else {
					mergeNoSentinels(A, p, q, r);
                }
          }
	}
	
	/*
	 * private method to sort and merge a subarray using sentinels to simplify
	 * the code according to the book.
	 * @param A The array to be merged.
	 * @param p The lower index.
	 * @param q The middle index.
	 * @param r The upper index.
	 */
	private void merge(int A[], int p, int q, int r) {
		int n1 = q - p +1;
		int n2 = r - q;
		
		int [] L = new int[n1+1];
		int [] R = new int[n2+1];
		
		int i, j = 0;
		
		for (i=0; i<n1; i++) {
			L[i] = A[p + i];
		}
		for (j=0; j<n2; j++) {
			R[j] = A[q + j +1];
		}

		L[n1] = 2147483647; // sentinel - highest positive int possible
		R[n2] = 2147483647; // sentinel - highest positive int possible
		
		// debug
		System.out.println("-----------------------");
		System.out.println("p:"+ p+ "  q:"+ q  + "  r:"+ r);
		System.out.println("n1:"+ n1+ "  n2:"+ n2);
		System.out.print("R: ");
		printArray(R);
		System.out.print("L: ");
		printArray(L);
		
		i = 0;
		j = 0;

		for(int k=p; k<=r; k++) {
			if (L[i] <= R[j]) {
				A[k] = L[i];
				i++;
			}
			else {
				A[k] = R[j];
				j++;
			}
		}
	}

	
	
	/*
	 * private method to sort and merge a subarray.
	 * @param A The array to be merged.
	 * @param p The lower index.
	 * @param q The middle index.
	 * @param r The upper index.
	 */
	private void mergeNoSentinels(int A[], int p, int q, int r) {
		int n1 = q - p +1;
		int n2 = r - q;
		
		int [] L = new int[n1];
		int [] R = new int[n2];
		
		int i, j = 0;
		
		for (i=0; i<n1; i++) {
			L[i] = A[p + i];
		}
		for (j=0; j<n2; j++) {
			R[j] = A[q + j +1];
		}
		
		// debug
		System.out.println("-----------------------");
		System.out.println("p:"+ p+ "  q:"+ q  + "  r:"+ r);
		System.out.println("n1:"+ n1+ "  n2:"+ n2);
		System.out.print("R: ");
		printArray(R);
		System.out.print("L: ");
		printArray(L);
		
		i = 0;
		j = 0;
	
		int k = p;

	    while ((i < n1) && (j < n2)) {
			if (L[i] <= R[j]) {
				A[k] = L[i];
				i++;
			}
			else {
				A[k] = R[j];
				j++;
			}
	        k++;
		}
	    while (i < n1) {
	        A[k] = L[i];
	        i++;
	        k++;
	    }
		while (j < n2) {
			A[k] = R[j];
			j++;
			k++;
	    }
	}

	/*
	 * private helper function to print the array of numbers
	 * @param arr The array to be printed.
	 */
	private static void printArray(int arr[]) {
		for (int i = 0 ; i < arr.length ; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	/*
	 * public main method to test the implementation.
	 */
	public static void main (String args[]) {

		MergeSort msort=new MergeSort();
		int [] ar = {20, 14, 55, 9, 3, 88, 11, 18, 5, 12, 30, 1, 90, 4};

		System.out.print("Original array: ");
		printArray(ar);
		System.out.println("------------------------------");

		msort.mergeSort(ar, 0, ar.length-1);

		System.out.println("\n------------------------------");
		System.out.print("Sorted array: ");
		printArray(ar);
	}
}
