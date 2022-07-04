package student1_Session1;

import java.util.Arrays;

public class Sorts {

	public static void main(String[] args) {
		Sorts sort = new Sorts();
		
		
		int[] arrayToCheck = {6, 1, 3, 2, 5};
		
		System.out.println("Inital array: " + Arrays.toString(arrayToCheck));
		
		System.out.println("Bubble sort: " + Arrays.toString(sort.bubbleSort(Arrays.copyOf(arrayToCheck, arrayToCheck.length))));
		
		System.out.println("Selection sort: " + Arrays.toString(sort.selectionSort(Arrays.copyOf(arrayToCheck, arrayToCheck.length))));
		
		//System.out.println("Insertion sort: " + Arrays.toString(sort.insertionSort(Arrays.copyOf(arrayToCheck, arrayToCheck.length))));
		
		System.out.println("Simple sort: " + Arrays.toString(sort.simpleSort(Arrays.copyOf(arrayToCheck, arrayToCheck.length))));
		
		System.out.println("Quick sort: " + Arrays.toString(sort.quickSort(Arrays.copyOf(arrayToCheck, arrayToCheck.length))));
		
		//System.out.println("Quick sort1: " + Arrays.toString(sort.quickSort1(Arrays.copyOf(arrayToCheck, arrayToCheck.length))));
		
		Radix.radixsort(arrayToCheck, arrayToCheck.length);
		System.out.println("radix array: " + Arrays.toString(arrayToCheck));
	}

	class Radix {

		// A utility function to get maximum value in arr[]
		static int getMax(int arr[], int n)
		{
			int mx = arr[0];
			for (int i = 1; i < n; i++)
				if (arr[i] > mx)
					mx = arr[i];
			return mx;
		}

		// A function to do counting sort of arr[] according to
		// the digit represented by exp.
		static void countSort(int arr[], int n, int exp)
		{
			int output[] = new int[n]; // output array
			int i;
			int count[] = new int[10];
			Arrays.fill(count, 0);

			// Store count of occurrences in count[]
			for (i = 0; i < n; i++)
				count[(arr[i] / exp) % 10]++;

			// Change count[i] so that count[i] now contains
			// actual position of this digit in output[]
			for (i = 1; i < 10; i++)
				count[i] += count[i - 1];

			// Build the output array
			for (i = n - 1; i >= 0; i--) {
				output[count[(arr[i] / exp) % 10] - 1] = arr[i];
				count[(arr[i] / exp) % 10]--;
			}

			// Copy the output array to arr[], so that arr[] now
			// contains sorted numbers according to current digit
			for (i = 0; i < n; i++)
				arr[i] = output[i];
		}

		// The main function to that sorts arr[] of size n using
		// Radix Sort
		static void radixsort(int arr[], int n)
		{
			// Find the maximum number to know number of digits
			int m = getMax(arr, n);

			// Do counting sort for every digit. Note that
			// instead of passing digit number, exp is passed.
			// exp is 10^i where i is current digit number
			for (int exp = 1; m / exp > 0; exp *= 10)
				countSort(arr, n, exp);
		}

		// A utility function to print an array
		static void print(int arr[], int n)
		{
			for (int i = 0; i < n; i++)
				System.out.print(arr[i] + " ");
		}

		/*Driver Code*/
		public static void main(String[] args)
		{
			int arr[] = { 170, 45, 75, 90, 802, 24, 2, 66 };
			int n = arr.length;
				
			// Function Call
			radixsort(arr, n);
			print(arr, n);
		}
	}
	/* This code is contributed by Devesh Agrawal */

	
	/**
	 * A simple check to see if an array is sorted
	 * @param arrayToCheck The array to check
	 * @return True if sorted, false otherwise
	 */
	private boolean isSorted(int[] arrayToCheck) {
		for(int i = 1; i < arrayToCheck.length; i++) {
			if(arrayToCheck[i-1] > arrayToCheck[i]) {
				return false;
			}
		}
		
		return true;
	}
	
	public int[] bubbleSort(int[] arrayToSort){
		if(arrayToSort == null || arrayToSort.length == 0) {
			return arrayToSort;
		}
		int interation = 0;
		while(!isSorted(arrayToSort)) {
			int temp;
			for(int i = 1; i < arrayToSort.length - interation; i++) {
				if(arrayToSort[i-1] > arrayToSort[i]) {
					temp = arrayToSort[i-1];
					arrayToSort[i-1] = arrayToSort[i];
					arrayToSort[i] = temp;
				}
			}
		}
		
		
		return arrayToSort;	
	}
	
	public int[] selectionSort(int[] arrayToSort){
		if(arrayToSort == null || arrayToSort.length == 0) {
			return arrayToSort;
		}
		
		//For l(selectedElement), ...., right-1 repeat
		for(int selectedElement = 0; selectedElement < arrayToSort.length; selectedElement++) {
			int leastPosition = selectedElement;
			
			//Set p(leastPosition) such that a[p] (arrayToSort[leastPosition])
			//is the least of a[l...right] (arrayToSort[selectedElement...right]
			for(int i = selectedElement; i < arrayToSort.length; i++) {
				if(arrayToSort[leastPosition] > arrayToSort[i]) {
					leastPosition = i;
				}
			}
			
			//If p != l (arrayToSort[selectedElement] != arrayToSort[leastPosition]),
			//swap a[p] and a[l] (arrayToSort[selectedElement] and arrayToSort[leastPosition])
			if(selectedElement != leastPosition) {
				int temp = arrayToSort[selectedElement];
				arrayToSort[selectedElement] = arrayToSort[leastPosition];
				arrayToSort[leastPosition] = temp;
			}
		}
		return arrayToSort;	
	}
	
	public int[] insertionSort(int[] arrayToSort){
		if(arrayToSort == null || arrayToSort.length == 0) {
			return arrayToSort;
		}
		
		for(int selectedElement = 0; selectedElement < arrayToSort.length; selectedElement++) {
			
			int val = arrayToSort[selectedElement];
			
			for(int i = 0; i < selectedElement; i++) {
				if(val < arrayToSort[i]) {
					expanedArray(arrayToSort, selectedElement, i, val);
				}
			}
			
		}
		
		
		return arrayToSort;	
	}
	
	/**
	 * Simple function to add a int to an array
	 * @param arrayToModify The array that is being modified
	 * @param moveFrom The position that numberToAdd will be placed
	 * @param moveTo The end position that moving will end
	 * @param numberToAdd The number to add
	 */
	private void expanedArray(int[] arrayToModify, int moveFrom, int moveTo, int numberToAdd) {
		//Bugged :(
		for(int i = moveFrom-1; i >= moveTo; i--) {
			arrayToModify[i+1] = arrayToModify[i];
		}
		arrayToModify[moveTo] = numberToAdd;
	}
	
	//https://www.geeksforgeeks.org/quick-sort/
	//Implemented quick sort from pseudo
	public int[] quickSort(int[] arrayToSort){
		quickSort(arrayToSort,0,arrayToSort.length-1);
		return arrayToSort;	
	}
	
	/**
	 * 
	 * @param arrayToSort
	 * @param low The low position
	 * @param high
	 */
	private void quickSort(int[] arrayToSort, int low, int high) {
		//Quick sort works using recursive
		if(low < high) {
			int partion = partition(arrayToSort,low ,high);
			quickSort(arrayToSort, low, partion-1);
			quickSort(arrayToSort, partion+1, high);
		}
	}
	
	private int partition(int[] arrayToSort, int low, int high) {
		int pivot = arrayToSort[low];
		
		//The Index of the smaller element
		int i = low-1;
		
		for(int j = low; j <= high-1; j++) {
			//If the element is smaller then the pivot, then swap them.
			if(arrayToSort[j] < pivot) {
				//Move the smaller element index
				i++;
				
				//And swap them
				int temp = arrayToSort[i];
				arrayToSort[i] = arrayToSort[j];
				arrayToSort[j] = temp;
			}
		}
		
		int temp = arrayToSort[i+1];
		arrayToSort[i+1] = arrayToSort[high];
		arrayToSort[i+1] = temp;
		
		return i+1;
	}
	
	
	//https://www.geeksforgeeks.org/quick-sort/
		//Implemented quick sort from pseudo
		public int[] quickSort1(int[] arrayToSort){
			quickSort1(arrayToSort,0,arrayToSort.length-1);
			return arrayToSort;	
		}
		
		/**
		 * 
		 * @param arrayToSort
		 * @param low The low position
		 * @param high
		 */
		private void quickSort1(int[] arrayToSort, int low, int high) {
			//Quick sort works using recursive
			if(low < high) {
				int partion = partition1(arrayToSort,low ,high);
				quickSort1(arrayToSort, low, partion-1);
				quickSort1(arrayToSort, partion+1, high);
			}
		}
		
		private int partition1(int[] arrayToSort, int low, int high) {
			int pivot = arrayToSort[low];
			
			//The Index of the smaller element
			int i = low-1;
			
			for(int j = high; j <= low-1; j--) {
				//If the element is smaller then the pivot, then swap them.
				if(arrayToSort[j] > pivot) {
					//Move the smaller element index
					i--;
					
					//And swap them
					int temp = arrayToSort[i];
					arrayToSort[i] = arrayToSort[j];
					arrayToSort[j] = temp;
				}
			}
			
			int temp = arrayToSort[i+1];
			arrayToSort[i+1] = arrayToSort[high];
			arrayToSort[i+1] = temp;
			
			return i+1;
		}
	
	
	//https://courses.cs.vt.edu/~csonline/Algorithms/Lessons/SimpleSort/index.html
	public int[] simpleSort(int[] arrayToSort){
		int[] unsortedArray = Arrays.copyOf(arrayToSort, arrayToSort.length);
		
		int smallestNumber;
		for(int sortedPosition = 0; sortedPosition < arrayToSort.length; sortedPosition++) {
			smallestNumber = Integer.MAX_VALUE;
			int position = -1;
			for(int i = 0; i < arrayToSort.length; i++) {
				if(smallestNumber > unsortedArray[i]) {
					smallestNumber = unsortedArray[i];
					position = i;
				}
			}
			
			arrayToSort[sortedPosition] = smallestNumber;
			unsortedArray[position] = Integer.MAX_VALUE;
		}
		
		return arrayToSort;	
	}
}
