package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R171_Div2_A //Name: Point on Spiral
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
        int a = 0, b = 0;
        int inc = 0, turns = 0;

        if (x == 0 && y == 0)
        {
        	out.println(turns);
            return;
        }

        while (Math.abs(a) < 105 && Math.abs(b) < 105)
        {
            inc++;
            for (int i = 1; i <= inc; i++)
            {
                a++;
                if (a == x && b == y)
                {
                	out.println(turns);
                    return;
                }
            }
            turns++;
            for (int i = 1; i <= inc; i++)
            {
                b++;
                if (a == x && b == y)
                {
                	out.println(turns);
                    return;
                }
            }
            turns++;

            inc++;
            for (int i = 1; i <= inc; i++)
            {
                a--;
                if (a == x && b == y)
                {
                	out.println(turns);
                    return;
                }
            }
            turns++;
            for (int i = 1; i <= inc; i++)
            {
                b--;
                if (a == x && b == y)
                {
                    out.println(turns);
                    return;
                }
            }
            turns++;
        }
		
		out.println(turns);		
	}
}
