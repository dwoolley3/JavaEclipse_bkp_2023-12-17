package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R173_Div2_B //Name: Painting Eggs
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
        int a, g, atot = 0, gtot = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++)
        {
            a = in.nextInt();	
            g = in.nextInt();	
            if (atot + a <= gtot + 500)
            {
                sb.append("A");
                atot += a;
            }
            else
            {
                sb.append("G");
                gtot += g;
            }
        }

        if (Math.abs(atot - gtot) <= 500)
        	out.println(sb);
        else
        	out.println(-1);		
	}
}
