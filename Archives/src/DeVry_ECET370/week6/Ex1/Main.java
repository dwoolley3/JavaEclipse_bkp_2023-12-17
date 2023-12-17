package week6.Ex1;

/**************************************
*  Week 6 lab - exercise 1:           *
*   implementing a binary search tree *
***************************************/

/**
 * Class testing the binary search tree.
 */
public class Main
{

    public static void main(String[] args)
    {
        BinarySearchTree bst = new BinarySearchTree();
        for (int i = 0; i < 10; i++)
        {
            int x = (int) (Math.random() * 100);
            System.out.print(x + " ");
            bst.add(x);
        }

        System.out.println();
        bst.display();
    }
}
