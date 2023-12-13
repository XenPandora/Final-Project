
public class Tester 
{
	public static void main(String [] args)
	{
		
		SortingAlgorithms george = new SortingAlgorithms();
		
		
		int[] bubbleArray = george.makeAnArray(10);
		System.out.println("Testing bubble sort");
		System.out.println("Here is a new array of random values: " +george.printArray(bubbleArray));
		bubbleArray = george.bubbleSort(bubbleArray);
		System.out.println("Here is your sorted array: " +george.printArray(bubbleArray));
		
		System.out.println();
		
		int[] selectionArray = george.makeAnArray(10);
		System.out.println("Testing selection sort");
		System.out.println("Here is a new array of random values: " +george.printArray(selectionArray));
		selectionArray = george.selectionSort(selectionArray);
		System.out.println("Here is your sorted array: " +george.printArray(selectionArray));
		
		System.out.println();
		
		int[] insertionArray = george.makeAnArray(10);
		System.out.println("Testing insertion sort");
		System.out.println("Here is a new array of random values: " +george.printArray(insertionArray));
		insertionArray = george.insertionSort(insertionArray);
		System.out.println("Here is your sorted array: " +george.printArray(insertionArray));
		
		System.out.println();
		
		int[] mergeArray = george.makeAnArray(10);
		System.out.println("Testing merge sort");
		System.out.println("Here is a new array of random values: " +george.printArray(mergeArray));
		george.mergeSort(mergeArray);
		System.out.println("Here is your sorted array: " +george.printArray(mergeArray));
		
		System.out.println();
		
		
		int[] shellArray = george.makeAnArray(10);
		System.out.println("Testing shell sort");
		System.out.println("Here is a new array of random values: " +george.printArray(shellArray));
		george.shellSort(shellArray);
		System.out.println("Here is your sorted array: " +george.printArray(shellArray));
		
		
		System.out.println();
		
		int[] quickArray = george.makeAnArray(10);
		System.out.println("Testing quick sort");
		System.out.println("Here is a new array of random values: " +george.printArray(quickArray));
		george.quickSort(quickArray, 0, quickArray.length-1);
		System.out.println("Here is your sorted array: " +george.printArray(quickArray));
		
		System.out.println();
		
		int[] heapArray = george.makeAnArray(10);
		System.out.println("Testing heap sort");
		System.out.println("Here is a new array of random values: " +george.printArray(heapArray));
		heapArray = george.heapSort(heapArray);
		System.out.println("Here is your sorted array: " +george.printArray(heapArray));
		
	}
}
