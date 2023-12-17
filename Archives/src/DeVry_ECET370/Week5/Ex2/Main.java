package Week5.Ex2;

/*******************************************
*  Week 5 lab - exercise 1 and exercise 2: *
*   ArrayList class with search algorithms *
********************************************/

import java.util.*;

import Week5.Ex1.ArrayList;

/**
 * Class to test sequential search, sorted search, and binary search algorithms
 * implemented in ArrayList.
 */
public class Main
{

    public static void main(String[] args)
    {
        @SuppressWarnings("unused")
		Main myAppl = new Main();
    }

    public Main()
    {
        Scanner in = new Scanner(System.in);

        //List creation and display
        int numInList = 100_000;
        ArrayList numbers = new ArrayList(numInList);
        int maxNum = 100_000;
        int numValsToFind = 100_000;
        
        for (int i = 0; i < numInList; i++)
            numbers.add((int) (Math.random() * maxNum));

        System.out.println("Generated list of " + numInList + " random integers between 0 and " + (maxNum - 1));
        
        int[] valToFind = new int[numValsToFind];
        for (int i = 0; i < numValsToFind; i++)
            valToFind[i] = (int) (Math.random() * maxNum);
       
        
        //Searching with sequential search
        System.out.print("\n(Sequential Search) Searching random numbers " + numValsToFind + " times:");

    	//Repeatedly call Sequential Search and get elapsed time
    	Date current = new Date();
    	long startTime = current.getTime();
  	
    	int cntFound = 0;
    	for (int i = 0; i < numValsToFind; i++)
    		if (numbers.sequentialSearch(valToFind[i]))
    			cntFound++;
  	
    	current = new Date();
    	long stopTime = current.getTime();
    	long elapsedTimeA = stopTime - startTime;
    	System.out.print("\n(Sequential Search) Elapsed time = " + elapsedTimeA + " milliseconds");
    	    	
    	System.out.println("\n" + cntFound + " items were Found and " +
    			(numValsToFind - cntFound) + " items were not found!");

    	
    	//Sorting the list
        numbers.quicksort();
        System.out.println("\nSorted list of " + numInList + " integers");
        
        
        //Searching with binary search
        System.out.print("\n(Binary Search) Searching same random numbers " + numValsToFind + " times:");

    	//Repeatedly call Binary Search and get elapsed time
    	current = new Date();
    	startTime = current.getTime();
  	
    	cntFound = 0;
    	for (int i = 0; i < numValsToFind; i++)
    		if (numbers.binarySearch(valToFind[i]))
    			cntFound++;
  	
    	current = new Date();
    	stopTime = current.getTime();
    	elapsedTimeA = stopTime - startTime;
    	System.out.print("\n(Binary Search) Elapsed time = " + elapsedTimeA + " milliseconds");
    	    	
    	System.out.println("\n" + cntFound + " items were Found and " +
    			(numValsToFind - cntFound) + " items were not found!");
    	       
        in.close();
    }
}
