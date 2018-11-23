package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R180_Div2_D //Name: Fish Weight
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
		int k = in.nextInt();
		
		int[] a = new int[n];
		for (int i = 0; i < n; i++) 
			a[i] = in.nextInt();
		
		int[] b = new int[m];
		for (int i = 0; i < m; i++) 
			b[i] = in.nextInt();
		
		assert k <= a[n-1];
		
        Arrays.sort(a);
        Arrays.sort(b);

        int ok = 0;
        if (n > m) ok = 1;
        else
        {
            for (int i = 0; i < n; i++)
                if (a[i] > b[m - n + i]) ok = 1;
        }
        if (ok == 1) 
            out.println("YES");
        else
            out.println("NO");	
	}
}
