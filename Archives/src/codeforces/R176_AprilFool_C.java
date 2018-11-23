package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R176_AprilFool_C //Name: WTF?
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
		int tux = in.nextInt();	
        int foo = 0, bar = 0, baz = 0, quz = 1;
        while (tux != 0)
        {
            int pur = in.nextInt();
            foo += pur;
            bar++;
            if (foo * quz > bar * baz)
            {
                baz = foo;
                quz = bar;
            }
            tux--;
        }
        out.println((double) baz / (double)quz);
	}
}
