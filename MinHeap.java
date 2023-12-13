
//heapsort #1

public class MinHeap extends Heap implements Heapify
{
	public MinHeap(int[] initialHeap)
	{
		super(initialHeap);
	}
	
	public MinHeap()
	{
		super();
	}
	
	//sorts the given heap so that the smallest element is the root, and all its kids go in ascending order
	public void minHeapSort()
	{
		heapifyUp();
		heapifyDown();
	}
	
	
	//returns the first element in the array and adjusts the heap
	public int poll()
	{
		int first = super.poll();
		heapifyDown();
		return first;
	}
	
	public void add(int victim)
	{
		super.add(victim);
		heapifyUp();
	}
	
	//makes sure the heap looks correct from top down
	public void heapifyDown()
	{
		int index = 0;
		while(super.hasLeft(index))
		{
			int smallerChildIndex = super.getLeftIndex(index);
			if(super.hasRight(index) && super.getRight(index) < super.getLeft(index))
			{
				smallerChildIndex = super.getRightIndex(index);
			}
			
			if(super.currentElement(index) < super.currentElement(smallerChildIndex))
			{
				break;
			}
			else
			{
				super.swap(index, smallerChildIndex);
				index = smallerChildIndex;
			}
		}
	}
	
	//makes sure the heap looks correct from down to top
	public void heapifyUp()
	{
		int index = super.getSize() - 1;
		while(super.notDeadBeat(index) && super.getParent(index) > super.currentElement(index))
		{
			super.swap(super.getParentIndex(index), index);
			index = super.getParentIndex(index);
		}
	}
	
	//prints out the heap
	public void printMinHeap()
	{
		System.out.println("Printing Min Heap:");
		super.printVictims();
	}
	
	public int[] thisIsRedundant()
	{
		return super.getTheHeap();
	}
}
