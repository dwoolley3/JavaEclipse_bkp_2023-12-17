package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R223_Div2_A
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
		
		int[] a = new int[n];
		for (int i = 0; i < n; i++) 
			a[i] = in.nextInt();
		
		int i = 0, j = n-1;
		int turn = 0;
		int[] pl = new int[2];
		while (i <= j)
		{
			if (a[i] >= a[j])
			{
				pl[turn] += a[i];
				i++;
			}
			else
			{
				pl[turn] += a[j];
				j--;
			}
			turn = (1 - turn);
		}
		
		out.println(pl[0] + " " + pl[1]);		
	}
}
