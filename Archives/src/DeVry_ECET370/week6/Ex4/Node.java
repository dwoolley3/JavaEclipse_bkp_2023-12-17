package week6.Ex4;

/**************************************
*  Week 6 lab - exercise 4:           *
*   implementing a binary search tree *
*  with a recursive function getHeight*
*  that returns the height of the tree*
***************************************/

/**
 * Binary search tree node.
 */
public class Node
{

    private int info;     //element stored in this node
    private Node left;    //link to left child
    private Node right;   //link to right child

    /**
     * Initializes this node setting info to 0 and left and right children to
     * null.
     */
    Node()
    {
        info = 0;
        left = right = null;
    }

    /**
     * Sets this node.
     *
     * @param x the desired value for this node.
     * @param l node reference.
     * @param r node reference.
     */
    void setNode(int x, Node l, Node r)
    {
        info = x;
        left = l;
        right = r;
    }

    /**
     * Returns the value in this node.
     *
     * @return the value in this node.
     */
    int getInfo()
    {
        return info;
    }

    /**
     * Returns the link to the left child.
     *
     * @return link to the left child.
     */
    Node getLeftChild()
    {
        return left;
    }

    /**
     * Returns the link to the right child.
     *
     * @return link to the right child.
     */
    Node getRightChild()
    {
        return right;
    }

    /**
     * Sets the value for this node.
     *
     * @param x the desired value for this node.
     */
    void setInfo(int x)
    {
        info = x;
    }

    /**
     * Sets the link to the left child.
     *
     * @param l node reference.
     */
    void setLeftChild(Node l)
    {
        left = l;
    }

    /**
     * Sets the link to the right child.
     *
     * @param r node reference.
     */
    void setRightChild(Node r)
    {
        right = r;
    }
}
