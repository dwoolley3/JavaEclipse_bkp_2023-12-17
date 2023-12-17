package week1.Ex3;


/***********************************
*  Week 1 lab - exercise 3:        *
*   an expandable ArrayList class  *
***********************************/

/**
 * Class implementing an array based list, where the size can expand.
 */
public class ArrayList
{
    /**
     * Default constructor. Sets length to 0, initializing the list as an empty
     * list. Default size of array is 100.
     */
    public ArrayList()
    {
        list = new int[SIZE];
        length = 0;
    }

    /**
     * Determines whether the list is empty
     *
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty()
    {
        return length == 0;
    }

    /**
     * Prints the list elements.
     */
    public void display()
    {
        for (int i = 0; i < length; i++)
        {
            System.out.print(list[i] + " ");
        }

        System.out.println();
    }

    /**
     * Adds the element x to the end of the list. List length is increased by 1.
     *
     * @param x element to be added to the list
     */
    public void add(int x)
    {
        if (length == list.length)
        {
        	list = resizeArray();
            //System.out.println("Insertion Error: list is full");
        } else
        {
            list[length] = x;
            length++;
        }
    }
    
    /**
     * Create a new array that is double the size of the former array
     * and copy the former array elements into the new expanded array.
     * Size becomes double the prior size of the list array.
     * @return new array that is twice the size of the former array
     */
    private int[] resizeArray()
    {
    	int newSize = list.length * 2;
    	//int[] copy = Arrays.copyOf(list, newSize);
    	int[] copy = new int[newSize];
    	for (int i = 0; i < length; i++)
    		copy[i] = list[i];
    	return copy;
    }

    /**
     * Removes the element at the given location from the list. List length is
     * decreased by 1.
     *
     * @param pos location of the item to be removed
     */
    public void removeAt(int pos)
    {
        for (int i = pos; i < length - 1; i++)
        {
            list[i] = list[i + 1];
        }
        length--;
    }
    
    private static final int SIZE = 100;	//initial size of the array that stores the list items
    private int[] list;             //array to store the list items
    private int length;			    //amount of items in the list
}
