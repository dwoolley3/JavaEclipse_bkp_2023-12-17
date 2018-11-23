package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R216_Div2_B //Name: R214_Div2_#
{
	public static void main(String[] args) {
		Scanner      in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		solve(in, out);
		out.close();
		in.close();	
	}

	@SuppressWarnings("unused")
	public static void solve(Scanner in, PrintWriter out)
	{
		int n = in.nextInt();	
		int k = in.nextInt();
		int l = in.nextInt();
		int r = in.nextInt();
		int sAll = in.nextInt();
		int sK = in.nextInt();
		
		int[] a = new int[n];
		
		int mid = sK / k;
		int midr = sK % k;
		for (int i = 0; i < k; i++)
			if (i < midr)
				a[i] = mid + 1;
			else
				a[i] = mid;

		if (n-k > 0)
		{
			int sum = sAll - sK;
			mid = sum / (n-k);
			midr = sum % (n-k);
			for (int i = 0; i < n-k; i++)
				if (i < midr)
					a[k+i] = mid + 1;
				else
					a[k+i] = mid;	
		}
		
		for (int i = 0; i < n; i++) 
			out.print(a[i] + " ");	
	}
}
