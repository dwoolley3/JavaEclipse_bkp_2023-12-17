package week4.Ex3;

/************************************************
*  Week 4 lab - exercise 3: Recursion -         *
*   implementing a recursive function that      *
*   writes a given array backwards.  The last   *
*   element of the array is considered first.   *
*************************************************/

import java.util.*;

public class Main
{
	/** Displays elements in an array backwards, from index highIndex to 0
	 * @param array      An array of integers
	 * @param highIndex  The highest index to display and from which to decrement
	 */
    public void displayArrayBackwards(int[] array, int highIndex)
    {
        if (highIndex >= 0)
        {
        	//Display element if index is not smaller than smallest index of 0
            System.out.print(array[highIndex] + " ");
            //Recurse by using an index that is one smaller
            displayArrayBackwards(array, highIndex-1);
        }
    }

    public Main()
    {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter number of elements in array: ");
        int numElements = in.nextInt();

        int[] array = new int[numElements];
        System.out.print("Enter array elements separated by a space: ");
        for (int i = 0; i < numElements; i++)
        	array[i] = in.nextInt();
        	
        //Display Array backwards, considering the last element first        
        displayArrayBackwards(array, numElements-1);
        System.out.println();
        
        in.close();
    }

    public static void main(String[] args)
    {
        @SuppressWarnings("unused")
		Main myAppl = new Main();
    }
}
