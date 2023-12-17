/****************************
*  Week 7 lab - exercise 1: *
*   using the class vector  *
*****************************/

#include <iostream>
#include <vector>

using namespace std;

int main()
{
	vector<int> v;

	//list creation
	for (int i=0; i<10; i++)
		v.push_back(rand()%100);

	for(int i=0; i<v.size(); i++)
		cout << v[i] << " ";
	cout << endl;


	return 0;
}