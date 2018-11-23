package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R190_Div2_C //Name: Ciel and Robot
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

        char[] s = in.next().toCharArray();

        //int[,] xy = new int[offset*2+1, offset*2+1];

        int n = s.length;
        int dy = 0, dx = 0;
        if (a == dx && b == dy)
        {
        	out.println("Yes");
            return;
        }
        //xy[dx+offset, dy+offset] = 1;
        for (int i = 0; i < n; i++)
        {
            if (s[i] == 'U') dy++;
            else if (s[i] == 'D') dy--;
            else if (s[i] == 'L') dx--;
            else if (s[i] == 'R') dx++;
            //xy[dx + offset, dy + offset] = 1;
            if (a == dx && b == dy)
            {
            	out.println("Yes");
                return;
            }
        }

        int x = 0, y = 0;
        for (int i = 0; i < n; i++)
        {
            if (s[i] == 'U') y++;
            else if (s[i] == 'D') y--;
            else if (s[i] == 'L') x--;
            else if (s[i] == 'R') x++;
            if (IsReachable(x, y, a, b, dx, dy))
            {
            	out.println("Yes");
                return;
            }
        }         

        out.println("No");            
    }

    static private boolean IsReachable(int i, int j, int a, int b, int dx, int dy)
    {
        int k = 0;
        if (dx != 0)       k = (a - i) / dx;
        else if (dy != 0)  k = (b - j) / dy;
        if (k < 0)         k = 0;

        return (a == i + k * dx && b == j + k * dy);
    }
}
