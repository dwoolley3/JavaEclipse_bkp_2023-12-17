package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R180_Div2_C //Name: Parity Game
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
        String a = in.next();
        String b = in.next();

        int a1 = CountOnes(a);
        int b1 = CountOnes(b);

        if (a1 % 2 == 1) a1++;
        if (a1 >= b1)
            out.println("YES");
        else
            out.println("NO");	
	}
	
    static private int CountOnes(String s)
    {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) == '1') cnt++;
        return cnt;
    }
}
