package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R188_Div2_B //Name: String of Power
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
		String s = in.next();
        int n = s.length();
        ArrayList<Integer> h = new ArrayList<Integer>();
        ArrayList<Integer>  m = new ArrayList<Integer>();
        for (int i = 0; i < n - 4; i++)
        {
            String w = s.substring(i, i+5);
            if (w.equals("heavy"))
                h.add(i);
            else if (w.equals("metal"))
                m.add(i);
        }
        int mi = 0;
        long cnt = 0;
        int mCount = m.size();
        int hCount = h.size();
        for (int i = 0; i < hCount; i++)
        {
            while (mi < mCount && h.get(i) > m.get(mi))
                mi++;
            cnt += (mCount - mi);
        }
		
		out.println(cnt);
	}
}
