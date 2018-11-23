package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R177_Div2_A //Name: Polo the Penguin and Segments
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
		int k = in.nextInt();
		
        int[] l = new int[n];
        int[] r = new int[n];
        int cnt = 0, dif;
        for (int i = 0; i < n; i++)
        {
            l[i] = in.nextInt();
            r[i] = in.nextInt();
            dif = r[i] - l[i] + 1;
            cnt += dif;
        }
        int rem = cnt % k;
        if (rem == 0)
            out.println(0);
        else
        	out.println(k - rem);
    }	
}
