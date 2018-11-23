package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R173_Div2_A //Name: Bit++
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
        int x = 0;
        for (int i = 0; i < n; i++)
        {
            String s = in.next();
            if (s.contains("++"))
                x++;
            if (s.contains("--"))
                x--;
        }
		
		out.println(x);		
	}
}
