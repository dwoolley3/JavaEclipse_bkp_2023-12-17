package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R204_Div2_A //Name: Jeff and Digits
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
        int a;
        int zero = 0, five = 0;
        for (int i = 0; i < n; i++)
        {
            a = in.nextInt();
            if (a == 0) zero++;
            if (a == 5) five++;
        }

        int cnt = five / 9;
        if (zero == 0)
        {
            out.println(-1);
        }
        else if (five < 9)
        {
        	out.println(0);
        }
        else
        {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cnt * 9; i++)
                sb.append("5");
            for (int i = 0; i < zero; i++)
                sb.append("0");

            out.println(sb);
        }
	}
}
