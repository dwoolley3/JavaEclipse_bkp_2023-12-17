package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R188_Div2_A //Name: Even Odds
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
		long n = in.nextLong();	
		long k = in.nextLong();
		
        long odd = n / 2;
        if (n % 2 == 1) odd++;
        if (k <= odd)
        	out.println(k * 2 - 1);
        else
        	out.println((k - odd) * 2);	
	}
}
