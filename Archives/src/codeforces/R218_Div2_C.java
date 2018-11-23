package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R218_Div2_C //Name: Hamburgers
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
		String st = in.next();
		int b = 0, s = 0, c = 0;
		for (char ch : st.toCharArray())
			if (ch == 'B') b++;
			else if (ch == 'S') s++;
			else if (ch == 'C') c++;
						
		int nb = in.nextInt();	
		int ns = in.nextInt();
		int nc = in.nextInt();
		
		int pb = in.nextInt();	
		int ps = in.nextInt();
		int pc = in.nextInt();
		
		long r = in.nextLong();		
		int min = Integer.MAX_VALUE;
		if (b > 0) min = Math.min(min, nb / b); else nb = 0;
		if (s > 0) min = Math.min(min, ns / s); else ns = 0;
		if (c > 0) min = Math.min(min, nc / c); else nc = 0;
		nb -= min * b;
		ns -= min * s;
		nc -= min * c;
		long cnt = min;
		
		int needb, needs, needc, cost;
		while (nb > 0 || ns > 0 || nc > 0)
		{
			needb = Math.max(0, b-nb);
			needs = Math.max(0, s-ns);
			needc = Math.max(0, c-nc);
			cost = needb * pb + needs * ps + needc * pc;
			if (cost <= r)
			{
				r -= cost;
				cnt++;
				if (nb > b) nb -= b; else nb = 0;
				if (ns > s) ns -= s; else ns = 0;
				if (nc > c) nc -= c; else nc = 0;
			}
			else break;
		}
		cost =  b * pb + s * ps + c * pc;
		cnt += (r / cost);
		
		out.println(cnt);		
	}
}
