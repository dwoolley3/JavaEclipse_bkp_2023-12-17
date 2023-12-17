package week3.Ex5;

import java.util.NoSuchElementException;

/****************************
*  Week 3 lab - exercise 5: *
*   a simple Queue class    *
*   with error messages     *
*****************************/

/**
 * Class implementing a Queue ADT.
 */
public class Queue
{

    /**
     * Creates an empty queue with an array size of 100.
     */
    public Queue()
    {
        size = 100;
        list = new char[size];

        front = 0;
        back = size - 1;

        count = 0;
    }

    /**
     * Creates an empty queue using the array size passed as a parameter.
     *
     * @param s array size.
     */
    public Queue(int s)
    {
        size = s;
        list = new char[size];

        front = 0;
        back = size - 1;

        count = 0;
    }

    /**
     * Adds an element to the back of the queue.
     *
     * @param c element to be added to the queue.
     * @throws java.lang.IndexOutOfBoundsException if the 
     * 		back index reaches around to the front index;
     * 		otherwise the enqueue will overwrite the front item.
     */
    public void enqueue(char c)
    {
        back = (back + 1) % size;
        if (back == front && count > 0)
        	throw new IndexOutOfBoundsException();
        	
        list[back] = c;
        count++;
    }

    /**
     * Removes the element in the front of the queue.
     * 
     * @throws java.util.NoSuchElementException if this queue is empty
     */
    public void dequeue()
    {
    	if (isEmpty())
    		throw new NoSuchElementException("Queue underflow");
    	
        front = (front + 1) % size;
        count--;
    }

    /**
     * Returns the element at the front of the queue. Does not remove it.
     *
     * @return the element at the front of the queue.
     * @throws java.util.NoSuchElementException if this queue is empty
     */
    public char getFront()
    {
    	if (isEmpty())
    		throw new NoSuchElementException("Queue underflow");
    	
        return list[front];
    }

    /**
     * Determines whether the queue is empty.
     *
     * @return true if the queue is empty, false otherwise.
     */
    public boolean isEmpty()
    {
        return count == 0;
    }
    private char[] list;      //array to store the queue items
    private int size;         //size of the array
    private int count;        //number of items in the queue
    private int front, back;  //front and back locations
}
