package week7.Ex1_3;

/******************************
*  Week 7 lab - exercise 1:   *
*   sorting with Arrays.sort  *
*******************************/

import java.util.*;

/**
 * Class to test Arrays.sort.
 */
public class Main
{

    public static void main(String[] args)
    {
        String[] firstNames =
        {
            "Nicholas", "Jessica", "Derrick", "Marlon", "Francesca",
            "Jennifer", "Donald", "Alexis"
        };

        Arrays.sort(firstNames);

        for (String name : firstNames)
            System.out.print(name + " ");

        System.out.println();


    }
}
