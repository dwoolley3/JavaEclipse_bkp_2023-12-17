package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R192_Div2_B //Name: Road Construction
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
		
        int[] d = new int[n+1];
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < m; i++)
        {
            a[i] = in.nextInt();
            b[i] = in.nextInt();
            d[a[i]]++; d[b[i]]++;
        }

        int mid = 1;
        for (int i = 1; i <= n; i++)
            if (d[i] == 0)
            {
                mid = i;
                break;
            }

        out.println(n - 1);
        for (int i = 1; i <= n; i++)
        {
            if (i != mid)
            	out.println(i + " " + mid);
        } 
	}
}
