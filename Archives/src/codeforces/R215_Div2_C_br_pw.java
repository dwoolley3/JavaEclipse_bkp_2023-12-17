package codeforces;

//import java.util.*; //Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter; //PrintWriter

public class R215_Div2_C_br_pw
{
	public static void main(String[] args) throws IOException {
		//Scanner      in = new Scanner(System.in);
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter   out = new PrintWriter(System.out);
		//Reading 100,000 numbers on a line takes 3 times longer with Scanner
		//Scanner = 436ms; BufferedReader w/split = 186ms; w/o split = 124ms
		//For 200,000 numbers on a line: Scanner = 810ms; BR w/split = 280ms.
		//Thus, use BufferedReader instead of Scanner if time is critical.
		solve(in, out);
		out.close();
		in.close();	
	}
	
	public static void solve(BufferedReader in, PrintWriter out) throws IOException
	{
		String st = in.readLine();
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
		
		int m = Integer.parseInt(in.readLine());
		
		int l, r, xnum, ynum, znum;
		
		for (int t = 0; t < m; t++)
		{
			String[] s = in.readLine().split("\\s+");
			l = Integer.parseInt(s[0]);
			r = Integer.parseInt(s[1]);
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

