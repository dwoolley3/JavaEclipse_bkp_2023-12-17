package week6;

import java.util.*;

public class queueTest {
    public static void main(String args[])        
    {
    	// Create a new, empty queue
    	Queue<Integer> queue = new LinkedList<Integer>();
    	for (int i = 10; i >= 1; i--)
            queue.add(i);

        while ( !queue.isEmpty() ) {
            System.out.print( queue.remove() );
            System.out.print ( ',' );     
        }
        //The queue is now empty
        System.out.println (" LIFT-OFF!"); 
    }
}