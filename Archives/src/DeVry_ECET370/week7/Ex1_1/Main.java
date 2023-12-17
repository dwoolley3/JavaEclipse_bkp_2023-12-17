package week7.Ex1_1;

/****************************************
*  Week 7 lab - exercise 1:             *
*   using the class java.util.ArrayList *
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
        ArrayList<Integer> numbers = new ArrayList<Integer>();

        //list creation
        for (int i = 0; i < 10; i++)
            numbers.add((int) (Math.random() * 100));

        System.out.println("List of numbers:");
        System.out.println(numbers);

        Scanner in = new Scanner(System.in);
        System.out.print("Please, enter an int value: ");
        int x = in.nextInt();

        if (numbers.contains(x))
            System.out.println("Found!");
        else
            System.out.println("Not found!");
        
        in.close();
    }
}
