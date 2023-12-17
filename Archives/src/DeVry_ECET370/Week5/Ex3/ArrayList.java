package Week5.Ex3;

/*******************************************
*  Week 5 lab - exercise 3:                *
*   ArrayList class with search algorithms *
********************************************/

/**
 * Class implementing an array based list. Sequential search, sorted search, and
 * binary search algorithms are implemented also.
 */
public class ArrayList
{

    /**
     * Default constructor. Sets length to 0, initializing the list as an empty
     * list. Default size of array is 20.
     */
    public ArrayList()
    {
        SIZE = 20;
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
            System.out.print(list[i] + " ");

        System.out.println();
    }

    /**
     * Adds the element x to the end of the list. List length is increased by 1.
     *
     * @param x element to be added to the list
     */
    public void add(int x)
    {
        if (length == SIZE)
            System.out.println("Insertion Error: list is full");
        else
        {
            list[length] = x;
            length++;
        }
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
            list[i] = list[i + 1];
        length--;
    }

    //Implementation of methods in the lab exercise
    /**
     * Non default constructor. Sets length to 0, initializing the list as an
     * empty list. Size of array is passed as a parameter.
     *
     * @param size size of the array list
     */
    public ArrayList(int size)
    {
        SIZE = size;
        list = new int[SIZE];
        length = 0;
    }

    /**
     * Returns the number of items in the list (accessor method).
     *
     * @return the number of items in the list.
     */
    public int getLength()
    {
        return length;
    }

    /**
     * Returns the size of the list (accessor method).
     *
     * @return the size of the array
     */
    public int getSize()
    {
        return SIZE;
    }

    /**
     * Removes all of the items from the list. After this operation, the length
     * of the list is zero.
     */
    public void clear()
    {
        length = 0;
    }

    /**
     * Replaces the item in the list at the position specified by location.
     *
     * @param location location of the element to be replaced
     * @param item value that will replace the value at location
     */
    public void replace(int location, int item)
    {
        if (location < 0 || location >= length)
            System.out.println("Error: invalid location");
        else
            list[location] = item;
    }

    /**
     * Adds an item to the list at the position specified by location.
     *
     * @param location location where item will be added.
     * @param item item to be added to the list.
     */
    public void add(int location, int item)
    {
        if (location < 0 || location >= length)
            System.out.println("Error: invalid position");
        else if (length == SIZE)
            System.out.println("Error: Array is full");
        else
        {
            for (int i = length; i > location; i--)
                list[ i] = list[ i - 1];
            list[location] = item;
            length++;
        }
    }

    /**
     * Deletes an item from the list. All occurrences of item in the list will
     * be removed.
     *
     * @param item element to be removed.
     */
    public void remove(int item)
    {
        for (int i = 0; i < length; i++)
            if (list[i] == item)
            {
                removeAt(i);
                i--;	//onsecutive values won't be all removed; that's why i-- is here
            }
    }

    /**
     * Returns the element at location
     *
     * @param location position in the list of the item to be returned
     * @return element at location
     */
    public int get(int location)
    {
        int x = -1;

        if (location < 0 || location >= length)
            System.out.println("Error: invalid location");
        else
            x = list[location];

        return x;
    }

    /**
     * Makes a deep copy to another ArrayList object.
     *
     * @return Copy of this ArrayList
     */
    public ArrayList copy()
    {
        @SuppressWarnings("static-access")
		ArrayList newList = new ArrayList(this.SIZE);

        newList.length = this.length;

        for (int i = 0; i < length; i++)
            newList.list[i] = this.list[i];

        return newList;
    }

    /**
     * Bubble-sorts this ArrayList
     */
    public void bubbleSort()
    {
        for (int i = 0; i < length - 1; i++)
            for (int j = 0; j < length - i - 1; j++)
                if (list[j] > list[j + 1])
                {
                    //swap list[j] and list[j+1]
                    int temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
    }

    /**
     * Quick-sorts this ArrayList.
     */
    public void quicksort()
    {
        quicksort(0, length - 1);
    }

    /**
     * Recursive quicksort algorithm.
     *
     * @param begin initial index of sublist to be quick-sorted.
     * @param end last index of sublist to be quick-sorted.
     */
    private void quicksort(int begin, int end)
    {
        int temp;
        int pivot = findPivotLocation(begin, end);

        // swap list[pivot] and list[end]
        temp = list[pivot];
        list[pivot] = list[end];
        list[end] = temp;

        pivot = end;

        int i = begin,
                j = end - 1;

        boolean iterationCompleted = false;
        while (!iterationCompleted)
        {
            while (list[i] < list[pivot])
                i++;
            while ((j >= 0) && (list[pivot] < list[j]))
                j--;

            if (i < j)
            {
                //swap list[i] and list[j]
                temp = list[i];
                list[i] = list[j];
                list[j] = temp;

                i++;
                j--;
            } else
                iterationCompleted = true;
        }

        //swap list[i] and list[pivot]
        temp = list[i];
        list[i] = list[pivot];
        list[pivot] = temp;

        if (begin < i - 1)
            quicksort(begin, i - 1);
        if (i + 1 < end)
            quicksort(i + 1, end);
    }

    /*
     * Computes the pivot location.
     */
    private int findPivotLocation(int b, int e)
    {
        return (b + e) / 2;
    }

    /*The methods listed below are new additions to the ArrayList class
     * of Week 4*/
    /**
     * This method returns a string representation of the array list elements.
     * Classes with this method implemented can get its objects displayed in a
     * simple way using System.out.println. For example, if list is an ArrayList
     * object, it can be printed by using
     *
     * System.out.println(list);
     *
     * @return a string representation of the array list elements.
     */
    public String toString()
    {
        String s = "";

        for (int i = 0; i < length; i++)
            s += list[i] + " ";

        return s;
    }

    /**
     * Determines if an item exists in the array list using sequential (linear)
     * search.
     *
     * @param x item to be found.
     * @return true if x is found in the list, false otherwise.
     */
    public boolean sequentialSearch(int x)
    {
        for (int i = 0; i < length; i++)
            if (list[i] == x)
                return true;

        return false;
    }

    /**
     * Determines if an item exists in the array list using sorted search. List
     * must be sorted.
     *
     * @param x item to be found.
     * @return true if x is found in the list, false otherwise.
     */
    public boolean sortedSearch(int x)
    {
        //The list must ne sorted to invoke this method!
        int i = 0;
        while (i < length && list[i] < x)
            i++;

        if (i < length && list[i] == x)
            return true;	// x is in the array
        else
            return false;						// x is not in the array
    }

    /**
     * Determines if an item exists in the array list using binary search. List
     * must be sorted.
     *
     * @param x item to be found.
     * @return true if x is found in the list, false otherwise.
     */
    public boolean binarySearch(int x)
    {
        int first = 0, last = length - 1, pivot;

        boolean found = false;
        while (first <= last && !found)
        {
            pivot = (first + last) / 2;
            if (list[pivot] == x)
                found = true;
            else if (x < list[pivot])
                last = pivot - 1;
            else
                first = pivot + 1;
        }

        if (found)
            return true;
        else
            return false;
    }
    
    /**
     * Perform a binary search to find the largest index for 
     * which all values of that index and higher indexes
     * are at least as much as the input value x.
     * List must be sorted.
     * If indexes 0 - 5 have values 3, 5, 7, 7, 8, 9 then value of 7 would return index 2
     *
     * @param x item to be found or positioned
     * @return index for which its value and values of all indexes
     * less than it are at least as much as the input value x. 
     * If no indexes have values that are smaller than x, then return -1.   
     */
    public int binarySearchMin(int x)
    {
        int first = 0, last = length - 1, pivot;

        while (first < last)
        {
            pivot = first + (last - first + 1) / 2;
            if (list[pivot] <= x)
                first = pivot;
            else if (x < list[pivot])
                last = pivot - 1;
        }
        int index = first;
        if (list[index] > x) 
        	index = -1;  //No index values are less than or equal to entered value x

        return index;
    }
    
    /**
     * Perform a binary search to find the smallest index for 
     * which all values of that index and smaller indexes
     * are at most as much as the input value x.
     * List must be sorted.
     * If indexes 0 - 5 have values 3, 5, 7, 7, 8, 9 then value of 7 would return index 3
     *
     * @param x item to be found or positioned
     * @return index for which its value and values of all indexes
     * greater than it are at most as much as the input value x.
	 * If no indexes have values that are larger than x, then return last index + 1.  
     * 
     */
    public int binarySearchMax(int x)
    {
        int first = 0, last = length - 1, pivot;

        while (first < last)
        {
        	pivot = first + (last - first + 1) / 2;
            if (list[pivot] >= x)
                last = pivot - 1;
            else if (x > list[pivot])
                first = pivot;
        }
        int index = first + 1;
        
        return index;
    }
    
    private static int SIZE;    //size of the array that stores the list items
    private int[] list;         //array to store the list items
    private int length;		//amount of items in the list
}
