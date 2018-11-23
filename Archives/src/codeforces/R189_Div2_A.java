package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R189_Div2_A //Name: Magic Numbers
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
        String s = in.next();
        String[] a = { "144", "14", "1"};

        for (int i = 0; i < 3; i++)
            while (s.contains(a[i]))
                s = s.replace(a[i], "-");

        boolean magic = true;
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) != '-')
                magic = false;
        if (magic)
        	out.println("YES");
        else
        	out.println("NO");	
	}
}
