package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R177_Div2_C
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
		int k = in.nextInt();
		
        if (n < k || (n>1 && k == 1))
        {
            out.println(-1);
            return;
        }
        else if (n == 1 && k == 1)
        {
        	out.println("a");
            return;
        }

        StringBuilder sb = new StringBuilder();
        int leta = 'a';
        int it = (n - (k-2)) / 2;
        
        for (int i = 1; i <= it; i++ )
        {
            sb.append("ab");
        }
        if ((n - (k - 2)) % 2 == 1)
            sb.append("a");

        for (int i = 3; i <= k; i++)
            sb.append((char)(i + leta - 1));

        out.println(sb);	
	}
}
