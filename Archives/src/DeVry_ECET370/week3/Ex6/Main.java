package week3.Ex6;

/*******************************************************************
*  Week 3 lab - exercise 6:										   *
*   a simple Queue class    									   *
*   with error messages    										   *
*   utilized to simulate a small airport with one runway.          *
*   Airplanes waiting to take off join a queue on the ground.      *
*   Planes waiting to land join a queue in the air.                *
*   Only one plane can use the runway at any given time.           *
*   All planes in the air must land before any plane can take off. *
*******************************************************************/

/**
 * Class to utilize the Queue class by simulating a small airport.
 */
public class Main
{

    public static void main(String[] args)
    {
    	//Two queues define airplanes waiting to take off
    	//and airplanes waiting to land.
        Queue airplanesWaitingToTakeOff = new Queue();
        Queue airplanesWaitingToLand = new Queue();
        
        //Repeatedly, randomly simulate one of four options:
        //0 - Add airplane to queue, waiting to take off
        //1 - Add airplane to queue, waiting to land
        //2 - Remove airplane from queue, waiting to land
        //3 - Remove airplane from queue, waiting to take off
        //Note: To remove an airplane from queue waiting to take off,
        //      the queue of airplanes waiting to land must be empty;
        //      otherwise, allow one airplane to land.
              
        for (int i = 0; i < 15; i++)
        {
            int x = (int) (Math.random() * 4);
            if (x == 0)
            {
            	char y = (char)('A' + (int) (Math.random() * 26));
            	System.out.println("Add airplane to Take Off: " + y);
            	airplanesWaitingToTakeOff.enqueue(y);
            }
            else if (x == 1)
            {
            	char y = (char)('A' + (int) (Math.random() * 26));
            	System.out.println("Add airplane to Land: " + y);
            	airplanesWaitingToLand.enqueue(y);
            }
            else if (x == 2)
            {
            	System.out.println("Is an airplane waiting to land? " 
            			+ !airplanesWaitingToLand.isEmpty());
            	if (!airplanesWaitingToLand.isEmpty())
            	{
            		System.out.println(" - Airplane landed: "
        				+ airplanesWaitingToLand.getFront()); 
            		airplanesWaitingToLand.dequeue();
            	}
            }
            else if (x == 3)
            {
            	System.out.println("Is an airplane waiting to take off? " 
            			+ !airplanesWaitingToTakeOff.isEmpty());
            	if (!airplanesWaitingToTakeOff.isEmpty())
            	{
                	System.out.println(" - Is an airplane waiting to land? " 
                			+ !airplanesWaitingToLand.isEmpty());
                	if (!airplanesWaitingToLand.isEmpty())
                	{
                		System.out.println("   - Can't take off yet until all airplanes land.");
                		System.out.println("   - Airplane landed: "
            				+ airplanesWaitingToLand.getFront()); 
                		airplanesWaitingToLand.dequeue();
                	}
                	else
                	{
                		System.out.println(" - Airplane took off: "
                			+ airplanesWaitingToTakeOff.getFront());
                		airplanesWaitingToTakeOff.dequeue();
                	}
            	}
            }
        }
    }
}
