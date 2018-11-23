package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R221_Div2_A
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
		String s = in.next();
		int n = s.length();
		int m = s.indexOf('^');	
		long l = 0, r = 0;

		for (int i = 0; i < m; i++)
			if (s.charAt(i) != '=')
				l += ((s.charAt(i) - '0') * (m-i));
		
		for (int i = m+1; i < n; i++)
			if (s.charAt(i) != '=')
				r += ((s.charAt(i) - '0') * (i-m));
		
		if (l == r)
			out.println("balance");
		else if (l < r)
			out.println("right");
		else // (l > r)
			out.println("left");
	}
}
