package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R185_Div2_A //Name: Whose sentence is it?
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
		in.nextLine();  //Read end of line after int and before char line
		
        String ans = "";
        for (int i = 0; i < n; i++)
        {
            String s = in.nextLine();
            if (s.startsWith("miao.") && !s.endsWith("lala."))
                ans = "Rainbow's";
            else if (!s.startsWith("miao.") && s.endsWith("lala."))
                ans = "Freda's";
            else
                ans = "OMG>.< I don't know!";
            out.println(ans);
        }
	}
}
