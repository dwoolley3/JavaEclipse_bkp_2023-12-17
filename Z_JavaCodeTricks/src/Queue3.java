

import java.util.LinkedList;

public class Queue3 {

	private LinkedList<Integer> data = new LinkedList<Integer>();
	public void enqueue(Integer item) 	{data.addLast(item);        }   
	public Integer dequeue() 			{return data.removeFirst(); } 
	public Integer peek() 				{return data.getFirst();    }
	public int size() 					{return data.size();        }
	public boolean isEmpty() 			{return data.isEmpty();     }
	
	public static void main(String[] args)
	{
		//Build & Print queue from customized class elements
		Queue3 q = new Queue3();
		for (int i = 1; i < 5; i++)
			q.enqueue(i);
		while (!q.isEmpty())
			System.out.println(q.dequeue());
		
		System.out.println("----");
		
		//Build & Print queue from Java elements
		LinkedList<Integer> queue = new LinkedList<Integer>();
		for (int i = 1; i < 5; i++)
			queue.add(i);         //same as addLast(i)
		while (!queue.isEmpty())
			System.out.println(queue.removeFirst());
	}

}
