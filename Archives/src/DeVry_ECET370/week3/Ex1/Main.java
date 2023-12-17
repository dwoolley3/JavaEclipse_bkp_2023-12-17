package week3.Ex1;

/****************************
*  Week 3 lab - exercise 1: *
*   a simple Stack class    *
*****************************/

/**
 * Class to test the Stack class.
 */
public class Main
{

    public static void main(String[] args)
    {
        Stack s = new Stack();

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
