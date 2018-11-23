package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R198_Div2_A //Name: The Wall
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
		int x = in.nextInt();	
		int y = in.nextInt();
		int a = in.nextInt();
		int b = in.nextInt();

        int lcm = LCM(x, y);
        int f = -1, l = -1;

        f = (a / lcm) * lcm;
        l = (b / lcm) * lcm;

        if (f < a) f += lcm;
        int cnt = 0;
        if (f <= l)
            cnt = (l - f) / lcm + 1;
		
		out.println(cnt);		
	}
	
    static int GCD(int a, int b)
    {
        if (b == 0) return a;
        return GCD(b, a % b);
    }
    static int LCM(int a, int b)
    {
        return a * b / GCD(a, b);
    }
}
