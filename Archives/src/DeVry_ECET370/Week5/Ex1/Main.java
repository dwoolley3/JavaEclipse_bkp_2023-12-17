package Week5.Ex1;

/*******************************************
*  Week 5 lab - exercise 1 and exercise 2: *
*   ArrayList class with search algorithms *
********************************************/

import java.util.*;

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
        int n = 20;
        ArrayList numbers = new ArrayList(n);

        for (int i = 0; i < n; i++)
            numbers.add((int) (Math.random() * 100));

        System.out.println("List of integers:");
        System.out.println(numbers);

        //Searching with sequential search
        System.out.print("\n(Sequential Search) Enter a number:");
        int x = in.nextInt();
        if (numbers.sequentialSearch(x))
            System.out.println("Found!");
        else
            System.out.println("Not found!");

        //Sorting the list
        numbers.quicksort();
        System.out.println("\nSorted list of integers:");
        System.out.println(numbers);

        //Searching with sorted search
        System.out.print("\n(Sorted Search) Enter a number:");
        x = in.nextInt();
        if (numbers.sortedSearch(x))
            System.out.println("Found!");
        else
            System.out.println("Not found!");

        //Searching with binary search
        System.out.print("\n(Binary Search) Enter a number:");
        x = in.nextInt();
        if (numbers.binarySearch(x))
            System.out.println("Found!");
        else
            System.out.println("Not found!");
        
        in.close();
    }
}
