package week6.Ex3;
import java.util.ArrayDeque;
import java.util.Deque;

/**************************************
*  Week 6 lab - exercise 3:           *
*    Class SimpleBag uses a binary    * 
*    search tree to store the bag     *
*    items                            *
***************************************/

/**
 * SimpleBag Class implementing a binary search tree.
 */
public class SimpleBag
{
    /**
     * Initializes the SimpleBag to empty creating a dummy root node.
     */
    public SimpleBag()
    {
        root = new Node();        //dummy node as the root
        root.setLeftChild(null);
        root.setRightChild(null);
        root.setInfo(-1);
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
    public void print()
    {
        inorderDisplay(root.getLeftChild());
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
    
    /**
     * Counts the number of occurrences of item.
     *
     * @return the number of occurrences of an item.
     */    
    public int count(int item)
    {
    	return count(item, root);
    }
    
    /**
     * Removes all of the items from the bag.
     */
    public void clear()
    {
    	//Set the root's children to null and clear the root's value.
        root.setLeftChild(null);
        root.setRightChild(null);
        root.setInfo(-1);
        //Java's garbage collection will remove all the other items
        //that are now orphans since the root does not point to them,
        //and thus there is no programmatic way to reach these items in memory.
        //Alternatively, we could perform a post-order traversal and
        //clear out two child leaves followed by its parent, and so on.
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
     * Override toString() method.
     * Accumulates the BST elements using in-order traversal. This method invokes the
     * private method inorderTraversal, passing to it the root of the actual tree.
     */
    @Override public String toString()
    {
    	return inorderTraversal(root.getLeftChild());
    }
    
    /**
     * Accumulate the sorted elements of the BST, whose root is referenced by p.
     * Uses in-order traversal.
     *
     * @param p root of Binary Search Tree.
     */
    private String inorderTraversal(Node p)
    {
    	//Textbook, p. 684, iterativeInorderTraverse()
    	//Carrano, Frank M., Timothy Henry. Data Structures and Abstractions with Java, 4th Edition. 
    	//Pearson Learning Solutions, 2014-08-01. VitalBook file.
    	
    	StringBuilder sortedElements = new StringBuilder();
    	
    	Deque<Node> nodeStack = new ArrayDeque<Node>();  
    	Node currentNode = p;
    	
    	while(!nodeStack.isEmpty() || currentNode != null)
    	{
    		//Find leftmost node with no left child
    		while (currentNode != null)
    		{
    			nodeStack.push(currentNode);
    			currentNode = currentNode.getLeftChild();
    		} // end while
    		
    		//Visit leftmost node, then traverse its right subtree
    		if (!nodeStack.isEmpty())
    		{
    			Node nextNode = nodeStack.pop();
    			assert nextNode != null;
    			
    			sortedElements.append(nextNode.getInfo() + " ");
    			currentNode = nextNode.getRightChild();
    		}
    	} // end while    	 	

        return sortedElements.toString();
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
     * Traverses the entire tree looking for occurrences of item x,
     * in the subtree whose root is referenced by p. The
     * search is conducted recursively, for both the left and right children.
     *
     * @param x element to be found and counted.
     * @param p root of subtree.
     * @return count of occurrences of item x.
     */
    private int count(int x, Node p)
    {
    	int found = 0;
        if (p == null)
            return 0;
        else {
        	if (x == p.getInfo()) found = 1;
        	return found 
    			+ count(x, p.getLeftChild())
    			+ count(x, p.getRightChild());
        }
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
