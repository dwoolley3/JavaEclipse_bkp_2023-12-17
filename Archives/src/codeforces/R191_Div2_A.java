package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R191_Div2_A //Name: Flipping Game
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
		
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = in.nextInt();

        int max = 0, sum = 0;
        for (int i = 0; i < n; i++)
        {
            for (int j = i; j < n; j++)
            {
                sum = 0;
                for (int k = 0; k < n; k++)
                    if (k < i || k > j) sum += a[k];
                    else sum += (1 - a[k]);
                max = Math.max(max, sum);
            }                
        }

		out.println(max);		
	}
}
