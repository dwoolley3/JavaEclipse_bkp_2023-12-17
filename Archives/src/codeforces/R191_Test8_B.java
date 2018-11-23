package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R191_Test8_B //Name: Sheldon and Ice Pieces
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
        String t = in.next();
        String s = in.next();

        int[] a = new int[10];
        int[] b = new int[10];
        int[] c = new int[10];

        for (int i = 0; i < t.length(); i++)
            a[t.charAt(i)-'0']++;

        for (int i = 0; i < s.length(); i++)
            b[s.charAt(i) - '0']++;

        int n25 = b[2] + b[5];
        int n69 = b[6] + b[9];

        int max = 0;
        for (int i = 0; i <= n25; i++)
        {
            int j = n25 - i;
            for (int k = 0; k <= n69; k++)
            {
                int m = n69 - k;
                for (int d = 0; d < 10; d++)
                    c[d] = b[d];
                c[2] = i; c[5] = j; c[6] = k; c[9] = m;
                int min = 999;
                for (int l = 0; l <= 9; l++)
                {
                    if (a[l] > 0)
                        min = Math.min(min, c[l] / a[l]);
                }
                max = Math.max(max, min);
            }
        }
		out.println(max);			
	}
}
