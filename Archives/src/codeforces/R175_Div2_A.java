package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R175_Div2_A //Name: Slightly Decreasing Permutations
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
		int k = in.nextInt();
		
		StringBuilder sb = new StringBuilder();
        for (int i = k+1; i >= 1; i--)
            sb.append(i + " ");
        for (int i = k+2; i <= n; i++)
            sb.append(i + " ");
		
		out.println(sb);		
	}
}
