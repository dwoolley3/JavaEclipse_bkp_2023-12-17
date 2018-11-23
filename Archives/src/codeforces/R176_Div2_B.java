package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R176_Div2_B //Name: Pipeline
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
		long n = in.nextLong();	
		long k = in.nextInt();
		
        long l=0, r, mid;
        long maxsum = (k * (k + 1) / 2) - k + 1;
        if (maxsum < n)
            r = -1;
        else
        {
            r = k - 1;
            while (l < r)
            {
                mid = (l + r) / 2;
                if (k * (k - 1) / 2 - (k - mid) * (k - mid - 1) / 2 + 1 < n)
                    l = mid + 1;
                else
                    r = mid;
            }
        }
		
		out.println(r);		
	}
}
