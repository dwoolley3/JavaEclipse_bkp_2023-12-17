package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R200_Div2_D //Name: Alternating Current
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
        char[] s = in.next().toCharArray();
        int n = s.length;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++)
        {
            if (i == n - 1 || s[i] != s[i + 1])
            {
                if (sb.length() > 0 && s[i] == sb.charAt(sb.length() - 1))
                    sb.deleteCharAt(sb.length() - 1);
                else
                    sb.append(s[i]);
            }
            else
                i++;
        }

        if (sb.length() == 0)
        	out.println("Yes");
        else
        	out.println("No");
	}
}
