package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R175_Div2_D //Name: Permutation Sum
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
		
        long mod = 1_000_000_007;
        //An even input n will have an output of 0
        int[] a = { 1, 0, 3, 0, 15, 0, 133, 0, 2025, 0, 37851, 0, 1030367, 0, 36362925, 0 };

        long f = a[n-1];
        for (int i = 1; i <= n; i++)
        {
            f *= i;
            f %= mod;
        }
		
		out.println(f);		
	}
}
