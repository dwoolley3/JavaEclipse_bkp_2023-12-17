package binarySearch;


/*******************************************
*  Week 5 lab - exercise 3:                *
*   ArrayList class with search algorithms *
*   Having two new Binary Search algorithms*
*   to find the smallest index range that  *
*   encompasses two target values within   *
*   a randomly generated list of values.   *
********************************************/


/**
 * Class to test binary search algorithms implemented in ArrayList.
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
        //Produce two target values for which to find the smallest range of indices
        //that encompass both target values. Among the two target values,
        //the minimum is identified and the maximum is identified.
        //A binary search is performed to find the largest index that contains
        //a value less than or equal to the minimum number. Further, a binary
        //search is performed to find the smallest index that contains a 
        //value greater than or equal to the maximum number.
        
        //Example output:
        
		//        Generated list of 20 sorted random integers between 0 and 49
		//        1 3 6 9 13 13 14 17 17 22 24 29 29 31 31 33 34 34 42 48 
		//
		//        Target Values = 17, 49
		//        The smallest range of indices is [8, 20]
		//
		//        Target Values = 0, 6
		//        The smallest range of indices is [-1, 2]
		//
		//        Target Values = 39, 45
		//        The smallest range of indices is [17, 19]
		//
		//        Target Values = 5, 24
		//        The smallest range of indices is [1, 10]
		//
		//        Target Values = 1, 28
		//        The smallest range of indices is [0, 11]

        //List creation and display
        int numInList = 20;
        ArrayList numbers = new ArrayList(numInList);
        int maxNum = 50;
        int numValsToFind = 5;

        //Generate random numbers for ArrayList and sort the list
        for (int i = 0; i < numInList; i++)
            numbers.add((int) (Math.random() * maxNum));
        numbers.quicksort();

        //Display the list of generated numbers
        System.out.println("Generated list of " + numInList + " sorted random integers between 0 and " + (maxNum - 1));
        System.out.println(numbers);      
    	

        for (int i = 0; i < numValsToFind; i++)
        {
            //Obtain two random target values and then find smallest range encompassing those values
        	int x1 = (int) (Math.random() * maxNum);
        	int x2 = (int) (Math.random() * maxNum);
        	int minimum = Math.min(x1, x2);
        	int maximum = Math.max(x1, x2);
        	int indexMin = numbers.binarySearchMin(minimum);
        	int indexMax = numbers.binarySearchMax(maximum);        	
       
	        //Display minimum index and maximum index for range surrounding target values
	        System.out.print("\nTarget Values = " + minimum + ", " + maximum);
	        System.out.print("\nThe smallest range of indices is ["
	        		+ indexMin + ", " + indexMax + "]");
	        System.out.println();
        }
    }
}
