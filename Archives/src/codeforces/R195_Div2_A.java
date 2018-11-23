package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R195_Div2_A //Name: Vasily the Bear and Triangle
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
		int x = in.nextInt();	
		int y = in.nextInt();
		
        if (x > 0 && y > 0)
        	out.println("0 " + (x+y) + " " + (x+y) + " 0");
        else if (x < 0 && y > 0)
        	out.println((x-y) + " 0 0 " + (y - x));
        else if (x < 0 && y < 0)
        	out.println((x + y) + " 0 0 " + (x + y));
        else if (x > 0 && y < 0)
        	out.println(" 0 " + (y - x) + " " + (x-y) + " 0");
	}
}
