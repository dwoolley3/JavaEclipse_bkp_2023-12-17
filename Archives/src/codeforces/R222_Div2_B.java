package codeforces;


//import java.util.*; //Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter; //PrintWriter

public class R222_Div2_B //Name: Semifinals
{
	public static void main(String[] args) throws IOException {
		//Scanner      in = new Scanner(System.in);
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter   out = new PrintWriter(System.out);
		solve(in, out);
		out.close();
		in.close();	
	}
	
	public static void solve(BufferedReader in, PrintWriter out) throws IOException
	{
		int n = Integer.parseInt(in.readLine());		

		int[] a = new int[n];
		int[] b = new int[n];
		for (int i = 0; i < n; i++) 
		{
			String[] s = in.readLine().split(" ");
			a[i] = Integer.parseInt(s[0]);
			b[i] = Integer.parseInt(s[1]);
		}
		
		StringBuilder sf1 = new StringBuilder();
		StringBuilder sf2 = new StringBuilder();
		int maxk = n / 2;
		for (int i = 0; i < maxk; i++)
		{
			sf1.append("1"); sf2.append("1");
		}
		int i = 0, j = 0;
		int place = 0;
		while (i < n && j < n && place < n)
		{
			place++;
			if (a[i] < b[j])
			{
				if (i >= maxk)
					sf1.append("1");
				i++;
			}
			else
			{
				if (j >= maxk)
					sf2.append("1");
				j++;
			}
		}
		for (int k = Math.max(i, maxk); k < n; k++)
			sf1.append("0");
		for (int k = Math.max(j, maxk); k < n; k++)
			sf2.append("0");
		
		out.println(sf1);	
		out.println(sf2);	
	}
}
