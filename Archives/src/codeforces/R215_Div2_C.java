package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R215_Div2_C //Name: Sereja and Algorithm
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
		String st = in.next();
		int n = st.length();
		int[] x = new int[n+1];
		int[] y = new int[n+1];
		int[] z = new int[n+1];
		int xx = 0, yy = 0, zz = 0;
		
		for (int i = 1; i <= n; i++)
		{
			char c = st.charAt(i-1);
			if (c == 'x') xx++;
			if (c == 'y') yy++;
			if (c == 'z') zz++;
			x[i] = xx; y[i] = yy; z[i] = zz;
		}
		
		int m = in.nextInt();
		
		int l, r, xnum, ynum, znum;
		
		for (int t = 0; t < m; t++)
		{
			l = in.nextInt();
			r = in.nextInt();
			xnum = x[r] - x[l-1];
			ynum = y[r] - y[l-1];
			znum = z[r] - z[l-1];
			int max = (Math.max(xnum, ynum));
			max = (Math.max(max, znum));
			int min = (Math.min(xnum, ynum));
			min = (Math.min(min, znum));
			if (r-l < 2)
				out.println("YES");
			else if (max - min > 1) 
				out.println("NO");
			else
				out.println("YES");
		}	
	}
}
