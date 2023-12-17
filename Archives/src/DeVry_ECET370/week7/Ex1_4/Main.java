package week7.Ex1_4;

/******************************
*  Week 7 lab - exercise 1:   *
*   using the java.util Stack *
*******************************/

import java.util.*;

/**
 * Class to test the java.util.Stack class.
 */
public class Main
{

    public static void main(String[] args)
    {
        Stack<Character> s = new Stack<Character>();

        System.out.println("Insertion of 10 characters in s");
        for (int i = 0; i < 10; i++)
        {
            int x = 32 + (int) (Math.random() * 95);
            System.out.println(x + " --> " + (char) x);
            s.push((char) x);
        }

        System.out.println("\nDisplaying and deleting elements");
        for (int i = 0; i < 10; i++)
        {
            System.out.println("Item at the top: " + s.peek());

            s.pop();
        }
    }
}
