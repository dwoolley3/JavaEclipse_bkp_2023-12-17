package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R179_Div2_A //Name: Yaroslav and Permutations
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

		int[] a = new int[1001];
		int aa, max = 0;
		for (int i = 0; i < n; i++)
		{
			aa = in.nextInt();
			a[aa]++;
            if (a[aa] > max) max = a[aa];
        }
        if ( (n+1) / 2 >= max)
            out.println("YES");
        else
        	out.println("NO");	
	}
}
