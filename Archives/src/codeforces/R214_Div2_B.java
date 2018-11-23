package codeforces;
import java.io.PrintWriter;
import java.util.*; //Scanner;

public class R214_Div2_B  //Name: Dima and To-do List
{
	public static void main(String[] args) {
		Scanner      in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		solve(in, out);
		out.close();
		in.close();	
	}
	
	public static void solve(Scanner in, PrintWriter out)
	{
		int n = in.nextInt();
		int k = in.nextInt();

		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = in.nextInt();
		
		int sum, min = Integer.MAX_VALUE, ind = -1;
		for (int i = 0; i < k; i++)
		{
			sum = 0;		
			for (int j = i; j < n; j += k)
				sum += a[j];
			if (sum < min)
			{
				min = sum;
				ind = i;
			}
		}			

		out.println(ind+1);
	}
}
