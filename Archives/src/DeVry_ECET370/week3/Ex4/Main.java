package week3.Ex4;

/****************************
*  Week 3 lab - exercise 4: *
*   a simple Queue class    *
*****************************/

/**
 * Class to test the Queue class.
 */
public class Main
{

    public static void main(String[] args)
    {
        Queue q = new Queue();

        System.out.println("Insertion of 10 characters in q");
        for (int i = 0; i < 10; i++)
        {
            int x = 32 + (int) (Math.random() * 95);
            System.out.println(x + " --> " + (char) x);
            q.enqueue((char) x);
        }

        System.out.println("\nDisplaying and deleting elements");
        for (int i = 0; i < 10; i++)
        {
            System.out.println("Item at the front: " + q.getFront());

            q.dequeue();
        }
    }
}
