/*******************************************************************
*  Week 7 lab - exercise 5:                                        *
*   STL Queue                                                      *
*   utilized to simulate a small airport with one runway.          *
*   Airplanes waiting to take off join a queue on the ground.      *
*   Planes waiting to land join a queue in the air.                *
*   Only one plane can use the runway at any given time.           *
*   All planes in the air must land before any plane can take off. *
********************************************************************/

#include <iostream>
#include <stack>
#include <queue>

using namespace std;

int main()
{
	queue<int> q;
	
    //Two queues define airplanes waiting to take off
	//and airplanes waiting to land.
    queue<int> airplanesWaitingToTakeOff; //= new Queue();
    queue<int> airplanesWaitingToLand; //= new Queue();
    
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
        int x = (rand()% 4);
        if (x == 0)
        {
        	char y = (char)('A' + (rand()%26));
        	cout << "Add airplane to Take Off: " << y << endl;
        	airplanesWaitingToTakeOff.push(y);
        }
        else if (x == 1)
        {
        	char y = (char)('A' + (rand()%26));
        	cout << "Add airplane to Land: " << y << endl;
        	airplanesWaitingToLand.push(y);
        }
        else if (x == 2)
        {
        	cout << "Is an airplane waiting to land? " 
        			<< (!airplanesWaitingToLand.empty() ? "YES" : "NO") << endl;
        	if (!airplanesWaitingToLand.empty())
        	{
        		cout << " - Airplane landed: "
    				<< (char)airplanesWaitingToLand.front() << endl; 
        		airplanesWaitingToLand.pop();
        	}
        }
        else if (x == 3)
        {
        	cout << "Is an airplane waiting to take off? " 
        			<< (!airplanesWaitingToTakeOff.empty()  ? "YES" : "NO")  << endl;
        	if (!airplanesWaitingToTakeOff.empty())
        	{
            	cout << " - Is an airplane waiting to land? " 
            			<< (!airplanesWaitingToLand.empty() ? "YES" : "NO") << endl;
            	if (!airplanesWaitingToLand.empty())
            	{
            		cout << "   - Can't take off yet until all airplanes land." << endl;
            		cout << "   - Airplane landed: "
        				<< (char)airplanesWaitingToLand.front() << endl; 
            		airplanesWaitingToLand.pop();
            	}
            	else
            	{
            		cout << " - Airplane took off: "
            			<< (char)airplanesWaitingToTakeOff.front() << endl;
            		airplanesWaitingToTakeOff.pop();
            	}
        	}
        }
    }
	
	return 0;
}
