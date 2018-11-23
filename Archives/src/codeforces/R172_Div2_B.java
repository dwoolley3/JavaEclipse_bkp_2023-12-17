package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R172_Div2_B
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
        int x = in.nextInt();
        int y = in.nextInt();
        int n = in.nextInt();
        double dx = (double) x;
        double dy = (double) y;

        double eps = 1e-15;  //Need to round at 15th digit for double (it is precise to 15 digits)
        long mina = 0, minb = 0;
        double min = Long.MAX_VALUE;
        for (long b = 1; b <= n; b++)
        {
            double db = (double)b;
            long aMin = b * x / y;
            long aMax = (long)Math.ceil(db * dx / dy);

            for (long a = aMin; a <= aMax; a++)
            {
                double da = (double)a;
                double d = Math.abs(dx / dy - da / db);
                //Need to round at 1e15 to avoid imprecision at 16th decimal in double 
                // Otherwise (7/6 - 1/1) > (4/3 - 7/6)  
                // 0.16666666666666674 > 0.16666666666666652
                //d = Math.Floor(d * 1e15) / 1e15;
                if (d < min - eps)
                {
                    min = d;
                    mina = a;
                    minb = b;
                }
            }
        }
		
		out.println(mina + "/" + minb);		
	}
}
