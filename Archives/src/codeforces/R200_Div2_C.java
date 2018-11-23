package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R200_Div2_C //Name: Rational Resistance
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
        long a = in.nextLong();
        long b = in.nextLong();

        long cnt = 0, x;
        while (b > 0)
        {
            cnt += (a / b);
            a %= b;
            x = a; a = b; b = x;
        }	
		out.println(cnt);		
	}
}
