package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R228_Div2_B
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
		
		char[][] c = new char[n][n];
		for (int i = 0; i < n; i++) 
		{
			String s = in.next();
			for (int j = 0; j < n; j++)
				c[i][j] = s.charAt(j);
		}
		boolean good = true;
		for (int i = 0; i < n && good; i++)
			for (int j = 0; j < n && good; j++)
			{
				if (c[i][j] == '#')
				{
					if (i<n-2 && j>0 && j < n-1 && c[i+1][j-1] == '#'
							&& c[i+1][j] == '#' && c[i+1][j+1] == '#'
							&& c[i+2][j] == '#')
					{ 
						c[i][j] = '.';
						c[i+1][j-1] = '.';
						c[i+1][j] = '.';
						c[i+1][j+1] = '.';
						c[i+2][j] = '.';
					}
					else 
						good = false;
				}
			}
		if (good)				
			out.println("YES");
		else
			out.println("NO");
	}
}
