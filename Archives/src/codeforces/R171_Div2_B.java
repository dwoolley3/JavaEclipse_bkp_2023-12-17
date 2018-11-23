package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R171_Div2_B //Name: Books
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
		int t = in.nextInt();
		
		int[] a = new int[n];
		int i;
		for (i = 0; i < n; i++) 
			a[i] = in.nextInt();
		
        int max = 0;
        int sum = 0;
        int i1 = 0;
        for (i = 0; i < n; i++)
        {
            sum += a[i];
            if (sum > t)
            {
                max = Math.max(max, (i-i1));
                sum = sum - a[i1];
                i1++;
            }                
        }
        if (sum <= t)
            max = Math.max(max, (i - i1));
		
		out.println(max);		
	}
}
