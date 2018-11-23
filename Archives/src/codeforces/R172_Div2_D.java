package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R172_Div2_D
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
		
		int[] stack = new int[n];
        int ret = 0;
        //Find all pairs of numbers having smaller number(s) between,
        //and compute xor of the 2 numbers, and take maximum of all.
        //1. For a[i], find first number to its left that is bigger
        //2. For a[i] reversed, find first number to its left that is bigger
        for (int k = 1; k <= 2; k++)
        {
            if (k == 2) //Array.Reverse(a);
            {
            	for (int j = 0; j < n/2; j++)
            	{
            		int temp = a[j]; a[j] = a[n-j-1]; a[n-j-1] = temp;
            	}
            }

            int j = 0;
            for (int i = 0; i < n; i++)
            {
                while (j > 0 && stack[j - 1] < a[i]) j--;
                if (j > 0)
                    ret = Math.max(ret, stack[j - 1] ^ a[i]);
                stack[j++] = a[i];
            }
        }
		
		out.println(ret);		
	}
}
