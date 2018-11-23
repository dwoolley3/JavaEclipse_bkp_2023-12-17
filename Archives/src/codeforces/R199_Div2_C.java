package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R199_Div2_C //Name: Cupboard and Balloons
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
		int h = in.nextInt();

        int cnt = h / r * 2;
        int h2 = h % r;
        if (h2 * 2 < r) cnt++;
        else if (h2 * 2 >= Math.sqrt(3) * r) cnt += 3;
        else cnt += 2;
		
		out.println(cnt);		
	}
}
