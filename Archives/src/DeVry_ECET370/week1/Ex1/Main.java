package week1.Ex1;

/******************************
*  Week 1 lab - exercise 1:   *
*   a simple ArrayList class  *
*******************************/

/**
 * Class to test the ArrayList class.
 */
public class Main
{

    public static void main(String[] args)
    {
        ArrayList myList = new ArrayList();

        for (int i = 0; i < 20; i++)
        {
            myList.add((int) (Math.random() * 50));
        }

        myList.display();
        myList.removeAt(10);
        myList.display();
    }
}
