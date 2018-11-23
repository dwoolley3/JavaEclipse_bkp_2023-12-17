package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R184_Div2_B //Name: Continued Fractions
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
		long p = in.nextLong();	
		long q = in.nextLong();
		
		int n = in.nextInt();		
		long[] a = new long[n];
		for (int i = 0; i < n; i++) 
			a[i] = in.nextLong();
		
		 long g = GCD(p, q);
         p = p / g;
         q = q / g;

         long maxLong = Long.MAX_VALUE; //9e18
         long num, den, t;
         den = 1;
         num = a[n - 1];
         boolean overflow = false;
         for (int i = n - 1; i > 0; i--)
         {
             t = num; num = den; den = t;
             double doub = (double)den * a[i - 1];
             if (doub > maxLong)
             {
                 overflow = true;
                 break;
             }
             num += den * a[i - 1];
             
             g = GCD(num, den);
             num = num / g;
             den = den / g;
         }             
       
         //Console.WriteLine(num + "/" + den);
         if (num == p && den == q && !overflow)
             out.println("YES");
         else
             out.println("NO");
     }

     static long GCD(long a, long b)
     {
         if (b == 0) return a;
         return GCD(b, a % b);
     }
}
