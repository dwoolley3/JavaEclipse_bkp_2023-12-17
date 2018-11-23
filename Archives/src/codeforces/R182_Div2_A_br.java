package codeforces;


//import java.util.*; //Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter; //PrintWriter

public class R182_Div2_A_br //Name: Eugeny and Array
{
	public static void main(String[] args) throws IOException {
		//Scanner      in = new Scanner(System.in);
		//This br version ran in 436ms, compared with scanner in 1808ms
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter   out = new PrintWriter(System.out);
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
		int[] a = new int[n];
		int neg = 0, pos = 0;
		for (int i = 0; i < n; i++) 
		{
			a[i] = Integer.parseInt(s[i]);
			if (a[i] < 0) neg++; else pos++;
		}
		
		int[] l = new int[m];
        int[] r = new int[m];
        for (int i = 0; i < m; i++)
        {
        	s = in.readLine().split(" ");
            l[i] = Integer.parseInt(s[0]);
            r[i] = Integer.parseInt(s[1]);
        }             

        for (int i = 0; i < m; i++)
        {
            int cnt = 0;
            int d = r[i] - l[i];
            if (d % 2 == 1)
            {
                int num = (d + 1) / 2;
                if (neg >= num && pos >= num)
                    cnt = 1;
            }
            out.println(cnt);
        }		
	}
}
