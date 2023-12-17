package week6.Ex5;

/**************************************
*  Week 6 lab - exercise 5:           *
*   implementing a binary search tree *
*   with methods preorderDiaplay and  *
*   postorderDiaplay to print items   *
*   in the BST listed in preorder and *
*   postorder, respectively.          *
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
        System.out.println("In Order Display:");
        bst.display();
        System.out.println("Pre Order Display:");
        bst.displayPreOrder();
        System.out.println("Post Order Display:");
        bst.displayPostOrder();
    }
}
