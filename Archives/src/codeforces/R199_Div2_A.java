package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R199_Div2_A //Name: Xenia and Divisors
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
        int[] b = new int[10];
        for (int i = 0; i < n; i++)
        {
            a = in.nextInt();
            b[a]++;
        }
        StringBuilder sb = new StringBuilder();
        boolean good = true;
        if (b[1] != n / 3 || b[5] > 0 || b[7] > 0)
            out.println(-1);
        else
        {
            int i = 0;
            while (good && i < n / 3)
            {
                if (b[3] > 0 && b[6] > 0)
                {
                    b[1]--; b[3]--; b[6]--;
                    sb.append("1 3 6\r\n");
                }
                else if (b[6] > 0 && b[2] > 0)
                {
                    b[1]--; b[2]--; b[6]--;
                    sb.append("1 2 6\r\n");
                }
                else if (b[4] > 0 && b[2] > 0)
                {
                    b[1]--; b[2]--; b[4]--;
                    sb.append("1 2 4\r\n");
                }
                else good = false;
                i++;
            }
            if (good)
            	out.println(sb);
            else
            	out.println(-1);
        }
	}
}
