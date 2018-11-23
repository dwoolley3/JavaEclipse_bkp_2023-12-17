package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R182_Div2_E //Name: Yaroslav and Algorithm
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
        @SuppressWarnings("unused")
		String s;
        for (int i = 0; i < n; i++)
            s = in.next();

        for (int i = 0; i < 10; i++)
            out.println("??" + i + ">>" + i + "??");

        out.println("??>>?");

        for (int i = 0; i < 9; i++)
            out.println(i + "?<>" + (i + 1));

        out.println("9?>>?0");

        out.println("?<>1");

        out.println(">>??");	
	}
}
