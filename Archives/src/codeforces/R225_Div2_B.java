package codeforces;


//import java.util.*; //Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter; //PrintWriter

public class R225_Div2_B //Name: Multitasking
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
		String[] s = in.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		int k = Integer.parseInt(s[2]);
		
		int[][] a = new int[n][m];
		for (int i = 0; i < n; i++)
		{
			s = in.readLine().split(" ");
			for (int j = 0; j < m; j++) 
				a[i][j] = Integer.parseInt(s[j]);
		}
		
		out.println(m*(m-1)/2);
		for (int i = 1; i < m; i++)
			for (int j = i+1; j <= m; j++) 
				if (k==0)
					out.println(i + " " + j);
				else
					out.println(j + " " + i);
	}
}
