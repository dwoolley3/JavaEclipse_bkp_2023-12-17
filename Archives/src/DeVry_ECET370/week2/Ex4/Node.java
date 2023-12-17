package week2.Ex4;

/******************************
*  Week 2 lab - exercise 4:   *
*  a Linked List node class   *
******************************/

/**
 * Linked list node.
 */
public class Node
{

    private String info;   //element stored in this node
    private Node next;     //link to next node

    /**
     * Initializes this node setting info to "" and next to null
     */
    public Node()
    {
        info = "";
        next = null;
    }

    /**
     * Sets the value for this node
     *
     * @param i the desired value for this node
     */
    public void setInfo(String s)
    {
        info = s;
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
     * Returns the value in this node
     *
     * @return the value in this node
     */
    public String getInfo()
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
}
