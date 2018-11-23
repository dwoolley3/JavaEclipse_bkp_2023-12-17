package codeforces;
//import java.util.*; //Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter; //PrintWriter

public class R193_Div2_B //Name: Maximum Absurdity
{
	public static void main(String[] args) throws IOException {
		//Scanner      in = new Scanner(System.in);
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		solve(in, out);
		out.close();
		in.close();	
	}
	
	public static void solve(BufferedReader in, PrintWriter out) throws IOException
	{
		String[] s = in.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int k = Integer.parseInt(s[1]);
		
		s = in.readLine().split(" ");
		int[] x = new int[n];
		for (int i = 0; i < n; i++) 
			x[i] = Integer.parseInt(s[i]);
		
        long[] m = new long[n];
        long[] mm = new long[n];
        int[] mmb = new int[n];
        long sum = 0;
        for (int i = 0; i < k-1; i++)
            sum += x[i];

        for (int i = 0; i <= n - k; i++)
        {
            sum += x[i + k - 1];
            m[i] = sum;
            sum -= x[i];
        }

        long max = -1;
        int mb = -1;
        for (int i = n - k; i >= 0; i--)
        {
            if (m[i] >= max)
            {
                max = m[i];
                mb = i;
            }
            mm[i] = max;
            mmb[i] = mb;
        }

        int maxa = -1, maxb = -1;
        long maxsum = -1;
        sum = 0;
        for (int i = 0; i < n - k; i++)
        {
            sum = m[i] + mm[i + k];
            if (sum > maxsum)
            {
                maxsum = sum;
                maxa = i;
                maxb = mmb[i + k];
            }
        }
        maxa++; maxb++;
		
		out.println(maxa + " " + maxb);		
	}
}
