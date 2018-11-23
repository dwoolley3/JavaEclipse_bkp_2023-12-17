package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R191MemSql_A //Name: Square and Rectangles
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
		int n  = in.nextInt();	
		
		int[] x1 = new int[n];
		int[] x2 = new int[n];
		int[] y1 = new int[n];
		int[] y2 = new int[n];
		
        int area = 0;
        int maxx = -1, minx = 35000, maxy = -1, miny = 35000;
        for (int i = 0; i < n; i++)
        {
            x1[i] = in.nextInt();	
            y1[i] = in.nextInt();	
            x2[i] = in.nextInt();	
            y2[i] = in.nextInt();	
            area += (x2[i] - x1[i]) * (y2[i] - y1[i]);
            maxx = Math.max(maxx, x2[i]);
            maxy = Math.max(maxy, y2[i]);
            minx = Math.min(minx, x1[i]);
            miny = Math.min(miny, y1[i]);
        }

        if (area == (maxx - minx) * (maxy - miny)
            && (maxx - minx) == (maxy - miny))
        	out.println("YES");
        else
        	out.println("NO");

	}
}
