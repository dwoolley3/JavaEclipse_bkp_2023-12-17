package week6.Ex3;

/**************************************
*  Week 6 lab - exercise 3:           *
*   implementing a binary search tree *
*   for a SimpleBag class             *
***************************************/

/**
 * Class testing the Simple Bag implemented as a binary search tree.
 */
public class Main
{
    public static void main(String[] args)
    {
    	//Create an empty bag
        SimpleBag mySimpleBag = new SimpleBag();
    	System.out.println("My Simple Bag is Empty = " + mySimpleBag.isEmpty());
    	
    	//Populate bag by adding items
    	int numItems = 10;
    	System.out.println("Adding " + numItems + " items between 0 and 9 to my Bag:");
        int numItemsToFind = 5;
        for (int i = 0; i < numItems; i++)
        {
            int x = (int) (Math.random() * 10);
            System.out.print(x + " ");
            mySimpleBag.add(x);
        }
        System.out.println();
       	System.out.println("My Simple Bag is Empty = " + mySimpleBag.isEmpty());

       	//Print the SimpleBag elements. Since it is stored in a BST, items are displayed in sorted order
        System.out.println();
        System.out.println("Print my Simple Bag:");
        mySimpleBag.print();
        
        //Count number of occurrences of several items
        for (int i = 0; i < numItemsToFind; i++)
        {
        	 int itemToFind = (int) (Math.random() * 10);      
        	 System.out.print("Count number of occurrences of item " + itemToFind);
        	 System.out.println(" = " + mySimpleBag.count(itemToFind));
        }
        
        //Clear Bag and check if it is empty
        System.out.println();
        System.out.println("Clearing all items from the bag:"); 
        mySimpleBag.clear();
    	System.out.println("My Simple Bag is Empty = " + mySimpleBag.isEmpty());
    	
    	
    	//Populate bag by adding items
    	System.out.println("Adding " + numItems + " items between 0 and 9 to my Bag:");
        for (int i = 0; i < numItems; i++)
        {
            int x = (int) (Math.random() * 10);
            System.out.print(x + " ");
            mySimpleBag.add(x);
        }
        System.out.println();
       	System.out.println("My Simple Bag is Empty = " + mySimpleBag.isEmpty());

       	//Print the SimpleBag elements. Since it is stored in a BST, items are displayed in sorted order
        System.out.println();
        System.out.println("Print my Simple Bag:");
        mySimpleBag.print();
        
        //Count number of occurrences of several items
        for (int i = 0; i < numItemsToFind; i++)
        {
        	 int itemToFind = (int) (Math.random() * 10);      
        	 System.out.print("Count number of occurrences of item " + itemToFind);
        	 System.out.println(" = " + mySimpleBag.count(itemToFind));
        }
    }
}
