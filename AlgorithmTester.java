import java.io.OutputStream;
import java.io.FileOutputStream;

public class AlgorithmTester 
{
	public static void main(String [] args)
	{
		SortingAlgorithms swanson = new SortingAlgorithms();

		//starts the data input for the OutputStream
		String data = "Length, Bubble Sort, Length,Selection Sort, Length,Insertion Sort, Length,Merge Sort, Length,Shell Sort, Length,Quick Sort, Length,Heap Sort \n" ;
		
		for(int x = 10000; x<= 200000; x = x+10000)
		{
			//current starting time
			long start = System.currentTimeMillis();
			
			//makes an array depending on x's value in the for loop
			int[] array = swanson.makeAnArray(x);
			
			//clones the array for each sorting algorithm
			int[] bubbleSorted = array.clone();
			int[] selectionSorted = array.clone();
			int[] insertionSorted = array.clone();
			int[] mergeSorted = array.clone();
			int[] shellSorted = array.clone();
			int[] quickSorted = array.clone();
			int[] heapSorted = array.clone();
			
			
			//starting sorting algorithm time test
			
			
			//bubble sort algorithm test
			bubbleSorted = swanson.bubbleSort(bubbleSorted);
			long endBubble = System.currentTimeMillis();
			System.out.println("BUBBLESORT: Array Size: " +x +" | Milliseconds: " + (endBubble-start));
			if(swanson.validate(bubbleSorted))
			{
				System.out.println("List is sorted correctly");
			}
			else
			{
				System.out.println("Ethan you did something incorrectly");
				break;
			}
			String bubbleData = endBubble-start +"";
			data = data +x +", " +bubbleData;
			
			//selection sort algorithm test
			selectionSorted = swanson.selectionSort(selectionSorted);
			long endSelection = System.currentTimeMillis();
			System.out.println("SELECTIONSORT: Array Size: " +x +" | Milliseconds: " +(endSelection-endBubble));
			if(swanson.validate(selectionSorted))
			{
				System.out.println("List is sorted correctly");
			}
			else
			{
				System.out.println("Ethan you did something incorrectly");
				break;
			}
			String selectionData = endSelection-endBubble +"";
			data = data +", " +x +", " +selectionData;
			
			//insertion sort algorithm test
			insertionSorted = swanson.insertionSort(insertionSorted);
			long endInsertion = System.currentTimeMillis();
			System.out.println("INSERTIONSORT: Array Size: " +x +" | Milliseconds: " +(endInsertion-endSelection));
			if(swanson.validate(insertionSorted))
			{
				System.out.println("List is sorted correctly");
			}
			else
			{
				System.out.println("Ethan you did something incorrectly");
				break;
			}
			String insertionData = endInsertion-endSelection +"";
			data = data +", " +x +", " +insertionData;
			
			//merge sort algorithm test
			swanson.mergeSort(mergeSorted);
			long endMerge = System.currentTimeMillis();
			System.out.println("MERGESORT: Array Size: " +x +" | Milliseconds: " +(endMerge-endInsertion));
			if(swanson.validate(mergeSorted))
			{
				System.out.println("List is sorted correctly");
			}
			else
			{
				System.out.println("Ethan you did something incorrectly");
				break;
			}
			String mergeData = endMerge-endInsertion +"";
			data = data +", " +x +", " +mergeData;
			
			//shell sort algorithm test
			swanson.shellSort(shellSorted);
			long endShell = System.currentTimeMillis();
			System.out.println("SHELLSORT: Array Size: " +x +" | Milliseconds: " +(endShell - endMerge));
			if(swanson.validate(shellSorted))
			{
				System.out.println("List is sorted correctly");
			}
			else
			{
				System.out.println("Ethan you did something incorrectly");
				break;
			}
			String shellData = endShell - endMerge +"";
			data = data +", " +x +", " +shellData;
			
			//quick sort algorithm test
			swanson.quickSort(quickSorted, 0, quickSorted.length-1);
			long endQuick = System.currentTimeMillis();
			System.out.println("QUICKSORT: Array Size: " +x +" | Milliseconds: " +(endQuick - endShell));
			if(swanson.validate(quickSorted))
			{
				System.out.println("List is sorted correctly");
			}
			else
			{
				System.out.println("Ethan you did something incorrectly");
				break;
			}
			String quickData = endQuick - endShell +"";
			data = data +", " +x +", " +quickData;
			
			//heap sort algorithm test
			heapSorted = swanson.heapSort(heapSorted);
			long endHeap = System.currentTimeMillis();
			System.out.println("HEAPSORT: Array Size: " +x +" | Milliseconds: " +(endHeap - endQuick));
			System.out.println("Heap sort cannot be validated since heaps have a different organization structure than arrays");
			String heapData = endHeap - endQuick +"";
			data = data +", " +x +", " +heapData;
			
			data= data +"\n";
		}
		
		try
		{
			OutputStream out = new FileOutputStream("Output.csv");
			byte[] dataBytes = data.getBytes();
			out.write(dataBytes);
			out.close();
		}
		catch(Exception e)
		{
			e.getStackTrace();
		}
	}
}
