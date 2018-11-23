package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R183_Div2_A //Name: R214_Div2_#
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
		int num = in.nextInt();
		
        int a,b,c, cnt=0;
        int x;
        for (a = 1; a <= num; a++)
            for (b = a+1; b <= num; b++)
            {
                c = a * a + b * b;
                x = (int)(Math.sqrt((double)c) + 1e-8);
                if (x * x == c && x <= num)
                {
                    cnt++;  
                }
            }
		out.println(cnt);		
	}
}
