
//used the help of https://www.youtube.com/watch?v=t0Cq6tVNRBA&t=514s for the Heap Class and all its other subclasses
public class Heap 
{
	//length of the heap
	private int limit;
	//number of relevant numbers in the heap
	private int size;
	//the actual heap that is going to be used
	//does not have to be in order, exists to save values
	//ordering depends on the subclass
	private int[] theHeap;
	
	public Heap(int[] initialHeap)
	{
		//the initial heap should cannot be empty
		theHeap = initialHeap;
		//there should be no gaps in the heap, so limit and size should be the same throughout
		limit = initialHeap.length;
		size = initialHeap.length;
	}
	
	public Heap()
	{
		theHeap = new int[1];
		limit = 1;
		size = 0;
	}
	
	//getter method for size
	public int getSize()
	{
		return size;
	}
	
	//getter methods to access indexes
	public int getLeftIndex(int parentIndex)
	{
		return (2 * parentIndex) + 1;
	}
	
	public int getRightIndex(int parentIndex)
	{
		return (2 * parentIndex) + 2;
	}
	
	public int getParentIndex(int notOrphan)
	{
		return (notOrphan -1) / 2;
	}
	
	//getter methods that access elements
	public int getLeft(int index)
	{
		return theHeap[getLeftIndex(index)];
	}
	
	public int getRight(int index)
	{
		return theHeap[getRightIndex(index)];
	}
	
	public int getParent(int index)
	{
		return theHeap[getParentIndex(index)];
	}
	
	public int currentElement(int index)
	{
		return theHeap[index];
	}
	
	//methods to see if a parent has a child, or if a child is an orphan
	//basically do each parent node have a child and does each child node have a parent
	public boolean hasLeft(int index)
	{
		return getLeftIndex(index) < size;
	}
	
	public boolean hasRight(int index)
	{
		return getRightIndex(index) < size;
	}
	
	public boolean notDeadBeat(int index)
	{
		return getParentIndex(index) >= 0;
	}
	
	//swaps two indexes in the heap
	public void swap(int indexOne, int indexTwo)
	{
		int temp = theHeap[indexOne];
		theHeap[indexOne] = theHeap[indexTwo];
		theHeap[indexTwo] = temp;
	}
	
	//ensures that the heap does not go over the limit
	public void doNotOverflow()
	{
		if(size == limit)
		{
			int[] newHeap = new int[limit + 1];
			for(int x = 0; x<limit; x++)
			{
				newHeap[x] = theHeap[x];
			}
			theHeap = newHeap;
			limit++;
		}
	}
	
	//returns the first element of the heap
	public int peek()
	{
		return theHeap[0];
	}
	
	//returns and removes the first element of the heap
	//Byron I am sorry, but I need to make programming in this class somewhat enjoyable
	public int poll()
	{
		//get the hostage
		int hostage = theHeap[0];
		//execute the hostage
		theHeap[0] = theHeap[size-1];
		size--;
		//Byron, I'm sorry if you're seeing this unnecessary code, I wanted to do this for comedic purposes
		//Also I am fully aware I can just return hostage, but in the context of the previous comment it has been executed, so I need to return its ghost instead
		int ghostOfTheHostage = hostage;
		return ghostOfTheHostage;
	}
	
	//adds an element to the heap
	public void add(int hostage)
	{
		doNotOverflow();
		theHeap[size] = hostage;
		size++;
	}
	
	
	//prints out the elements in the heap
	public void printVictims()
	{
		for(int victim: theHeap)
		{
			System.out.println(victim);
		}
	}
	
	public int[] getTheHeap()
	{
		return theHeap;
	}
	
}
