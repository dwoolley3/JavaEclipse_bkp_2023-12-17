package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R200_Div2_B //Name: Simple Molecules
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
		int a = in.nextInt();	
        int b = in.nextInt();
        int c = in.nextInt();
        int i, j, k;

        for (i = 0; i <= b; i++)
        {
            j = (b - i);
            k = (c - j);
            if (k < 0) continue;
            if (i + k != a) continue;
            out.println(i + " " + j + " "+ k);
            return;
        }

        out.println("Impossible");
	}
}
