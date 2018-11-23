package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R192_Div2_C //Name: Purification
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
        String[] gr = new String[n];
        int[] col = new int[n + 1];
        int[] row = new int[n + 1];
        int i, j;

        for (i = 0; i < n; i++)
            gr[i] = in.next();

        for (i = 0; i < n; i++)
        {
            for (j = 0; j < n; j++)
                if (gr[i].charAt(j) == '.') break;
            if (j == n) break;
            col[i] = j;
        }
        if (i < n)
        {
            for (i = 0; i < n; i++)
            {
                for (j = 0; j < n; j++)
                    if (gr[j].charAt(i) == '.') break;
                if (j == n) break;
                row[i] = j;
            }
            if (i < n)
            	out.println(-1);
            else
                for (i = 0; i < n; i++)
                	out.println((row[i] + 1) + " " + (i + 1));
        }
        else
            for (i = 0; i < n; i++)
            	out.println((i + 1) + " " + (col[i] + 1));
	}
}
