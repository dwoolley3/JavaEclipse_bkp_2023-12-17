package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R180_Div2_A //Name: Snow Footprints
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
		String s = in.next();
		assert n == s.length();
		
        int r = s.indexOf('R') + 1;
        int l = s.indexOf('L');

        if (l == -1)
        {
            l = s.indexOf('.',r) + 1;
        }
        else if (r == 0)
        {
            r = s.indexOf('.', l);
        }

        out.println(r + " " + l);	
	}
}
