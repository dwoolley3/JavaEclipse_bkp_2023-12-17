package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R227_Div2_A
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
		
		String[] s = in.next().split(":");
		String[] t = in.next().split(":");
		int h1 = Integer.parseInt(s[0]);
		int m1 = Integer.parseInt(s[1]);
		int h2 = Integer.parseInt(t[0]);
		int m2 = Integer.parseInt(t[1]);
		

		int m = m1 - m2;
		int h = h1 - h2;
		if (m < 0) 
		{
			m+= 60;
			h--;
		}
		if (h < 0) h += 24;
		
		if (h < 10)
			out.print("0");
		out.print(h+":");
		if (m < 10)
			out.print("0");
		out.println(m);

	}
}
