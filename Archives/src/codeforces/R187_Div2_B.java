package codeforces;


//import java.util.*; //Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter; //PrintWriter

public class R187_Div2_B
{
	public static void main(String[] args) throws IOException {
		//Scanner      in = new Scanner(System.in);
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter   out = new PrintWriter(System.out);
		//Reading 100,000 numbers on a line takes 3 times longer with Scanner
		//Scanner = 436ms; BufferedReader w/split = 186ms; w/o split = 124ms
		//For 200,000 numbers on a line: Scanner = 810ms; BR w/split = 280ms.
		//Thus, use BufferedReader instead of Scanner if time is critical.
		solve(in, out);
		out.close();
		in.close();	
	}
	
	public static void solve(BufferedReader in, PrintWriter out) throws IOException
	{
		String[] s = in.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		
        s = in.readLine().split(" ");
		long[] a = new long[n+1];
		for (int i = 0; i < n; i++) 
			a[i+1] = Long.parseLong(s[i]);
		
        long add = 0;
        int v, x;
        for (int i = 0; i < m; i++)
        {
            s = in.readLine().split(" ");
            int t = Integer.parseInt(s[0]);
            if (t == 1)
            {
                v = Integer.parseInt(s[1]);
                x = Integer.parseInt(s[2]);
                a[v] = x - add;
            }
            else if (t == 2)
            {
                int y = Integer.parseInt(s[1]);
                add += y;
            }
            else if (t == 3)
            {
                int q = Integer.parseInt(s[1]);
                out.println(a[q]+add);
            }
        }
	}
}
