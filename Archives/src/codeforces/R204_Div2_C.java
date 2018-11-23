package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R204_Div2_C //Name: Jeff and Rounding
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

        double a, d, sum = 0;
        int zero = 0;
        for (int i = 0; i < n * 2; i++)
        {
            //a = double.Parse(s[i], CultureInfo.InvariantCulture);
        	a = in.nextDouble();
            d = a - (int)a;
            //if (s[i].EndsWith(".000"))  //Check if a is integer
            if (d < 1e-6)
                zero++;
            sum += d;
        }

        double min = Double.MAX_VALUE;
        int start = Math.max(0, n - zero);
        for (int i = start; i <= n; i++)
            if (Math.abs(sum - i) < min)
                min = Math.abs(sum - i);
        min += 123.0;

        //Display 3 decimals
        //Console.WriteLine(min.ToString("F3", CultureInfo.InvariantCulture));
        out.format("%.3f",  min);  //3 decimals
	}
}
