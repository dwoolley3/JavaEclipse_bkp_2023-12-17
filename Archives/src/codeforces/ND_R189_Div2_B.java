package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class ND_R189_Div2_B //Name: Ping-Pong (Easy Version)
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
		
		int[] a = new int[n];
		for (int i = 0; i < n; i++) 
			a[i] = in.nextInt();
		
		String s = in.next();
		
		StringBuilder sb = new StringBuilder(s + k);
		sb.append("\r\n");
		
		out.println(sb);		
	}
}
