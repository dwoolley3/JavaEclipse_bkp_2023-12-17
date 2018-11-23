package codeforces;
import java.io.PrintWriter;
import java.util.*; //Scanner;

public class R214_Div2_A  //Name: Dima and Guards
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
		int g1c,g1j, g2c, g2j, g1, g2;
		boolean found = false;
		String ans = "";
		for (int i = 1; i <= 4; i++)
			{
				g1c = in.nextInt();
				g1j = in.nextInt();
				g1 = Math.min(g1c, g1j);
				g2c = in.nextInt();
				g2j = in.nextInt();
				g2 = Math.min(g2c, g2j);
						
				if (g1 + g2 <= n && !found)
				{
					ans = i + " " + g1 + " " + (n-g1);
					found = true;					
				}
			}

		if (!found) ans = "-1";
		out.println(ans);
	}
}
