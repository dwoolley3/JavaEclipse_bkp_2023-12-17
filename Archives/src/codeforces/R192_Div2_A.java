package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R192_Div2_A //Name: Cakeminator
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
		int r = in.nextInt();	
		int c = in.nextInt();
		
        String[] st = new String[r];
        int[][] a = new int[r][c];

        for (int i = 0; i < r; i++)
            st[i] = in.next();

        for (int i = 0; i < r; i++)
        {
            if (st[i].contains("S")) continue;
            for (int j = 0; j < c; j++)
                if (st[i].charAt(j) == '.') a[i][j] = 1;
        }

        for (int j = 0; j < c; j++)
        {
            boolean good = true;
            for (int i = 0; i < r; i++)
                if (st[i].charAt(j) == 'S') good = false;
            if (!good) continue;
            for (int i = 0; i < r; i++)
                if (st[i].charAt(j) == '.') a[i][j] = 1;
        }
        int sum = 0;
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                sum += a[i][j];
        
		out.println(sum);		
	}
}
