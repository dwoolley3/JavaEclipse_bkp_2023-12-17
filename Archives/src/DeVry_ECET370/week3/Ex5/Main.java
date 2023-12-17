package week3.Ex5;

/****************************
*  Week 3 lab - exercise 5: *
*   a simple Queue class    *
*   with error messages     *
*****************************/

/**
 * Class to test the Queue class.
 */
public class Main
{

    public static void main(String[] args)
    {
        Queue q = new Queue();
        
        //Test for NoSuchElementException by executing dequeue when queue is empty
        //q.dequeue();
        //Test for NoSuchElementException by executing getFront when queue is empty
        //q.getFront();

        System.out.println("Insertion of 10 characters in q");
        //Test for IndexOutOfBoundsException by adding more than 100 items        
        //for (int i = 0; i < 101; i++)
        
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
