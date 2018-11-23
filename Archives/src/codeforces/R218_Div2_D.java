package codeforces;
//import java.util.*; //Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter; //PrintWriter
import java.util.TreeSet;   //TreeSet

public class R218_Div2_D //Name: Vessels
{
	public static void main(String[] args) throws IOException {
		//Scanner      in = new Scanner(System.in);
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter   out = new PrintWriter(System.out);
		solve(in, out);
		out.close();
		in.close();	
	}
	
	//Key: Vessels can be skipped during the algorithm when they become full.
	//Key: TreeSet can be used to store indices of unfilled vessels, and
	//     removing them from the tree when full. Overflows occur to the next
	//     unfilled vessel using tree function "higher" or "ceiling".
	
	public static void solve(BufferedReader in, PrintWriter out) throws IOException
	{
		int n = Integer.parseInt(in.readLine());
		
		String[] s = in.readLine().split(" ");
		int[] a = new int[n+1];
		TreeSet<Integer> set = new TreeSet<Integer>();
		for (int i = 0; i < n; i++) 
		{
			a[i+1] = Integer.parseInt(s[i]);
			set.add(i+1);
		}
		int[] b = new int[n+1];
		
		int m = Integer.parseInt(in.readLine());
		
		StringBuilder sb = new StringBuilder();
		int t, k, p,x;
		for (int i = 0; i < m; i++) 
		{
			s = in.readLine().split(" ");
			t = Integer.parseInt(s[0]);
			if (t == 1)
			{
				p = Integer.parseInt(s[1]);
				x = Integer.parseInt(s[2]);
				
				while (x > 0)
				{
					//Find next unfilled vessel
					Integer ind = set.ceiling(p);
					if (ind == null) break;  //no more vessels							
					b[ind] += x;
					if (b[ind] >= a[ind])
					{
						x = b[ind] - a[ind];					
						b[ind] = a[ind];
						set.remove(ind);					
					}
					else x=0;
				}
			}
			else // t== 2
			{
				k = Integer.parseInt(s[1]);
				sb.append(b[k]);
				sb.append("\n");
			}
		}
		out.print(sb);
	}

}
