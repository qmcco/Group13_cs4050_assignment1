/**
 *
 * @author Ouda
 */

//importing the libraries that will be needed in this program

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import java.util.List;


//The class that has all the sorts in it
public class SortShow extends JPanel { 

	
		// An array to hold the lines_lengths to be sorted
		public int[] lines_lengths;
		//The amount of lines needed
		public final int total_number_of_lines = 256;
		 // An array to holds the scrambled lines_lengths
		public int[] scramble_lines;
		//A temp Array that is used later for sorts
		public int[] tempArray;
		
		//the default constructor for the SortShow class
		public SortShow(){
			//assigning the size for the lines_lengths below
			lines_lengths = new int[total_number_of_lines];
			for(int i = 0; i < total_number_of_lines; i++) 
				lines_lengths[i] =  i+5;
			
		}
		

		//A method that scrambles the lines
		public void scramble_the_lines(){
			//A random generator
			Random num = new Random(); 
			//Randomly switching the lines
			for(int i = 0; i < total_number_of_lines; i++){
				//getting a random number using the nextInt method (a number between 0 to i + 1)
				int j = num.nextInt(i + 1); 
				//swapping The element at i and j 
				swap(i, j);
			}
			//assigning the size for the scramble_lines below
			scramble_lines = new int[total_number_of_lines];
			//copying the now scrambled lines_lengths array into the scramble_lines array 
			//to store for reuse for other sort methods
			//so that all sort methods will use the same scrambled lines for fair comparison 
			for (int i = 0; i < total_number_of_lines; i++)
			{
				scramble_lines[i] = lines_lengths[i];
			}
			//Drawing the now scrambled lines_lengths
			paintComponent(this.getGraphics());
		}
		
		//Swapping method that swaps two elements in the lines_lengths array
		public void swap(int i, int j){
			//storing the i element in lines_lengths in temp
			int temp = lines_lengths[i];
			//giving i element in lines_lengths the value of j element in lines_lengths
			lines_lengths[i] = lines_lengths[j];
			//giving j element in lines_lengths the value of temp
			lines_lengths[j] = temp;
		}
		
		//The selectionSort method
		public void SelectionSort(int delayTime){
			//getting the date and time when the selection sort starts
			Calendar start = Calendar.getInstance();
			//Using the selection sort to lines_lengths sort the array

			//You need to complete this part.
			int n = lines_lengths.length;

			// Using Selection Sort algorithm
			for (int i = 0; i < n - 1; i++) {
				int minIndex = getIndexOfSmallest(i, n - 1); // Find the smallest element in the remaining array

				// Swap the found minimum element with the first element of the unsorted part
				if (minIndex != i) {
					int temp = lines_lengths[i];
					lines_lengths[i] = lines_lengths[minIndex];
					lines_lengths[minIndex] = temp;
					//paintComponent(this.getGraphics());
					//delay(delayTime);
				}

				paintComponent(this.getGraphics());
				delay(delayTime);
			}

			//getting the date and time when the selection sort ends
			Calendar end = Calendar.getInstance();
			//getting the time it took for the selection sort to execute 
			//subtracting the end time with the start time
	        SortGUI.selectionTime = end.getTime().getTime() - start.getTime().getTime();
		}
		
		//this method gets the smallest element in the array of lines_lengths
		public int getIndexOfSmallest(int first, int last){

			//You need to complete this part.
			int minIndex = first;

			for (int i = first + 1; i <= last; i++) {
				if (lines_lengths[i] < lines_lengths[minIndex]) {
					minIndex = i;
				}
			}
			return minIndex;
		}

	public void BubbleSort(int delayTime) {
		Calendar start = Calendar.getInstance();

		int n = lines_lengths.length;

		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (lines_lengths[j] > lines_lengths[j + 1]) {
					int temp = lines_lengths[j];
					lines_lengths[j] = lines_lengths[j + 1];
					lines_lengths[j + 1] = temp;
//					paintComponent(this.getGraphics());
//					delay(delayTime);
				}
			}

			// Force repaint after each iteration for visualization
			paintComponent(this.getGraphics());
			delay(delayTime);
		}

		Calendar end = Calendar.getInstance();
		SortGUI.bubbleTime = end.getTime().getTime() - start.getTime().getTime();

	}


	public void InsertionSort(int delayTime) {
		// Getting the start time
		Calendar start = Calendar.getInstance();

		int n = lines_lengths.length;

		for (int i = 1; i < n; i++) {
			int key = lines_lengths[i];
			int j = i - 1;

			// Move elements of lines_lengths[0..i-1] that are greater than key
			// one position ahead of their current position
			while (j >= 0 && lines_lengths[j] > key) {
				lines_lengths[j + 1] = lines_lengths[j];
				j--;
//				paintComponent(this.getGraphics());
//				delay(delayTime);

				// Force repaint after each shift for visualization

			}

			// Place key in its correct position
			lines_lengths[j + 1] = key;
			paintComponent(this.getGraphics());
			delay(delayTime);
		}

		// Getting the end time
		Calendar end = Calendar.getInstance();
		SortGUI.insertionTime = end.getTime().getTime() - start.getTime().getTime();

	}


	///////////////////////////////////////////////////////////////////////////////////
		
		//recursive merge sort method
		public void R_MergeSort(int delayTime){
			//getting the date and time when the recursive merge sort starts
			Calendar start = Calendar.getInstance();
			//assigning the size for the tempArray below

			//You need to complete this part.
			// Call private function
			R_MergeSort(0, lines_lengths.length - 1, delayTime);

			Calendar end = Calendar.getInstance();
			//getting the time it took for the iterative merge sort to execute
			//subtracting the end time with the start time
	        SortGUI.rmergeTime = end.getTime().getTime() - start.getTime().getTime();
			
		}
		
		//recursive merge sort method
		// Recursively call this function to get all the elements into sub arrays to be sorted
		private void R_MergeSort(int first, int last, int delayTime){
			if(first < last){
				//You need to complete this part.
				int mid = (first + last) / 2;
				R_MergeSort(first, mid, delayTime);
				R_MergeSort(mid + 1, last, delayTime);
				R_Merge(first, mid, last);
				//Causing a delay for 10ms
				//delay(10);
				paintComponent(this.getGraphics());
				delay(delayTime);
			}
		}

		
		//recursive merge sort method
		private void R_Merge(int first, int mid, int last){

			//You need to complete this part.
			// Gets the size of each side
			int leftLength = mid - first + 1;
			int rightLength = last - mid;
			// Makes temporary arrays with the sizes above to help with sorting
			int[] leftArray = new int[leftLength];
			int[] rightArray = new int[rightLength];
			// Copies data from passed array into the temp arrays
			System.arraycopy(lines_lengths, first, leftArray, 0, leftLength);
			System.arraycopy(lines_lengths, mid + 1, rightArray, 0, rightLength);

			// Merge the left and right arrays with O(1) comparisons looking at the current index of each array
			int l = 0, r = 0, k = first;
			while (l < leftLength && r < rightLength)
			{
				if (leftArray[l] <= rightArray[r])
				{
					lines_lengths[k] = leftArray[l];
					l++;
				}
				else
				{
					lines_lengths[k] = rightArray[r];
					r++;
				}
				k++;
			}
			// When one of the arrays runs out of elements that means all the other arrays elements are greater than the last element in the other array
			// Because of that no comparison needs to happen and the remaining elements can be dumped into the array without comparison
			while (l < leftLength)
			{
				lines_lengths[k] = leftArray[l];
				l++;
				k++;
			}
			while (r < rightLength)
			{
				lines_lengths[k] = rightArray[r];
				r++;
				k++;
			}
		}

		//

	//Radix sort wrapper method
	public void RadixSort(int delayTime){
		//getting the date and time when the radix sort starts
		Calendar start = Calendar.getInstance();

		// Call private function
		RadixSort(lines_lengths, delayTime);

		Calendar end = Calendar.getInstance();
		//getting the time it took for the radix sort to execute
		//subtracting the end time with the start time
		SortGUI.radixTime = end.getTime().getTime() - start.getTime().getTime();

	}

	// Radix Sort method
	private void RadixSort(int[] array, int delayTime){
		// Find the largest value in the array to later determine the number of digits to be sorted
		int max = getMax(array);
		// Start at the LSD and iterate by digit until reaching max digits
		for (int i = 1; max/i > 0; i *= 10) {
			BucketSort(array, i, delayTime);
		}
	}
	// Helper function for getting largest value in the array
	private int getMax(int[] array) {
		int max = array[0];
		for (int i: array) {
			if (i > max) {
				max = i;
			}
		}
		return max;
	}
	// Bucket sort Method
	private void BucketSort(int[] array, int digit, int delayTime) {
		// Make buckets for each digit 0-9
		ArrayList<Integer>[] buckets = new ArrayList[10];
		// Make each bucket into an ArrayList for storing the sorted values
		for (int i = 0; i < 10; i++) {
			buckets[i] = new ArrayList<>();
		}
		// Place elements from the array into buckets based on the current digit
		for (int num : array) {
			int place = (num/ digit) % 10;
			buckets[place].add(num);
		}
		// Remake the passed array with the results of the current sorting
		// Takes the numbers in order from the buckets and puts into the array
		int index = 0;
		for (List<Integer> bucket : buckets) {
			for (int num : bucket) {
				array[index++] = num;
				//Causing a delay for int delayTime value
				delay(delayTime);
				paintComponent(this.getGraphics());
			}
		}
	}


	//////////////////////////////////////////////////////////////////////////////////////////
		
		//iterative merge sort method
		public void I_MergeSort(int delayTime)
		{
		//getting the date and time when the iterative merge sort starts
		Calendar start = Calendar.getInstance();
		//assigning the size for the tempArray below
		tempArray = new int[total_number_of_lines]; 
		//saving the value of total_number_of_lines
		int beginLeftovers = total_number_of_lines;

		
		for (int segmentLength = 1; segmentLength <= total_number_of_lines/2; segmentLength = 2*segmentLength)
		{
			beginLeftovers = I_MergeSegmentPairs(total_number_of_lines, segmentLength, delayTime);
			int endSegment = beginLeftovers + segmentLength - 1;
			if (endSegment < total_number_of_lines - 1) 
			{
			I_Merge(beginLeftovers, endSegment, total_number_of_lines - 1);
			}
		} 

		// merge the sorted leftovers with the rest of the sorted array
		if (beginLeftovers < total_number_of_lines) {
			I_Merge(0, beginLeftovers-1, total_number_of_lines - 1);
		}
		//getting the date and time when the iterative merge sort ends
		Calendar end = Calendar.getInstance();
		//getting the time it took for the iterative merge sort to execute 
		//subtracting the end time with the start time
	    SortGUI.imergeTime = end.getTime().getTime() - start.getTime().getTime();
	} 

	// Merges segments pairs (certain length) within an array 
	public int I_MergeSegmentPairs(int l, int segmentLength, int delayTime)
	{
		//The length of the two merged segments 

		//You suppose  to complete this part (Given).
		int mergedPairLength = 2 * segmentLength;
		int numberOfPairs = l / mergedPairLength;

		int beginSegment1 = 0;
		for (int count = 1; count <= numberOfPairs; count++)
		{
			int endSegment1 = beginSegment1 + segmentLength - 1;

			int beginSegment2 = endSegment1 + 1;
			int endSegment2 = beginSegment2 + segmentLength - 1;
			I_Merge(beginSegment1, endSegment1, endSegment2);

			beginSegment1 = endSegment2 + 1;
			//redrawing the lines_lengths
			paintComponent(this.getGraphics());
			//Causing a delay for 10ms
			delay(delayTime);
		}
		// Returns index of last merged pair
		return beginSegment1;
		//return 1;//modify this line
	}

	public void I_Merge(int first, int mid, int last)
	{
		//You suppose  to complete this part (Given).
		// Two adjacent sub-arrays
		int beginHalf1 = first;
		int endHalf1 = mid;
		int beginHalf2 = mid + 1;
		int endHalf2 = last;

		// While both sub-arrays are not empty, copy the
		// smaller item into the temporary array
		int index = beginHalf1; // Next available location in tempArray
		for (; (beginHalf1 <= endHalf1) && (beginHalf2 <= endHalf2); index++)
		{
			// Invariant: tempArray[beginHalf1..index-1] is in order
			if (lines_lengths[beginHalf1] < lines_lengths[beginHalf2])
			{
				tempArray[index] = lines_lengths[beginHalf1];
				beginHalf1++;
			}
			else
			{
				tempArray[index] = lines_lengths[beginHalf2];
				beginHalf2++;
			}
		}
		//redrawing the lines_lengths
		//paintComponent(this.getGraphics());

		// Finish off the nonempty sub-array

		// Finish off the first sub-array, if necessary
		for (; beginHalf1 <= endHalf1; beginHalf1++, index++)
			// Invariant: tempArray[beginHalf1..index-1] is in order
			tempArray[index] = lines_lengths[beginHalf1];

		// Finish off the second sub-array, if necessary
		for (; beginHalf2 <= endHalf2; beginHalf2++, index++)
			// Invariant: tempa[beginHalf1..index-1] is in order
			tempArray[index] = lines_lengths[beginHalf2];

		// Copy the result back into the original array
		for (index = first; index <= last; index++)
			lines_lengths[index] = tempArray[index];
	}

	//////////////////////////////////////////////////////////////////////
	//Method to initiate the recursive Shell Sort
	public void shellSortCall(int delayTime){
		//Record time at start of sort
		Calendar start = Calendar.getInstance();
		//First element index in the array
		int first = 0;
		//Last element index in the array
		int last = total_number_of_lines - 1;
		//Initiate recursive Shell Sort
		shellSort(lines_lengths, first, last, delayTime);
		//Record time at end of sort
		Calendar end = Calendar.getInstance();
		//Calculate total time, set GUI Shell Sort time
		SortGUI.shellsortTime = end.getTime().getTime() - start.getTime().getTime();

	}
	//Helper incremental insertion sort method, compares elements of a subarray and sorts them, identifying the elements by the passed first index, known to be the first
	//element of the subarray, then spacing out by the space value
	private void incrementalInsSort (int [] array, int first, int last, int space, int delayTime){
		int unsorted, index;
		//unsorted set equal to the next element of the subarray, while unsorted does not exceed the size of the array, increment to the next element of the subarray
		for (unsorted = first + space; unsorted <= last; unsorted = unsorted + space){
			//store value at the location of unsorted in the array
			int firstUnsorted = array[unsorted];
			//index set equal to the first element of the subarray
			for (index = unsorted - space; (index >= first) && (firstUnsorted < array[index]); index = index - space){
				array[index + space] = array[index];
				paintComponent(this.getGraphics());
				delay(delayTime);
			}
			array[index + space] = firstUnsorted;
		}
	}

	public void shellSort (int [] array, int first, int last, int delayTime){
		int n = last - first + 1;
		for (int space = n/2; space > 0; space = space/2){
			for (int begin = first; begin < first + space; begin++){
				incrementalInsSort(array, begin, last, space, delayTime);
			}
		}
	}

	//////////////////////////////////////////////////////////////////////

	public void quickSortCall(int delayTime){
		Calendar start = Calendar.getInstance();
		int first = 0;
		int last = total_number_of_lines - 1;
		quickSort(lines_lengths, first, last, delayTime);
		paintComponent(this.getGraphics());
		Calendar end = Calendar.getInstance();
		SortGUI.qsortTime = end.getTime().getTime() - start.getTime().getTime();
	}

	private void swap (int [] array, int i, int j, int delayTime) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
		paintComponent(this.getGraphics());
		delay(delayTime);
	}

	private int partition (int [] a, int first, int last, int delayTime)
	{
		int pivot = a[last];
		int currElem = first;
		int prevElem = (first-1);
		while(currElem < last){
			if(a[currElem] <= pivot){
				prevElem++;
				swap(a, currElem, prevElem, delayTime);
			}
			currElem++;
		}
		swap(a, prevElem+1, last, delayTime);
		return prevElem+1;

	}

	public void quickSort(int [] a, int first, int last, int delayTime)
	{
		if(first < last)
		{
			int pivotIndex = partition (a, first, last, delayTime);
			quickSort(a, first, pivotIndex - 1, delayTime);
			quickSort(a, pivotIndex + 1, last, delayTime);
		}
	}

	//////////////////////////////////////////////////////////////////////
		
		//This method resets the window to the scrambled lines display
		public void reset(){
			if(scramble_lines != null)
			{
				//copying the old scrambled lines into lines_lengths
				for (int i = 0; i < total_number_of_lines; i++)
				{
					lines_lengths[i] = scramble_lines[i] ;
				}
			//Drawing the now scrambled lines_lengths
			paintComponent(this.getGraphics());
		}
			}
		
	
		//This method colours the lines and prints the lines
		public void paintComponent(Graphics g){
 			super.paintComponent(g);
			//A loop to assign a colour to each line
			for(int i = 0; i < total_number_of_lines; i++){
				//using eight colours for the lines
				if(i % 8 == 0){
					g.setColor(Color.green);
				} else if(i % 8 == 1){
					g.setColor(Color.blue);
				} else if(i % 8 == 2){
					g.setColor(Color.yellow);
				} else if(i%8 == 3){
					g.setColor(Color.red);
				} else if(i%8 == 4){
					g.setColor(Color.black);
				} else if(i%8 == 5){
					g.setColor(Color.orange);
				} else if(i%8 == 6){
					g.setColor(Color.magenta);
				} else
					g.setColor(Color.gray);
				
				//Drawing the lines using the x and y-components 
				g.drawLine(4*i + 25, 300, 4*i + 25, 300 - lines_lengths[i]);
			}
			
		}
		
		//A delay method that pauses the execution for the milliseconds time given as a parameter
		public void delay(int time){
			try{
	        	Thread.sleep(time);
	        }catch(InterruptedException ie){
	        	Thread.currentThread().interrupt();
	        }
		}
		
	}


		


