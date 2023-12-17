package week2.Ex2;

/******************************
*  Week 2 lab - exercise 2:   *
*   a doubly LinkedList class *
*******************************/

/**
 * Doubly Linked list node.
 */
public class Node
{
    private int info;   //element stored in this node
    private Node next;  //link to next node
    private Node prev;  //link to previous node

    /**
     * Initializes this node setting info to 0 and next to null
     * and prev to null
     */
    public Node()
    {
        info = 0;
        next = null;
        prev = null;
    }

    /**
     * Sets the value for this node
     *
     * @param i the desired value for this node
     */
    public void setInfo(int i)
    {
        info = i;
    }

    /**
     * Sets the link to the next node
     *
     * @param l node reference
     */
    public void setNext(Node l)
    {
        next = l;
    }
    
    /**
     * Sets the link to the previous node
     *
     * @param l node reference
     */
    public void setPrev(Node p)
    {
        prev = p;
    }

    /**
     * Returns the value in this node
     *
     * @return the value in this node
     */
    public int getInfo()
    {
        return info;
    }

    /**
     * Returns the link to the next node
     *
     * @return link to the next node
     */
    public Node getNext()
    {
        return next;
    }
    
    /**
     * Returns the link to the previous node
     *
     * @return link to the previous node
     */
    public Node getPrev()
    {
        return prev;
    }
}
