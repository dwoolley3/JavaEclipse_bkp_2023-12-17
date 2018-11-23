package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R186_Div2_A //Name: Ilya and Bank Account
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
		String s = String.valueOf(Math.abs(n));
        
        if (n >= 0)
            out.println(n);
        else
        {
            if (n >= -9)
            	out.println(n);
            else
            {
                String s1 = s.substring(0, s.length() - 1);
                int min = Integer.parseInt(s1);
                String s2 = s.substring(0, s.length() - 2)
                		+ s.substring(s.length()-1, s.length());
                min = Math.min(min, Integer.parseInt(s2));
                out.println(min * -1);
            }
        }	
	}
}
