package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R183_Div2_D //Name: R214_Div2_#
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
        int x = in.nextInt();
        int y = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int g = GCD_Euclid(a, b);
        a = a / g;
        b = b / g;

        int t = Math.min(n / a, m / b);
        a *= t;
        b *= t;

        int x1, y1, x2, y2;
        x1 = x - a + (a / 2);
        y1 = y - b + (b / 2);
        x1 = Math.min(x1, n - a);
        y1 = Math.min(y1, m - b);
        x1 = Math.max(x1, 0);
        y1 = Math.max(y1, 0);
        x2 = x1 + a;
        y2 = y1 + b;
        out.println(x1 + " " + y1 + " " + x2 + " " + y2);
	}
	
    static int GCD_Euclid(int a, int b)
    {
        if (b == 0) return a;
        return GCD_Euclid(b, a % b);
    }
}
