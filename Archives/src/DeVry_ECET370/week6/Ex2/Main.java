package week6.Ex2;

/**************************************
*  Week 6 lab - exercise 2:           *
*   implementing a binary search tree *
*   and display BST using toString()  *
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
        
        //Display BST in sorted order, using overridden toString()
        System.out.println("Display BST in sorted order, using overridden toString():");
        System.out.println(bst.toString());  
    }
}
