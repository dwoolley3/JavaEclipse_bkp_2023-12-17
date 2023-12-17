package week4.Ex1_Sorting_Algorithms;

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
        //creating a list of integers
        int n = 25;
        ArrayList numbers = new ArrayList(n);

        //filling the list with random integers
        for (int i = 0; i < n; i++)
            numbers.add((int) (Math.random() * 100));

        //printing the list
        System.out.println("Original list of numbers:");
        numbers.display();

        //testing bubblesort
        ArrayList numbersCopy1 = numbers.copy();
        System.out.println("\nBubble-sorted list of numbers:");
        numbersCopy1.bubbleSort();
        numbersCopy1.display();

        //testing quicksort
        ArrayList numbersCopy2 = numbers.copy();
        System.out.println("\nQuick-sorted list of numbers:");
        numbersCopy2.quicksort();
        numbersCopy2.display();
    }

    public static void main(String[] args)
    {
        @SuppressWarnings("unused")
		Main myAppl = new Main();
    }
}
