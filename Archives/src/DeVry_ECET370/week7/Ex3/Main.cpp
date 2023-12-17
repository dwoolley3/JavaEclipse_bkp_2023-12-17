/****************************
*  Week 7 lab - exercise 3: *
*   using the class vector  *
*   store the first 20      *
*   factorials in a vector  *
*****************************/

#include <iostream>
#include <vector>

using namespace std;

int main()
{
	vector<long long> v;

	//list creation of factorials 1!, 2!, 3!, ... 20!
	v.push_back(1);
	for (int i=1; i<=20; i++)
		v.push_back(v[i-1] * i);

	for(int i=1; i<=20; i++)
		cout << v[i] << " ";
	cout << endl;


	return 0;
}