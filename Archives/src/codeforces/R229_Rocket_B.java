package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R229_Rocket_B
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
		int max = 0;
		for (int i = 0; i < n; i++)
		{
			int cnt = 1, lastPos = i;
			for (int j = i+1; j < n; j++)
				if (s.charAt(j) == s.charAt(i) && (j-lastPos) % 2 == 1)
				{
					cnt++;
					lastPos = j;
				}
			max = Math.max(max, cnt);					
		}
	
		out.println(max);		
	}
}
