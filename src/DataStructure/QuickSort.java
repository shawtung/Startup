package DataStructure;

public class QuickSort {
	private static void swap(int[] A, int i, int j) {
		int k = A[i];
		A[i] = A[j];
		A[j] = k;
	}

	private static void displayArray(int[] A) {
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}

	protected static void sort(int[] A, int start_, int end_) {
		int i = start_, j = end_;
		int key = A[start_];
		while (i < j) {
			while (i < j) {
				if (A[j] <= key) {
					swap(A, i, j);
					break;
				}
				j--;
			}
			while ((i < j)) {
				if (A[i] >= key) {
					swap(A, i, j);
					break;
				}
				i++;
			}
		}
		if (start_ != i)
			sort(A, start_, j - 1);
		if (j != end_)
			sort(A, i + 1, end_);
	}

	

	public static int[] quickSort(int[] t) {
		sort(t, 0, t.length - 1);
		return t;
	}

	
	private static int[] A = { 45, 38, 65, 97, 76, 13, 27, 49 };
	
	
	
	public static void main(String[] args) {
		displayArray(A);
		quickSort(A);
		displayArray(A);
	}
}
