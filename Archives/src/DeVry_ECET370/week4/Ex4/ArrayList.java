package week4.Ex4;

/********************************************
*  Week 4 lab - exercise 1 and exercise 4:  *
*   ArrayList class with sorting algorithms *
*********************************************/

/**
 * Class implementing an array based list. Bubblesort and quicksort algorithms
 * are implemented also.
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

    /*The methods listed below are new additions to the ArrayList class
     * completed in Week 1*/

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
    private static int SIZE;    //size of the array that stores the list items
    private int[] list;         //array to store the list items
    private int length;		//amount of items in the list
}
