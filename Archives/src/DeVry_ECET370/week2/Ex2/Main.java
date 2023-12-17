package week2.Ex2;

/******************************
*  Week 2 lab - exercise 2:   *
*   a doubly LinkedList class *
*******************************/

public class Main
{
	public static void main(String args[])
	{
		DoublyLinkedList intList = new DoublyLinkedList();

		System.out.print("List of numbers before list creation: ");
		for (int i =0; i < 10; i++)
		{
			int info = (int)(Math.random()*10);
			System.out.print(info + " ");

			intList.add(info);
		}

		System.out.print("\nList of numbers after list creation:  ");
		intList.display();
		
		System.out.print("\nList of numbers in reverse:  ");
		intList.displayInReverse();
		
		System.out.print("\nList of numbers in normal order:  ");
		intList.display();
		System.out.print("\nRemove first items of #2, #3, and #4 from list");
		intList.remove(2);
		intList.remove(3);
		intList.remove(4);
		System.out.print("\nList of numbers in normal order:  ");
		intList.display();
		
		System.out.print("\nList of numbers in reverse:  ");
		intList.displayInReverse();
		
		System.out.print("\nAdd items 5, 6, and 7 to end of list");
		intList.addEnd(5);
		intList.addEnd(6);
		intList.addEnd(7);
		System.out.print("\nList of numbers in normal order:  ");
		intList.display();
		
		System.out.print("\nList of numbers in reverse:  ");
		intList.displayInReverse();
	}
}

