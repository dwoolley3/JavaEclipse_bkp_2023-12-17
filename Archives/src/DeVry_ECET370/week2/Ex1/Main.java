package week2.Ex1;

/******************************
*  Week 2 lab - exercise 1:   *
*   a simple LinkedList class  *
*******************************/

public class Main
{
	public static void main(String args[])
	{
		LinkedList intList = new LinkedList();

		System.out.print("List of numbers before list creation: ");
		for (int i =0; i < 10; i++)
		{
			int info = (int)(Math.random()*10);
			System.out.print(info + " ");

			intList.add(info);			
		}

		System.out.print("\nList of numbers after list creation:  ");

		intList.display();
		
		System.out.print("\nRemove item #2 and #4 from list and display: ");
		intList.remove(2);
		intList.remove(4);
		intList.display();
	}
}

