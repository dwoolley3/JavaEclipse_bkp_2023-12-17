package week2.Ex3;

/******************************
*  Week 2 lab - exercise 3:   *
*   a doubly LinkedList class *
*******************************/

public class Main
{
	public static void main(String args[])
	{
		DoublyLinkedList intList = new DoublyLinkedList();

		//Place prime numbers up to 100 in list in reverse order,
		//from 97, 89, 83 ... 5, 3, 2.
		//As a result, the list will contain the primes in increasing order,
		//since adding items to the beginning of a list places the 
		//entries in reverse order.
		System.out.print("List of numbers before list creation: ");
		for (int i = 100; i >= 1; i--)
		{
			if (isPrime(i))
			{
				int info = i;
				System.out.print(info + " ");
				intList.add(info);
			}
		}

		//The numbers are stored in such a way that when “display” is invoked,
		//the listing will be shown in increasing order: 
		//2, 3, 5, 7, 11, 13, 17, …
		System.out.print("\nDisplay list of numbers using display: ");
		intList.display();
		
		System.out.print("\nDisplay list of numbers in reverse:  ");
		intList.displayInReverse();
		
		System.out.print("\nDisplay list of numbers in normal order:  ");
		intList.display();
		System.out.print("\nRemove items 2, 5, and 97 fom list");
		intList.remove(2);
		intList.remove(5);
		intList.remove(97);
		System.out.print("\nList of numbers in normal order:  ");
		intList.display();
		
		System.out.print("\nList of numbers in reverse:  ");
		intList.displayInReverse();
//		
//		System.out.print("\nAdd items 5, 6, and 7 to end of list");
//		intList.addEnd(5);
//		intList.addEnd(6);
//		intList.addEnd(7);
//		System.out.print("\nList of numbers in normal order:  ");
//		intList.display();
//		
//		System.out.print("\nList of numbers in reverse:  ");
//		intList.displayInReverse();
	}
	
	//Determine if value n is Prime.
	//Prime numbers have only two factors: 1 and itself.
    static boolean isPrime(int n)
    {
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i * i <= n; i += 2)
            if (n % i == 0) return false;
        return true;
    }

}

