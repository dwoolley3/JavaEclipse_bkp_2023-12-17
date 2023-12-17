package week1.Ex3;

/*********************************
*  Week 1 lab - exercise 3:      *
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

        for (int i = 0; i < 1000; i++)
        {
            myList.add((int) (Math.random() * 501));
        }

        myList.display();
        myList.removeAt(10);
        myList.display();
    }
}
