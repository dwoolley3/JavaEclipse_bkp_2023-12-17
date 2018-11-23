package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R173_Div2_C //Name:
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
		String a = in.next();	
		String b = in.next();	
        int n = a.length();
        if (n != b.length())
        	out.println("NO");
        else
        {
            boolean found1A = false, found1B = false;
            for (int i = 0; i < n; i++)
            {
                if (a.charAt(i) == '1')
                    found1A = true;
                if (b.charAt(i) == '1')
                    found1B = true;
            }
            if (found1A && found1B)
            	out.println("YES");
            else if (!found1A && !found1B)
            	out.println("YES");
            else
            	out.println("NO");
        }
	}
}
