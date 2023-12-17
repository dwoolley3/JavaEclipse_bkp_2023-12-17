package week7.Ex2;

/****************************************
*  Week 7 lab - exercise 2:             *
*   using the class java.util.ArrayList *
*   Store 1,000 random numbers in the   *
*   interval of [0,500] and print them. *
*****************************************/

import java.util.*;

/**
 * Class to test the java.util.ArrayList class.
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
    	// Allocate an ArrayList of Integers to store the random numbers
        ArrayList<Integer> numbers = new ArrayList<Integer>();

        // Create list of 1,000 randomly generated numbers between [0,500]
        for (int i = 0; i < 1000; i++)
            numbers.add((int) (Math.random() * 501));

        // Display list of 1,000 randomly generated numbers
        System.out.println("List of numbers:");
        System.out.println(numbers);
    }
}
