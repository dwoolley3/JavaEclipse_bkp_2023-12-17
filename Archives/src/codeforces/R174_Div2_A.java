package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R174_Div2_A //Name: Cows and Primitive Roots
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
		int p = in.nextInt();	
        int cnt = 0;
        long num;
        for (long x = 1; x < p; x++)
        {
            num = 1;
            boolean good = true;
            for (int j = 1; j <= p - 2 && good; j++)
            {
                num *= x;
                num = num % p;
                if (num == 1)
                    good = false;
            }
            if (good)
            {
                num *= x;
                num = num % p;
                if (num == 1)
                    cnt++;
            }
        }
		
		out.println(cnt);		
	}
}
