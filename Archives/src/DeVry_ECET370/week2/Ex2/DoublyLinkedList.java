package week2.Ex2;

/******************************
*  Week 2 lab - exercise 2:   *
*   a doubly LinkedList class *
*******************************/

/**
 * Class implementing a doubly linked list.
 */
public class DoublyLinkedList
{

    private Node first;  //dummy header node
    private Node last;   //dummy trailer node

    /**
     * Initializes the list to empty creating a dummy header node
     * and a dummy trailer node. Link first and last, initially.
     */
    public DoublyLinkedList()
    {
        first = new Node();
        last = new Node();
        first.setNext(last);
        last.setPrev(first);
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
     * Prints the list elements, from first to last.
     */
    public void display()
    {
        Node current = first.getNext();

        while (current.getNext() != null)
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
        Node nodeAfter = first.getNext();
        
        //Set the info, next, and prev items for the inserted node
        p.setInfo(x);
        p.setNext(nodeAfter);			 
        p.setPrev(nodeAfter.getPrev());	 //For newly inserted node, set prev to first
        
        //Set the prev reference for the node after the newly inserted node
        nodeAfter.setPrev(p);      
        //Set the fist node's next reference to the newly inserted node
        first.setNext(p);        
    }
    
    /**
     * Adds the element x to the end of the list. 
     *
     * @param x element to be added to the list
     */
    public void addEnd(int x)
    {
        Node p = new Node();
        Node nodeBefore = last.getPrev();
        
        //Set the info, next, and prev items for the inserted node
        p.setInfo(x);
        p.setPrev(nodeBefore);			 
        p.setNext(nodeBefore.getNext());  //For newly inserted node, set next to last
        
        //Set the prev reference for the node after the newly inserted node
        nodeBefore.setNext(p);      
        //Set the last node's next reference to the newly inserted node
        last.setPrev(p);        
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
        	//p is previous node to the old node being removed
        	//nodeAfter is the node after the old node being removed
        	//Link the previous node to the nodeAfter and vice-versa
            
        	Node nodeAfter = old.getNext();
            p.setNext(nodeAfter);
            nodeAfter.setPrev(p);
        }
    }
    
    /**
     * Prints the list elements in reverse order, from last to first.
     */
    public void displayInReverse()
    {   
        Node current = last.getPrev();

        while (current.getPrev() != null)
        {
            System.out.print(current.getInfo() + " ");
            current = current.getPrev();
        }

        System.out.println();
    }
}