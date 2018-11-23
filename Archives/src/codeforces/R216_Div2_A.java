package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R216_Div2_A //Name: 
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
		int m = in.nextInt();
		int k = in.nextInt();
		
		int cnt = 0, a;
		for (int i = 0; i < n; i++) 
		{
			a = in.nextInt();
			if (a == 1) 
				if (m > 0) m--;
				else cnt++;
			else // a== 2
				if (k > 0) k--;
				else if (m > 0) m--;
				else cnt++;				
		}	
		
		out.println(cnt);		
	}
}
