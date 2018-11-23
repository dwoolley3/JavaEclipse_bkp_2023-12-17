package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R187_Div2_A //Name: Sereja and Bottles
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
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++)
        {
            a[i] = in.nextInt();
            b[i] = in.nextInt();
        }
        int cnt = 0;
        boolean[] opened = new boolean[1001];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
        {
            if (i == j) continue;
            if (a[i] == b[j])
                opened[i] = true;
        }
        for (int i = 0; i < n; i++)
        {
            if (opened[i]) cnt++;
        }
		
		out.println(n - cnt);		
	}
}
