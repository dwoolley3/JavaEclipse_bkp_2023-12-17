package week2.Ex4;


/***********************************
*  Week 2 lab - exercise 4:        *
*   a class bag (multiset) that    *
*   uses an linked list to         *
*   store bag items. The bag will  *
*   store strings of characters.   *
***********************************/

/**
 * Class implementing a linked list based bag,
 * where the size expands/retracts dynamically as needed.
 */
public class Bag
{
    private Node first;  //dummy header node    
    private int length;	 //amount of items in the bag
   
    /**
     * Default constructor. Sets length to 0 and 
     * initializes the list/bag to empty creating a dummy header node.
     */
    public Bag()
    {
    	first = new Node();
        length = 0;
    }
   
    /**
     * Determines whether the bag is empty
     *
     * @return true if the bag is empty, false otherwise
     */
    public boolean isEmpty()
    {
        //return length == 0;
        return (first.getNext() == null);
    }

    /**
     * Prints the bag elements, 10 per line.
     * Traverse each item in list using node's getNext() method.
     */    
    public void print()
    {
        Node current = first.getNext();

        int cnt = 0;
        while (current != null)
        {
            System.out.print(current.getInfo() + " ");
            if (++cnt % 10 == 0) 
            	System.out.println();
            current = current.getNext();
        }

        System.out.println();
    }
    
    /**
     * Returns the number of items in the bag
     * @return the number of items in the bag
     */
    public int getLength()
    {
    	return length;
    }
    
    /**
     * Removes all of the items from the bag, by setting the first
     * dummy header node to null, thus causing all prior items to be
     * unlinked from the head. As a result, they will be deallocated.
     * Length becomes 0.
     */    
    public void clear()
    {
    	first.setNext(null);
    	length = 0;
    }

    /**
     * Adds an item to the beginning of the list/bag.
     * Bag length is increased by 1.
     *
     * @param item to be added to the bag
     */
    public void add(String item)
    {
        Node p = new Node();

        p.setInfo(item);
        p.setNext(first.getNext());

        first.setNext(p);
        length++;
    }

    /**
     * Removes item from the list/bag; only one of item is removed
     * (the first occurrence of the item in the list)
     * and Bag length is decreased by 1.
     *
     * @param item to be removed
     */
    public void removeOne(String item)
    {
        Node old = first.getNext(),
                p = first;

        //Finding the reference to the node before the one to be deleted
        boolean found = false;
        while (old != null && !found)
        {
            if (old.getInfo() == item)
            {
                found = true;
            } else
            {
                p = old;
                old = p.getNext();
            }
        }

        //if item is in the list, remove it.
        if (found)
        {
            p.setNext(old.getNext());
            length--;
        }
    }
   
    /**
     * Removes all occurrences of item from the bag.
     * Bag length is decreased by 1 each time.
     *
     * @param item to be removed
     */
    public void removeAll(String item)
    {
        Node old = first.getNext(),
                p = first;

        boolean found = false;
        do
        {
	        //Finding the reference to the node before the one to be deleted
	        found = false;
	        while (old != null && !found)
	        {
	            if (old.getInfo() == item)
	            {
	                found = true;
	            } 
	            else
	            {
	                p = old;
	                old = p.getNext();
	            }
	        }
	
	        //if item is in the list, remove it,
	        //by linking prior node to the node after the old node	       
	        if (found)
	        {
	            p.setNext(old.getNext());
	            length--;
	            
	            old = p;  //set old to current node p, 
	            //rather than starting at first again for next loop.
	            //Any occurrences of item up to p have already been removed.
	        }
	        
        } while(found);
    }
    
    /**
     * Return the count of occurrences of an item in bag
     * @param item to be counted within bag
     * @return count of same item in bag
     */
    public int count(String item)
    {
    	int counter = 0;
        Node current = first.getNext();

        while (current != null)
        {
        	if (item.equals(current.getInfo())) 
    			counter++;

            current = current.getNext();
        }
    	return counter;
    }
}
