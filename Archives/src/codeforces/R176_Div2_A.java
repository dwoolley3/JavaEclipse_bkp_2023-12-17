package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R176_Div2_A //Name: IQ Test
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
        int[][] c = new int[4][4];
        for (int i = 0; i < 4; i++)
        {
            String s = in.next();
            for (int j = 0; j < 4; j++)
                c[i][j] = (s.charAt(j) == '#') ? 1 : 0;
        }

        boolean good = false;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
            {
                int sum = c[i][j] + c[i + 1][j] + c[i][j + 1] + c[i + 1][j + 1];
                if (sum != 2)
                {
                    good = true;
                    break;
                }
                if (good) break;
            }
        if (good)
        	out.println("YES");
        else
        	out.println("NO");
	}
}
