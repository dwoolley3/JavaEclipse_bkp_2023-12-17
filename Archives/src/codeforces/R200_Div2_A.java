package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R200_Div2_A //Name: Magnets
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
        int cnt = 0;
        char lastC = ' ';
        char c = ' ';
        String s;

        for (int i = 0; i < n; i++)
        {
            s = in.next();
            c = s.charAt(0);
            if (lastC == c || i == 0)
                cnt++;
            lastC = s.charAt(1);
        }
		
		out.println(cnt);		
	}
}
