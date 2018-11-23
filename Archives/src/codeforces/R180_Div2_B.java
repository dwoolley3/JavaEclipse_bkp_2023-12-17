package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R180_Div2_B //Name: Sail
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
		int t = in.nextInt();	
		int sx = in.nextInt();
		int sy = in.nextInt();
		int ex = in.nextInt();
		int ey = in.nextInt();
		
		String d = in.next();
		assert t == d.length();
		int n=0,s=0,e=0,w=0;

        if (sy - ey > 0)
            s = sy - ey;
        else
            n = ey - sy;
        if (sx - ex > 0)
            w = sx - ex;
        else
            e = ex - sx;

        int i = 0;
        while ((s > 0 || n > 0 || w > 0 || e > 0) && i < d.length())
        {
            char c = d.charAt(i);
            if (c == 'S' && s > 0) s--;
            if (c == 'N' && n > 0) n--;
            if (c == 'E' && e > 0) e--;
            if (c == 'W' && w > 0) w--;
            i++;
        }
        if (s > 0 || n > 0 || w > 0 || e > 0)
            i = -1;

        out.println(i);	
	}
}
