package week3.Ex4;

/****************************
*  Week 3 lab - exercise 4: *
*   a simple Queue class    *
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
     */
    public void enqueue(char c)
    {
        back = (back + 1) % size;
        list[back] = c;
        count++;
    }

    /**
     * Removes the element in the front of the queue.
     */
    public void dequeue()
    {
        front = (front + 1) % size;
        count--;
    }

    /**
     * Returns the element at the front of the queue. Does not remove it.
     *
     * @return the element at the front of the queue.
     */
    public char getFront()
    {
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
