package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R217_Div2_B //Name: 
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

		int[] m = new int[n];
		int[][] a = new int[100][100];
		for (int i = 0; i < n; i++)
		{
			m[i] = in.nextInt();
			for (int j = 0; j < m[i]; j++)
				a[i][j] =  in.nextInt();		
		}
		for (int i = 0; i < n; i++)
		{
			boolean win = true;
			for (int j = 0; j < n; j++)
			{
				if (i == j) continue;
				int cnt = 0;
				for (int k = 0; k < m[i]; k++)
					for (int l = 0; l < m[j]; l++)
						if (a[i][k] == a[j][l]) cnt++;					

				if (cnt == m[j]) win = false;
			}
			if (win)
				out.println("YES");
			else
				out.println("NO");
		}	
	}
}
