package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R194_Div2_A //Name: Candy Bags
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
        int[][] a = new int[n][n];

        int cnt = 0;
        for (int i = 0; i < n/2; i++)
        {
            for (int j = 0; j < n; j++)
            {
                cnt++;
                a[j][i] = cnt;
                a[j][n-i-1] = n*n - cnt + 1;
            }
        }

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            	out.print(a[i][j] + " ");
            out.println();
        }		
	}
}
