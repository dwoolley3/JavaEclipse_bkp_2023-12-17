package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R229_Rocket_A
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
		char prevC = s.charAt(0);
		int cnt = 0, contig = 1;
		for (int i = 1; i < s.length(); i++)
		{
			if (s.charAt(i) == prevC)
				contig++;
			else
			{
				if (contig % 2 == 0) cnt++;
				contig = 1;
				prevC = s.charAt(i);
			}
		}
		if (contig % 2 == 0) cnt++;
		
		out.println(cnt);		
	}
}
