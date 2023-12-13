import java.util.Random;
public class SortingAlgorithms 
{
	public SortingAlgorithms() {}
	
	public int[] bubbleSort(int[] array)
	{
		int[] sortedArray = array;
		int swapNum = 1;
		while(swapNum > 0)
		{
			swapNum = 0;
			for(int x = 0; x<sortedArray.length-1; x++)
			{
				if(sortedArray[x] > sortedArray[x+1])
				{
					int temp = sortedArray[x];
					sortedArray[x] = sortedArray[x+1];
					sortedArray[x+1] = temp;
					swapNum++;
				}
			}
		}
		return sortedArray;
	}
	
	public int[] selectionSort(int[] array)
	{
		for(int x = 0; x<array.length; x++)
		{
			int smallest = array[x];
			int switchIndex = x;
			for(int y = x; y<array.length; y++)
			{
				if(smallest > array[y] && array[y] != array[x])
				{
					smallest = array[y];
					switchIndex = y;
				}
			}
			if(smallest != array[x])
			{
				int temp = array[x];
				array[x] = smallest;
				array[switchIndex] = temp;
			}
		}
		return array;
	}
	
	public int[] insertionSort(int [] array)
	{
		//starts at 0 and iterates to the next index
		for(int x = 0; x < array.length; x++)
		{
			int y = x;
			while(y - 1 >= 0)
			{
				if(array[y-1] > array[y])
				{
					int temp = array[y-1];
					array[y-1] = array[y];
					array[y] = temp;
				}
				y--;
			}
		}
		return array;
	}
	
	//used https://www.youtube.com/watch?v=3j0SWDX4AtU for help
	//I'll be honest, I had a good portion of this code already written, I just had an infinite loop that I did not know how to debug, so I looked to the internet for advice
	public void mergeSort(int[] array)
	{
		
		if(array.length <= 1)
		{
			return;
		}
		//half of the array
		//splits the array in half and helps with populating the halves
		int half = array.length/2;
		
		//makes a left array and a right array
		int[] left = new int[half];
		int[] right = new int[array.length - half];
		
		//populates left and right array
		int x = 0; 
		int y = 0;
		for(; x<array.length; x++)
		{
			if(x<half)
			{
				left[x] = array[x];
			}
			else
			{
				right[y] = array[x];
				y++;
			}
		}
		
		//recursion :O
		mergeSort(left);
		mergeSort(right);

		//merges the left and the right arrays
		actuallyMerge(array, left, right);
	}
	
	//Helper method to perform the merge between two arrays
	private int[] actuallyMerge(int[] total, int[] left, int[] right)
	{
		int x = 0;
		int y = 0;
		int z = 0;
		while(x<left.length && y< right.length)
		{
			if(left[x] < right[y])
			{
				total[z] = left[x];
				x++;
				z++;
			}
			else 
			{
				total[z] = right[y];
				y++;
				z++;
			}
		}
		while(x<left.length)
		{
			total[z] = left[x];
			x++;
			z++;
		}
		while(y< right.length)
		{
			total[z] = right[y];
			y++;
			z++;
		}
		return total;
	}
	
	//used https://www.tutorialspoint.com/data_structures_algorithms/shell_sort_algorithm.htm to create the algorithm
	public void shellSort(int[] array)
	{
		int interval = 1;
		int elements = array.length;
		while(interval < elements/3)
		{
			interval = interval*3 + 1;
		}
		while(interval > 0)
		{
	        for (int outer = interval; outer < elements; outer++) {
	            int valueToInsert = array[outer];
	            int inner = outer;
	            while (inner > interval -1 && array[inner - interval] >= valueToInsert) {
	                array[inner] = array[inner - interval];
	                inner -= interval;
	            }
	            array[inner] = valueToInsert;
	        }
	        interval = (interval -1) /3;
		}
	}
	
	//used https://www.youtube.com/watch?v=Vtckgz38QHs for this algorithm
	//also went to the tutoring center and the tutor used a very similar, if not the same, algorithm, please don't kill me, i said so
	public void quickSort(int[] array, int start, int end)
	{
		if(end <= start)
		{
			return;
		}
		int pivot = partition(array, start, end);
		quickSort(array, start, pivot-1);
		quickSort(array, pivot+1, end);
		
	
	}
	
	//selects a pivot and puts anything lesser than the pivot to the left
	//puts greater values to the right
	private int partition(int[] array, int start, int end)
	{
		int pivot = array[end];
		int x = start - 1;
		
		for(int y = start; y<end; y++)
		{
			if(array[y] < pivot)
			{
				x++;
				int temp = array[x];
				array[x] = array[y];
				array[y] = temp;
			}
		}
		x++;
		int temp = array[x];
		array[x] = array[end];
		array[end] = temp;
		
		return x;
	}
	
	
	//reused code from my own heap class
	//algorithms were made from https://www.youtube.com/watch?v=t0Cq6tVNRBA
	public int[] heapSort(int[] array)
	{
		MinHeap heap = new MinHeap();
		for(int x = 0; x<array.length; x++)
		{
			heap.add(array[x]);
		}
		
		array = heap.thisIsRedundant();
		return array;
	}

	
	/*
	 * makes an array of random elements
	 * length depends on user input
	 */
	public int[] makeAnArray(int length)
	{
		Random rand = new Random();
		int[] array = new int[length];
		for(int x = 0; x<length; x++)
		{
			array[x] = rand.nextInt(100);
		}
		return array;
	}
	
	//prints out the entire array
	public String printArray(int[] array)
	{
		String output = "";
		for(int x: array)
		{
			output = output +x +", ";
		}
		return output;
	}
	
	public boolean validate(int[] array)
	{
		for(int x = 0; x<array.length-1; x++)
		{
			if(array[x]>array[x+1])
			{
				return false;
			}
		}
		return true;
	}
}
