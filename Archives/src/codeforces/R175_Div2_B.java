package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R175_Div2_B //Name: Find Marble 
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
		int s = in.nextInt();
		int t = in.nextInt();
		
		int[] p = new int[n+1];
		for (int i = 1; i <= n; i++) 
			p[i] = in.nextInt();
		
        int cnt = 0;
        if (s != t)
        {
            int ind = s;
            for (int i = 1; i <= n; i++)
            {
                cnt++;
                if (p[ind] == t) break;
                ind = p[ind];
            }
            if (p[ind] != t) cnt = -1;
        }
		
		out.println(cnt);		
	}
}
