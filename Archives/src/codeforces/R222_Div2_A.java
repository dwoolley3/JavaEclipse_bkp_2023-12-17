package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R222_Div2_A
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
		int aw = 0, bw = 0, t = 0;
		for (int i = 1; i <= 6; i++)
		{
			if (Math.abs(a-i) < Math.abs(b-i)) aw++;
			if (Math.abs(a-i) > Math.abs(b-i)) bw++;
			if (Math.abs(a-i) == Math.abs(b-i)) t++;
		}
		
		out.println(aw + " " + t + " " + bw);		
	}
}
