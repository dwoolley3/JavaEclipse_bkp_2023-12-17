package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R191_Test8_A //Name: IQ Test
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
		int n = 4;
		
		int[] a = new int[n];
		for (int i = 0; i < n; i++) 
			a[i] = in.nextInt();
		
        if (a[3] - a[2] == a[2] - a[1]
         && a[2] - a[1] == a[1] - a[0])
        {
            int d = a[1] - a[0];
            out.println(a[3] + d);
            return;
        }

        if (a[3] * a[1] == a[2] * a[2]
         && a[2] * a[0] == a[1] * a[1])
        {
            double q = a[3] * a[3] / (double)a[2];
            if (Math.abs(q - (int)q) < 0.0001)
            {
            	out.println((int)(a[3] * a[3] / (double)a[2]));
                return;
            }
        }
	
		out.println(42);		
	}
}
