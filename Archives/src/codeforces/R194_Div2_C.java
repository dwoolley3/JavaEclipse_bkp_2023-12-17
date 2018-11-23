package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R194_Div2_C //Name: Secrets
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
		long n = in.nextLong();	
        long pow3 = 3;
        while (n % pow3 == 0) 
            pow3 *= 3;

        long cnt = n / pow3 + 1;
		
		out.println(cnt);		
	}
}
