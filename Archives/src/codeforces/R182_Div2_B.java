package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R182_Div2_B //Name: Eugeny and Play List
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
		int m = in.nextInt();
		
		int[] c = new int[n];
		int[] t = new int[n];
		for (int i = 0; i < n; i++) 
		{
			c[i] = in.nextInt();
			t[i] = in.nextInt();
		}
		
        int v;
        StringBuilder sb = new StringBuilder();
        int song = 0, tim = 0;
        for (int i = 0; i < m; i++)
        {
            v = in.nextInt();
            while (v > tim)
            {
               tim += t[song] * c[song];
               song++;
            }
            sb.append(song+"\n");
        }

        out.println(sb);
	
	}
}
