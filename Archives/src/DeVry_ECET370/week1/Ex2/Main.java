package week1.Ex2;

/*********************************
*  Week 1 lab - exercise 2:      *
*   an expanded ArrayList class  *
*********************************/

/**
 * Class to test the ArrayList class.
 */
public class Main
{

    public static void main(String[] args)
    {
        ArrayList myList = new ArrayList();

        for (int i = 0; i < 50; i++)
        {
            myList.add((int) (Math.random() * 50));
        }

        myList.display();
        myList.removeAt(10);
        myList.display();
    }
}
