package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R228_Div2_C
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
		int[] d = new int[101];
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
		{
			a[i] = in.nextInt();
			d[a[i]]++;
		}
		int lastInd = -1;
		int[] b = new int[n];
		for (int i = 0; i < 101; i++)
		{
			if (d[i] > 0)
			{
				int cnt = d[i];
				for (int j = 0; j <= lastInd && cnt > 0; j++)
					while (b[j] <= i && cnt > 0)
					{
						b[j]++;
						cnt--;
					}
				while (cnt > 0)
				{
					lastInd++;
					while (b[lastInd] <= i && cnt > 0)
					{
						b[lastInd]++;
						cnt--;
					}
				}
			}
				
		}
	
		out.println(lastInd+1);		
	}
}
