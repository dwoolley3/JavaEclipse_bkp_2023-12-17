package week4.Ex4;

import java.util.Date;

/********************************************
*  Week 4 lab - exercise 1 and exercise 4:  *
*   ArrayList class with sorting algorithms *
*********************************************/

/**
 * Class to test bubblesort and quicksort algorithms implemented in ArrayList.
 */
public class Main
{

    public Main()
    {
    	int [] listLength = {5, 10, 50, 100, 500, 1000, 3000, 5000, 10_000, 30_000, 50_000, 100_000}; 

    	for (int n : listLength)
    	{
            //creating a list of integers
	        ArrayList numbers = new ArrayList(n);
	
	        //filling the list with random integers
	        for (int i = 0; i < n; i++)
	            numbers.add((int) (Math.random() * 1000));
	
	        //printing the list
	        System.out.println("Original list of " + n + " numbers:");
	        if (n < 1000)
	        	numbers.display();
	        else
	        	System.out.println("too many to list");
	
	        //Testing bubblesort
	        ArrayList numbersCopy1 = numbers.copy();
	        System.out.println("\nBubble-sorted list of " + n + " numbers:");
	        
        	// Call Bubble Sort and get elapsed time
        	Date current = new Date();
        	long startTime = current.getTime();
      	
	        numbersCopy1.bubbleSort();
        	
        	current = new Date();
        	long stopTime = current.getTime();
        	long elapsedTimeBub = stopTime - startTime;

	        if (n < 1000)
	        	numbersCopy1.display();
	        else
	        	System.out.println("too many to list");
        	System.out.println("Bubble Sort: Elapsed time = " + elapsedTimeBub);      	        	

	        //testing quicksort
	        ArrayList numbersCopy2 = numbers.copy();
	        System.out.println("\nQuick-sorted list of " + n + " numbers:");

        	// Call Quick Sort and get elapsed time
        	current = new Date();
        	startTime = current.getTime();
      	
	        numbersCopy2.quicksort();
        	
        	current = new Date();
        	stopTime = current.getTime();
        	long elapsedTimeQuick = stopTime - startTime;
        	
	        if (n < 1000)
	        	numbersCopy2.display();
	        else
	        	System.out.println("too many to list");
        	System.out.println("QuickSort: Elapsed time = " + elapsedTimeQuick);  
	        
	        System.out.println("---");
    	}
    }

    public static void main(String[] args)
    {
        @SuppressWarnings("unused")
		Main myAppl = new Main();
    }
}
