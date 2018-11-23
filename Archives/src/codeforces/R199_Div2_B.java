package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R199_Div2_B //Name: Xenia and Spies
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
		@SuppressWarnings("unused")
		int n = in.nextInt();  //unused
		int m = in.nextInt();	
		int s = in.nextInt();
		int f = in.nextInt();	
        int dir = 1;
        if (f < s) dir = -1;

        int[] t = new int[m];
        int[] l = new int[m];
        int[] r = new int[m];
        int pos = s, newpos, lastT = 0, steps;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++)
        {
            t[i] = in.nextInt();
            l[i] = in.nextInt();
            r[i] = in.nextInt();

            if (pos == f)
            { //do nothing
            }
            else
            {
                steps = t[i] - lastT;
                if (steps > 1)
                {
                    steps--;
                    steps = Math.min(steps, Math.abs(pos - f));
                    for (int j = 0; j < steps; j++)
                        if (dir == 1) sb.append("R");
                        else sb.append("L");
                    pos += (dir * steps);
                }
                if (pos != f)
                {
                    newpos = pos + dir;
                    if ((newpos < l[i] || newpos > r[i])
                        && (pos < l[i] || pos > r[i]))
                    {
                        pos = newpos;
                        if (dir == 1) sb.append("R");
                        else sb.append("L");
                    }
                    else
                        sb.append("X");
                }
                lastT = t[i];
            }
        }

        if (pos != f)
        {
            steps = Math.abs(pos - f);
            for (int j = 0; j < steps; j++)
                if (dir == 1) sb.append("R");
                else sb.append("L");
        }
		out.println(sb);		
	}
}
