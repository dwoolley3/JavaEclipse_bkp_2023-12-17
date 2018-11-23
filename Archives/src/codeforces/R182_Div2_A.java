package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R182_Div2_A //Name: Eugeny and Array
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
		int m = in.nextInt();
		
		int[] a = new int[n];
		int neg = 0, pos = 0;
		for (int i = 0; i < n; i++) 
		{
			a[i] = in.nextInt();
			if (a[i] < 0) neg++; else pos++;
		}
		
		int[] l = new int[m];
        int[] r = new int[m];
        for (int i = 0; i < m; i++)
        {
            l[i] = in.nextInt();
            r[i] = in.nextInt();
        }             

        for (int i = 0; i < m; i++)
        {
            int cnt = 0;
            int d = r[i] - l[i];
            if (d % 2 == 1)
            {
                int num = (d + 1) / 2;
                if (neg >= num && pos >= num)
                    cnt = 1;
            }
            out.println(cnt);
        }	
	}
}
