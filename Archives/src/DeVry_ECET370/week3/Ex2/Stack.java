package week3.Ex2;

import java.util.EmptyStackException;

/****************************
*  Week 3 lab - exercise 2: *
*   a simple Stack class    *
*   with error messages     *
*****************************/

/**
 * Class implementing a Stack ADT.
 */
public class Stack
{

    /**
     * Creates an empty stack with an array size of 100.
     */
    public Stack()
    {
        size = 100;
        list = new char[size];
        n = 0;
    }

    /**
     * Creates an empty stack using the array size passed as a parameter.
     *
     * @param s array size.
     */
    public Stack(int s)
    {
        size = s;
        list = new char[size];
        n = 0;
    }

    /**
     * Adds an element to the top of the stack.
     *
     * @param c element to be added to the stack.
     * @throws java.lang.IndexOutOfBoundsException if the index reaches max size
     */
    public void push(char c)
    {
    	if (n == size)
    	{
    		throw new IndexOutOfBoundsException();
    	}
        list[n] = c;
        n++;
    }

    /**
     * Removes the element at the top of the stack.
     * @throws java.util.EmptyStackException if this stack is empty
     */
    public void pop()
    {
    	if (isEmpty())
    	{
    		throw new EmptyStackException();
    	}
        n--;
    }

    /**
     * Returns the element at the top of the stack. Does not remove it.
     *
     * @return the element at the top of the stack.
     * @throws java.util.EmptyStackException if this stack is empty
     */
    public char peek()
    {
    	if (isEmpty())
    	{
    		throw new EmptyStackException();
    	}
        return list[n - 1];
    }

    /**
     * Determines whether the stack is empty.
     *
     * @return true if the stack is empty, false otherwise.
     */
    public boolean isEmpty()
    {
        return n == 0;
    }
    private char[] list;   //array to store the stack items
    private int size;      //size of the array
    private int n;         //amount of items in the stack
}
