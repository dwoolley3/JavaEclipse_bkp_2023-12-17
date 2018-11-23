package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R193_Div2_A //Name: Down the Hatch!
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
		char[] c = in.next().toCharArray();
        int len = c.length;
        int cnt = 0;

        for (int i = 3; i < len; i++)
        {
            if (i % n != 0) continue;
            String a = c[i - 3] + "" + c[i - 2] + "" + c[i - 1] + "a";
            String b = c[i - 3] + "" + c[i - 2] + "" + c[i - 1] + "b";
            if (a.equals("aaaa") || b.equals("bbbb"))
                cnt++;
        }   
		
		out.println(cnt);		
	}
}
