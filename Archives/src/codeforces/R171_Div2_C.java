package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R171_Div2_C //Name: Ladder
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
		int i;
		for (i = 0; i < n; i++) 
			a[i] = in.nextInt();
		
        int[] L = new int[m];
        int[] R = new int[m];
        for (i = 0; i < m; i++)
        {
            L[i] = in.nextInt();
            R[i] = in.nextInt();
        }

        int[] Left = new int[n];
        Left[0] = 0;
        for (i = 1; i < n; i++)
        {
            if (a[i - 1] >= a[i])
                Left[i] = Left[i - 1];
            else
                Left[i] = i;
        }

        int[] Right = new int[n];
        Right[n - 1] = n - 1;
        for (i = n - 2; i >= 0; i--)
        {
            if (a[i] <= a[i+1])
                Right[i] = Right[i+1];
            else
                Right[i] = i;
        }

        for (i = 0; i < m; i++)
        {
            if (Right[L[i] - 1] >= Left[R[i] - 1])
            	out.println("Yes");
            else
            	out.println("No");
        }
	}
}
