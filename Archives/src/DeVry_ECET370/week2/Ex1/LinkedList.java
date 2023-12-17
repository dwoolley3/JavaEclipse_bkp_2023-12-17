package week2.Ex1;

/******************************
*  Week 2 lab - exercise 1:   *
*   a simple LinkedList class  *
*******************************/

/**
 * Class implementing a linked list.
 */
public class LinkedList
{

    private Node first;  //dummy header node

    /**
     * Initializes the list to empty creating a dummy header node.
     */
    public LinkedList()
    {
        first = new Node();
    }

    /**
     * Determines whether the list is empty
     *
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty()
    {
        return (first.getNext() == null);
    }

    /**
     * Prints the list elements.
     */
    public void display()
    {
        Node current = first.getNext();

        while (current != null)
        {
            System.out.print(current.getInfo() + " ");
            current = current.getNext();
        }

        System.out.println();
    }

    /**
     * Adds the element x to the beginning of the list.
     *
     * @param x element to be added to the list
     */
    public void add(int x)
    {
        Node p = new Node();

        p.setInfo(x);
        p.setNext(first.getNext());

        first.setNext(p);
    }

    /**
     * Deletes an item from the list. Only the first occurrence of the item in
     * the list will be removed.
     *
     * @param x element to be removed.
     */
    public void remove(int x)
    {
        Node old = first.getNext(),
                p = first;

        //Finding the reference to the node before the one to be deleted
        boolean found = false;
        while (old != null && !found)
        {
            if (old.getInfo() == x)
            {
                found = true;
            } else
            {
                p = old;
                old = p.getNext();
            }
        }

        //if x is in the list, remove it.
        if (found)
        {
            p.setNext(old.getNext());
        }

    }
}