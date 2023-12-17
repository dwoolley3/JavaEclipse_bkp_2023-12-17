package week6.Ex4;

/**************************************
*  Week 6 lab - exercise 5:           *
*  implementing a binary search tree  *
*  with a recursive function getHeight*
*  that returns the height of the tree*
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
        
        //Test and display the height of a Binary Search Tree
        System.out.print("Height of BST is ");
        System.out.println(bst.getHeight());
    }
}
