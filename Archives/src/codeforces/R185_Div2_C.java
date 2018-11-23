package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R185_Div2_C //Name: The Closest Pair
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
		int k = in.nextInt();

        int[] px = new int[n];
        int[] py = new int[n];
        for (int i = 0; i < n; i++)
        {
            px[i] = 0;
            py[i] = i;
        }
        int tot = GetTot(px, py);
        if (tot > k)
            for (int i = 0; i < n; i++)
                out.println(px[i] + " " + py[i]);
        else
            out.println("no solution");
    }

    static int GetTot(int[] px, int[] py)
    {
        int n = px.length;
        double d = Double.MAX_VALUE;;
        int tot = 0;
        for (int i = 0; i < n; i++)
            for (int j = i+1; j < n; j++)
            {
                ++tot;
                if (px[j] - px[i] >= d)
                    break;                    
                d = Math.min(d, distance(px[i],py[i], px[j], py[j]));
            }
        return tot;
    }

    static double distance(int x1, int y1, int x2, int y2)
    {
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }
}
