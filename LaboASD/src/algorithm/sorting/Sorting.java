package algorithm.sorting;

import java.util.Random;

// This class contains various sorting algorithms

public class Sorting {

	/**
	 * Sorts the specified array according to the ordering induced by the compareTo() method in &Theta;(n<sup>2</sup>)
	 * <p>
	 * Implements the selectionsort algorithm.
	 * <ul>
	 * <li> Worst/Average/Best-case cost: &Theta;(n<sup>2</sup>)
	 * </ul>
	 * @param A the array to be sorted
	 * @param <T> class of the object in the array
	 */
	public static <T extends Comparable<T>> void selectionsort(T A[]) {

		for(int i = 0; i < A.length - 1; i++) {
			int m = i;

			for(int j = i + 1; j < A.length; j++) {
				if(A[j].compareTo(A[m]) < 0)
					m = j;
			}

			if (m != i)
				swap(A, i, m);

		}

	}

	private static <T> void swap(T A[], int i, int j) {
		T tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}

	/**
	 * Sorts the specified array into ascending numerical order in &Theta;(n<sup>2</sup>)
	 * <p>
	 * Implements the selectionsort algorithm.
	 * <ul>
	 * <li> Worst/Average/Best-case cost: &Theta;(n<sup>2</sup>)
	 * </ul>
	 * @param A the array to be sorted
	 */
	public static void selectionsort(int A[]) {

		for(int i = 0; i < A.length - 1; i++) {
			int m = i;

			for(int j = i + 1; j < A.length ; j++) {

				if(A[j] < A[m])
					m = j;
			}

			if(m != i)
				swap(A, i, m);

		}

	}

	private static void swap(int A[], int i, int j) {
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}

	/**
	 * Sorts the specified array according to the ordering induced by the compareTo() method in O(n<sup>2</sup>)
	 * <p>
	 * Implements the insertionsort algorithm.
	 * <ul>
	 * <li> Worst/Average-case cost: &Theta;(n<sup>2</sup>)
	 * <li> Best-case cost: &Theta;(n)
	 * </ul>
	 * @param A the array to be sorted
	 * @param <T> class of the object in the array
	 */
	public static <T extends Comparable<T>> void insertionsort(T A[]) {

		for(int i = 1; i < A.length; i++) {
			int j = i;

			while( (j > 0) && (A[j].compareTo(A[j - 1]) < 0) )  {
				swap(A, j, j - 1);
				j--;
			}

		}

	}

	/**
	 * Sorts the specified array into ascending numerical order in O(n<sup>2</sup>)
	 * <p>
	 * Implements the insertionsort algorithm.
	 * <ul>
	 * <li> Worst/Average-case cost: &Theta;(n<sup>2</sup>)
	 * <li> Best-case cost: &Theta;(n)
	 * </ul>
	 * @param A the array to be sorted
	 */
	public static void insertionsort(int A[]) {

		for(int i = 1; i < A.length; i++) {
			int j = i;

			while( (j > 0) && (A[j] < A[j - 1]) ) {
				swap(A, j, j - 1);
				j = j - 1;
			}

		}

	}

	/**
	 * Sorts the specified array according to the ordering induced by the compareTo() method in &Theta;(nlogn)
	 * <P>
	 * Implements the mergesort algorithm.
	 * <ul>
	 * <li> Worst/Average/Best-case cost: &Theta;(nlogn)
	 * </ul>
	 * @param A the array to be sorted
	 * @param <T> class of the object in the array
	 */
	public static <T extends Comparable<T>> void mergesort(T A[]) {
		mergesort(A, 0, A.length - 1);
	}

	private static <T extends Comparable<T>> void mergesort(T A[], int p, int r) {

		if(p < r) {
			int q = p + ((r - p) / 2);
			mergesort(A, p, q);
			mergesort(A, q + 1, r);
			merge(A, p, q, r);
		}

	}

	private static <T> T[] genArray (int size) {
		@SuppressWarnings("unchecked")
		T[] data = (T[]) new Object[size];
		return data;
	}

	private static <T extends Comparable<T>> void merge(T A[], int p, int q, int r) {
		T B[] = genArray(r - p + 1);
		int i = p;
		int j = q + 1;
		int k = 0;

		while(i <= q && j <= r) {

			if(A[i].compareTo(A[j]) <= 0) {
				B[k] = A[i];
				i++;
			}
			else {
				B[k] = A[j];
				j++;
			}

			k++;
		}

		while(i <= q) {
			B[k] = A[i];
			k++;
			i++;
		}

		while(j <= r) {
			B[k] = A[j];
			k++;
			j++;
		}

		for(k = 0; k < (r - p + 1); k++)
			A[p + k] = B[k];

	}

	/**
	 * Sorts the specified array into ascending numerical order in &Theta;(nlogn)
	 * <p>
	 * Implements the mergesort algorithm.
	 * <ul>
	 * <li> Worst/Average/Best-case cost: &Theta;(nlogn)
	 * </ul>
	 * @param A the array to be sorted
	 */
	public static void mergesort(int A[]) {
		mergesort(A, 0, A.length - 1);
	}

	private static void mergesort(int A[], int p, int r) {

		if(p < r){
			int q = p + ((r - p) / 2);
			mergesort(A, p, q);
			mergesort(A, q + 1, r);
			merge(A, p, q, r);
		}

	}

	private static void merge(int A[], int p, int q, int r) {
		int B[] = new int[r - p + 1];
		int i = p;
		int j = q + 1;
		int k = 0;

		while(i <= q && j <= r) {

			if(A[i] <= A[j]) {
				B[k] = A[i];
				i++;
			}
			else {
				B[k] = A[j];
				j++;
			}

			k++;
		}

		while(i <= q) {
			B[k] = A[i];
			k++;
			i++;
		}

		while(j <= r) {
			B[k] = A[j];
			k++;
			j++;
		}

		for(k = 0; k < (r - p + 1); k++)
			A[p + k] = B[k];

	}

	/**
	 * Sorts the specified array according to the ordering induced by the compareTo() method in O(n<sup>2</sup>) and O(nlogn) on the average
	 * <p>
	 * Implements the quicksort algorithm.
	 * <ul>
	 * <li> Worst-case cost:  &Theta;(n<sup>2</sup>)
	 * <li> Average/Best-case cost: &Theta;(nlogn)
	 * </ul>
	 * @param A the array to be sorted
	 * @param <T> class of the object in the array
	 */
	public static <T extends Comparable<T>> void quicksort(T A[]) {
		quicksort(A, 0, A.length -1);
	}

	private static <T extends Comparable<T>> void quicksort(T A[], int p, int r) {

		if(p < r) {
			int q = partition(A, p, r);
			quicksort(A, p, q - 1);
			quicksort(A, q + 1, r);
		}

	}

	private static <T extends Comparable<T>> int partition (T A[], int p, int r) {
		Random random = new Random();
		int pivot = random.nextInt(r - p + 1) + p;
		swap(A, pivot, r);
		T x = A[r];
		int i = p - 1;

		for(int j = p; j <= r - 1; j++) {

			if(A[j].compareTo(x) <= 0) {
				swap(A, i + 1, j);
				i++;
			}

		}

		swap(A, i + 1, r);
		return i + 1;
	}

	/**
	 * Sorts the specified array into ascending numerical order in O(n<sup>2</sup>) and O(nlogn) on average
	 * <p>
	 * Implements the quicksort algorithm.
	 * <ul>
	 * <li> Worst-case cost:  &Theta;(n<sup>2</sup>)
	 * <li> Average/Best-case cost: &Theta;(nlogn)
	 * </ul>
	 * @param A the array to be sorted
	 */
	public static void quicksort(int A[]) {
		quicksort(A, 0, A.length - 1);
	}

	private static void quicksort(int A[], int p, int r) {
		if (p < r) {
			int q = partition(A, p, r);
			quicksort(A, p, q - 1);
			quicksort(A, q + 1, r);
		}
	}

	private static int partition(int A[], int p, int r) {
		Random random = new Random();
		int pivot = random.nextInt(r - p + 1) + p;
		swap(A, pivot, r);
		int x = A[r];
		int i = p - 1;

		for(int j = p; j <= r - 1; j++) {

			if(A[j] <= x) {
				swap(A, i + 1, j);
				i++;
			}

		}

		swap(A, i + 1, r);
		return i + 1;
	}

	/**
	 * Sorts the specified array into ascending numerical order in &Theta;(n+k)
	 * <p>
	 * Implements the countingsort algorithm.
	 * <ul>
	 * <li> Worst/Average/Best-case cost: &Theta;(n+k), where k = max(<code>A</code>)-min(<code>A</code>)+1
	 * </ul>
	 * @param A the array to be sorted
	 */
	public static void countingsort(int A[]) {
		int a = A[0];
		int b = A[0];

		for(int i = 1; i < A.length; i++)
		{
			if(a > A[i])
				a = A[i];

			if(b < A[i])
				b = A[i];
		}

		int k = b - a + 1;
		int B[] = new int[k];

		for(int i = 0; i < B.length; i++)
			B[i] = 0;

		for(int i = 0; i < A.length; i++)
			B[A[i] - a]++;

		int j = 0;
		for(int i = 0; i < B.length; i++) {

			while(B[i] > 0) {
				A[j] = i + a;
				B[i]--;
				j++;
			}

		}

	}

public static <T extends Comparable<T>> void heapsort(T A[]) {
		heapify(A,A.length - 1,0);

		for (int c = (A.length - 1); c > 0; c--) {
			T k = findmax(A);
			deletemax(A, c);
			A[c] = k;
		}

	}
	
	private static <T extends Comparable<T>> void heapify(T A[], int n, int i) {
		if (i >= n)
			return;
		heapify(A, n, left(i));
		heapify(A, n, right(i));
		fixheap(A, n, i);
	}
	
	private static int left(int i) {
		return ( 2*i + 1 );
	}

	private static int right(int i) {
		return ( 2*i + 2 );
	}
			
	private static <T extends Comparable<T>> void fixheap(T A[], int c, int i) {
		int l = left(i);
		int r = right(i);

		if (l > c)
			return;
		int max = l;
		if (r <= c && A[l].compareTo(A[r]) < 0)
			max = r;
		if (A[i].compareTo(A[max]) < 0) {
			swap(A, i, max);
			fixheap(A, c, max);
		}
	}
	
	private static <T extends Comparable<T>> T findmax(T A[]) {
		return A[0];
	}
	
	private static <T extends Comparable<T>> void deletemax(T A[], int c) {
		if (c <= 0)
			return;
		A[0] = A[c];
		c--;
		fixheap(A, c, 0);
	}		
					
}
