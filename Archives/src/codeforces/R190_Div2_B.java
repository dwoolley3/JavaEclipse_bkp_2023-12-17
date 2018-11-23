package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R190_Div2_B //Name: Ciel and Flowers
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
		int rr = in.nextInt();	
		int gg = in.nextInt();
		int bb = in.nextInt();
		
        int r, g, b;
        int cnt = 0;
        if (rr % 3 == 0 && rr > 0)
        {
            r = rr / 3 - 1;
            rr -= r * 3;
            cnt += r;
        }
        else
        {
            r = rr / 3;
            rr = rr % 3;
            cnt += r;
        }

        if (gg % 3 == 0 && gg > 0)
        {
            g = gg / 3 - 1;
            gg -= g * 3;
            cnt += g;
        }
        else
        {
            g = gg / 3;
            gg = gg % 3;
            cnt += g;
        }

        if (bb % 3 == 0 && bb > 0)
        {
            b = bb / 3 - 1;
            bb -= b * 3;
            cnt += b;
        }
        else
        {
            b = bb / 3;
            bb = bb % 3;
            cnt += b;
        }

        r = rr; g = gg; b = bb;
        int cnt1 = 0;
        cnt1 += Math.min(r, Math.min(g, b));
        r -= cnt1; g -= cnt1; b -= cnt1;
        cnt1 += r / 3 + g / 3 + b / 3;
        cnt1 += cnt;

        r = rr; g = gg; b = bb;
        int cnt2 = 0;
        cnt2 += r / 3; r = r % 3;
        cnt2 += g / 3; g = g % 3;
        cnt2 += b / 3; b = b % 3;            

        cnt2 += Math.min(r, Math.min(g, b));
        cnt2 += cnt;

        out.println(Math.max(cnt1,cnt2));
	
	}
}
