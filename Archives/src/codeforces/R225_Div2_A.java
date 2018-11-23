package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R225_Div2_A //Name: Coder
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
		
		int cnt = (n*n+1)/2;
		out.println(cnt);
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
				if ((i+j) % 2 == 1)
					out.print('.');
				else
					out.print('C');
			out.println();
		}

	}
}
