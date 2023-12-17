package week6.Ex5;
import java.util.*;

/**************************************
*  Week 6 lab - exercise 5:           *
*   implementing a binary search tree *
*   with methods preorderDiaplay and  *
*   postorderDiaplay to print items   *
*   in the BST listed in preorder and *
*   postorder, respectively.          *
***************************************/

/**
 * Class implementing a binary search tree.
 */
public class BinarySearchTree
{
    /**
     * Initializes the bst to empty creating a dummy root node.
     */
    @SuppressWarnings("unused")
	public BinarySearchTree()
    {
        root = new Node();        //dummy node as the root
        root.setLeftChild(null);
        root.setRightChild(null);
        root.setInfo(-1);
        
        //Integer[] a = new Integer[5];
        ArrayList<Integer> a = new ArrayList<>();
        //boolean b = a.contains(1);
        //int i = Collections.binarySearch(a, 1);
        int[] s = new int[350_000_000];
    }

    /**
     * Determines whether the bst is empty
     *
     * @return true if the bst is empty, false otherwise
     */
    public boolean isEmpty()
    {
        return root.getLeftChild() == null;
    }

    /**
     * Prints the bst elements using inorder traversal. This method invokes the
     * private method inorderDisplay, passing to it the root of the actual tree.
     */
    public void display()
    {
        inorderDisplay(root.getLeftChild());
        System.out.println();
    }
    
    /**
     * Prints the bst elements using preorder traversal. This method invokes the
     * private method preorderDisplay, passing to it the root of the actual tree.
     */
    public void displayPreOrder()
    {
        preorderDisplay(root.getLeftChild());
        System.out.println();
    }
    
    /**
     * Prints the bst elements using postorder traversal. This method invokes the
     * private method postorderDisplay, passing to it the root of the actual tree.
     */
    public void displayPostOrder()
    {
        postorderDisplay(root.getLeftChild());
        System.out.println();
    }

    /**
     * Determines if an item exists in the bst. This method invokes the private
     * method search, passing to it the element to be found and the root
     * of the actual tree.
     * 
     * @param x element to be found.
     * @return true if x is found in the bst, false otherwise.
     */
    public boolean contains(int x)
    {
        return search(x, root.getLeftChild());
    }

    /**
     * Adds the element x to the bst. This method invokes the private method
     * insert, passing to it the element to be added to the bst and the root
     * of the actual tree.
     *
     * @param x element to be added to the bst.
     */
    public void add(int x)
    {
        if (root.getLeftChild() == null)
        {
            Node p = new Node();
            p.setNode(x, null, null);
            root.setLeftChild(p);
        } else
            insert(x, root.getLeftChild());
    }

    /**
     * Finds the smallest element in the bst. This method invokes the overloaded
     * method getMin, passing to it the root of the tree.
     *
     * @return the smallest element in the bst.
     */
    public int getMin()
    {
        return getMin(root);
    }
    
    private Node root;    //root of the bst. It's implemented as a dummy node.

    /**
     * Prints the elements of the subtree whose root is referenced by p. Uses
     * inorder traversal.
     *
     * @param p root of subtree.
     */
    private void inorderDisplay(Node p)
    {
        if (p != null)
        {
            inorderDisplay(p.getLeftChild());
            System.out.print(p.getInfo() + " ");
            inorderDisplay(p.getRightChild());
        }
    }
    
    /**
     * Prints the elements of the subtree whose root is referenced by p. Uses
     * preorder traversal.
     *
     * @param p root of subtree.
     */
    private void preorderDisplay(Node p)
    {
        if (p != null)
        {
            System.out.print(p.getInfo() + " ");
            preorderDisplay(p.getLeftChild());
            preorderDisplay(p.getRightChild());
        }
    }
    
    /**
     * Prints the elements of the subtree whose root is referenced by p. Uses
     * postorder traversal.
     *
     * @param p root of subtree.
     */
    private void postorderDisplay(Node p)
    {
        if (p != null)
        {
        	postorderDisplay(p.getLeftChild());
        	postorderDisplay(p.getRightChild());
            System.out.print(p.getInfo() + " ");
        }
    }
    
 

    /**
     * Finds if x is inserted in the subtree whose root is referenced by p. The
     * search is conducted recursively, using the bst property: keys in the left
     * subtree of a node are smaller than or equal to the key in the node, while
     * the keys in the right subtree of the node are greater.
     *
     * @param x element to be found.
     * @param p root of subtree.
     * @return true if x is found in this subtree, false otherwise.
     */
    private boolean search(int x, Node p)
    {
        if (p == null)
            return false;
        else if (x == p.getInfo())
            return true;
        else if (x < p.getInfo())
            return search(x, p.getLeftChild());
        else
            return search(x, p.getRightChild());
    }

    /**
     * Adds x to the subtree referenced by p. The search for the location to
     * insert the new node is conducted recursively, using the bst property:
     * keys in the left subtree of a node are smaller than or equal to the key
     * in the node, while the keys in the right subtree of the node are greater.
     *
     * @param x element to be added to the subtree.
     * @param p root of subtree.
     */
    private void insert(int x, Node p)
    {
        if (x < p.getInfo())
            if (p.getLeftChild() == null)
            {
                Node q = new Node();
                q.setNode(x, null, null);
                p.setLeftChild(q);
            } else
                insert(x, p.getLeftChild());
        else if (p.getRightChild() == null)
        {
            Node q = new Node();
            q.setNode(x, null, null);
            p.setRightChild(q);
        } else
            insert(x, p.getRightChild());
    }

    /**
     * Recursively finds the smallest element in the subtree referenced by p.
     * The method uses this property of BSTs: the smallest value is stored in
     * the leftmost node.
     *
     * @param p root of subtree.
     * @return smallest element in the subtree referenced by p.
     */
    private int getMin(Node p)
    {
        if (p.getLeftChild() == null)
            return p.getInfo();
        else
            return getMin(p.getLeftChild());
    }
}
