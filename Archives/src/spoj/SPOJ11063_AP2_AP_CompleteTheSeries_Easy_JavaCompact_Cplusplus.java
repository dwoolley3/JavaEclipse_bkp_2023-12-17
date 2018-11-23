package spoj;
import java.io.*;    //PrintWriter

//****  for SPOJ, class must be called M a i n

//TLE -- regardless of using BufferedReader or FastReader. Need to use C++.
//C++ code ran in 0.11 seconds, whereas Java and C# solution had TLE on test #7
public class SPOJ11063_AP2_AP_CompleteTheSeries_Easy_JavaCompact_Cplusplus
{	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		//Example: (3 - 2x) + ... + (8 + 2x) = 55; Number of terms = n
		// (3-2x + 8+2x)*N/2 = 55; 11*N/2 = 55; N = 110 / 11 = 10
		for (int T = 1; T <= t; T++) {		
			String[] s = in.readLine().split(" ");
			long left = Long.parseLong(s[0]);
			long right = Long.parseLong(s[1]);
			long sum = Long.parseLong(s[2]);
			long n = sum * 2 / (left + right);
			System.out.println(n);	
			//(8 - 3) = (n-5)x
			// 5 = nx - 5x
			// 5 = 10x - 5x; 5 = 5x; x = 1
			long x = (right - left) / (n-5);
			long start = left - 2 * x;
			long inc = 0;
			for (int i = 0; i < n-1; i++)	
			{
				System.out.print(start + inc + " ");
				inc += x;
			}
			System.out.println(start + inc);
		}
	}
}

////C++ code ran in 0.11 seconds, whereas Java and C# solution had TLE on test #7
//#include <iostream>
//#include <algorithm>
//using namespace std;
//int main() {
//int t;
//long long left, right, sum;
//cin >> t;
//for (int T = 1; T <= t; T++) {	
//  cin >> left;
//  cin >> right; 
//  cin >> sum;
//  long long n = sum * 2 / (left + right);
//  cout << n << endl;
//  //System.out.println(n);	
//  //(8 - 3) = (n-5)x
//  // 5 = nx - 5x
//  // 5 = 10x - 5x; 5 = 5x; x = 1
//  long long x = (right - left) / (n-5);
//  long long start = left - 2 * x;
//  long long inc = 0;
//  for (int i = 0; i < n-1; i++)	
//  {
//    //System.out.print(start + inc + " ");
//    cout << (start + inc) << ' ';
//    inc += x;
//  }
//  cout << (start + inc) << endl;
//}
//}