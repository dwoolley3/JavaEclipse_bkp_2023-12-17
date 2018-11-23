package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R216_Div2_B_orig //Name: R214_Div2_#
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
		int l = in.nextInt();
		int r = in.nextInt();
		int sAll = in.nextInt();
		int sK = in.nextInt();
		
		int[] a = new int[n+1];
			
		int mid = sAll / n;
		int midr = sAll % n;
		
		for (int i = 0; i < n; i++)
		{
			a[i] = mid;
			if (i < midr) a[i]++;
		}
		
		int sum = 0;
		for (int i = 0; i < k; i++)
			sum += a[i];
		
		int dif = (sK - sum);
		mid = dif / k;
		midr = dif % k;
		
		for (int i = 0; i < k; i++)
		{
			int add = mid;
			if (i < midr) add++;
			a[i] = a[i] + add;
			if (a[i] > r)
			{
				a[i+1] += a[i] - r;
				a[i] = r;
			}
			int ind = n-1;
			while (add > 0 && ind >= 0)
			{
				if (a[ind] == l)
					ind--;
				else
				{
					a[ind]--;
					add--;
				}
			}
		}
		
		for (int i = 0; i < n; i++) 
			out.print(a[i] + " ");	
	}
}
