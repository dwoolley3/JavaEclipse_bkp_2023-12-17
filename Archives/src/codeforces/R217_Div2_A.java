package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R217_Div2_A //Name: 
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
		int r1 = in.nextInt();	
		int c1 = in.nextInt();
		int r2 = in.nextInt();	
		int c2 = in.nextInt();
		
		int r, b, k;
		if (r1 == r2 || c1 == c2) r = 1; else r = 2;
		
		if ((r1+c1) % 2 != (r2+c2) % 2) 
			b = 0;
		else if (Math.abs(r1-r2) == Math.abs(c1-c2))
			b = 1; 
		else 
			b = 2;		
		
		k= Math.max(Math.abs(r1-r2), Math.abs(c1-c2));
		
		out.println(r + " " + b + " " + k);		
	}
}
