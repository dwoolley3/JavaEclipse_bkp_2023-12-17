
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class bitmask_R229_Rocket_C1
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
		
		int[] p = new int[n];
		int[] e = new int[n];
		for (int i = 0; i < n; i++) 
		{
			p[i] = in.nextInt();
			e[i] = in.nextInt();
		}
		
		int minEffort = Integer.MAX_VALUE;
		for (int bitmask = 0; bitmask < 1<<n; bitmask++) //2^n
		{
			int win = 0, effort = 0;
			int[] p2 = new int[n];
			boolean[] won = new boolean[n];
			for (int i = 0; i < n; i++) p2[i] = p[i];
			for (int j = 0; j < n; j++)
				if ((bitmask & (1 << j)) != 0) //win
				{
					win++;
					effort += e[j];
					won[j] = true;
				}
				else //lose
				{		
					p2[j]++;
				}
	        
			Arrays.sort(p2);
			int place = n+1;
			int i = 0;
			while (i < n && p2[i] < win)
			{
				i++; place--; 
			}
			
			if (i < n && p2[i] == win)
			{
				for (int j = 0; j < n; j++)
					if (p[j]==win && won[j]) place--;
			}
		
			if (place <= k)
				minEffort = Math.min(minEffort,  effort);

		}
		if (minEffort == Integer.MAX_VALUE)
			out.println(-1);
		else
			out.println(minEffort);	
	}
}
