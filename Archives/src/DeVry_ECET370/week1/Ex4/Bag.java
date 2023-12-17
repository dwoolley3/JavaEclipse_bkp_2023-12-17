package week1.Ex4;

import java.util.Arrays;


/***********************************
*  Week 1 lab - exercise 4:        *
*   a class bag (multiset) that    *
*   uses an expandable array to    *
*   store bag items. The bag will  *
*   store strings of characters.   *
***********************************/

/**
 * Class implementing an array based bag, where the size can expand.
 */
public class Bag
{
    /**
     * Default constructor. Sets length to 0, initializing the bag as 
     * an empty bag. Default size of array is 20.
     */
    public Bag()
    {
        bag = new String[SIZE];
        length = 0;
    }

    /**
     * Determines whether the bag is empty
     *
     * @return true if the bag is empty, false otherwise
     */
    public boolean isEmpty()
    {
        return length == 0;
    }

    /**
     * Prints the bag elements, 10 per line.
     */
    public void print()
    {
        for (int i = 0; i < length; i++)
        {
            System.out.print(bag[i] + " ");
            if ((i+1) % 10 == 0) 
            	System.out.println();
        }

        System.out.println();
    }
    
    /**
     * Returns the number of items in the bag
     * @return the number of items in the bag
     */
    public int getLength()
    {
    	return length;
    }
    
    /**
     * Removes all of the items from the bag, from the end of array,
     * until bag is empty and length becomes 0.
     */    
    public void clear()
    {
    	while (length > 0)
    	{
    		bag[length - 1] = null;
    		length--;
    	}
    }

    /**
     * Adds an item to the end of the bag. oldBag length is increased by 1.
     *
     * @param item to be added to the bag
     */
    public void add(String item)
    {
        if (length == bag.length)
        {
        	bag = resizeArray();
        } else
        {
        	bag[length] = item;
            length++;
        }
    }
    
    /**
     * Create a new array that is double the size of the former array
     * and copy the former array elements into the new expanded array.
     * Size becomes double the prior size of the bag array.
     * @return new array that is twice the size of the former array
     */
    private String[] resizeArray()
    {
    	int newSize = bag.length * 2;
    	String[] copy = Arrays.copyOf(bag, newSize);
    	return copy;
    }

    /**
     * Removes item from the bag; only one occurrence of item should be removed
     * oldBag length is decreased by 1.
     *
     * @param item to be removed
     */
    public void removeOne(String item)
    {
    	int index = getIndexOf(item);
    	removeAt(index);
    }
    
    /**
     * Removes item from the bag at position index, by replacing it with 
     * the last item in the bag and then making last item null.
     * oldBag length is decreased by 1.
     *
     * @param index of item to be removed
     */
    private void removeAt(int index)
    {
    	if (0 <= index && index < length)
    	{
    		bag[index] = bag[length - 1]; //Replace item with last item
    		bag[length - 1] = null;		  //Remove last item
    		length--;
    	}
    }
    
    /**
     * Locate a given item within an array bag.
     * @param item to be found within bag.
     * @return the index of the item, if found, or -1 otherwise.
     */
    private int getIndexOf(String item)
    {
    	boolean found = false;
    	int index = -1, ind = 0;
    	while (!found && (ind < length))
    	{
    		if (item.equals(bag[ind]))
			{
    			index = ind;
			}
    		ind++;
    	}    	   	
    	return index;
    }
    
    /**
     * Removes all occurrences of item from the bag.
     * oldBag length is decreased by 1 each time.
     *
     * @param item to be removed
     */
    public void removeAll(String item)
    {
    	int index = getIndexOf(item);	//Find position of item in bag
    	while (index > -1)
    	{	
    		removeAt(index);			//Remove item in bag at index
    		index = getIndexOf(item);   //Check if another item is in bag
    	}
    }
    
    /**
     * Return the count of occurrences of an item in bag
     * @param item to be counted within bag
     * @return count of same item in bag
     */
    public int count(String item)
    {
    	int counter = 0;
    	for (int index = 0; index < bag.length; index++)
    	{
    		if (item.equals(bag[index])) 
    			counter++;
    	}    	
    	return counter;
    }
    
    private static final int SIZE = 20;	//initial size of the array that stores the bag items
    private String[] bag;             //array to store the bag items
    private int length;			    //amount of items in the bag
}
