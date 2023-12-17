package week3.Ex2;

/****************************
*  Week 3 lab - exercise 2: *
*   a simple Stack class    *
*   with error messages     *
*****************************/

/**
 * Class to test the Stack class.
 */
public class Main
{

    public static void main(String[] args)
    {
        Stack s = new Stack();
        
        //Test for EmptyStackException by executing pop when stack is empty
        //s.pop();
        //Test for EmptyStackException by executing peek when stack is empty
        //s.peek();
        
        System.out.println("Insertion of 10 characters in s");
        //Test for IndexOutOfBoundsException by adding more than 100 items        
        //for (int i = 0; i < 101; i++)
        
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
