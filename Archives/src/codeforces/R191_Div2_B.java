package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R191_Div2_B //Name: Hungry Sequence
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
        int max = 10000000;
        StringBuilder sb = new StringBuilder();
        for (int i = max - n; i < max; i++)
             sb.append(i + " ");
		
		out.println(sb);		
	}
}
