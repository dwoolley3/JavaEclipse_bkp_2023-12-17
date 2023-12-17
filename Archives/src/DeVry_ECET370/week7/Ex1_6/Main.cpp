/**********************************************
*  Week 7 lab - exercise 1:                   *
*   using the class stack and the class queue *
***********************************************/

#include <iostream>
#include <stack>
#include <queue>

using namespace std;

int main()
{
	stack<int> s;
	queue<int> q;
	
	for (int i = 0; i < 10; i++)
		s.push(rand()%21);
	
	while (!s.empty())
	{
		cout << s.top() << " ";
		q.push(s.top());
		s.pop();
	}

	cout << endl << endl;

	while (!q.empty())
	{
		cout << q.front() << " ";
		q.pop();
	}
	
	return 0;
}
