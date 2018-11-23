package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R229_Rocket_D1
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
		int ns = in.nextInt();	
		int ew = in.nextInt();
		
		int[] nsX = new int[ns];
		int[] nsY = new int[ns];
		int[] nsL = new int[ns];
		for (int i = 0; i < ns; i++) 
		{
			nsX[i] = in.nextInt();
			nsY[i] = in.nextInt();
			nsL[i] = in.nextInt();
		}
		
		int[] ewX = new int[ew];
		int[] ewY = new int[ew];
		int[] ewL = new int[ew];
		for (int i = 0; i < ew; i++) 
		{
			ewX[i] = in.nextInt();
			ewY[i] = in.nextInt();
			ewL[i] = in.nextInt();
		}
		
		int max = 0, min, a1, a2, a3, a4;
		for (int i = 0; i < ns; i++)
			for (int j = 0; j < ew; j++)
			{
				if (nsX[i] >= ewX[j] && nsX[i] <= ewX[j]+ewL[j]
				&&  ewY[j] >= nsY[i] && ewY[j] <= nsY[i]+nsL[i])
				{
					a1 = nsX[i] - ewX[j];
					a2 = ewX[j]+ewL[j] - nsX[i];
					a3 = ewY[j] - nsY[i];
					a4 = nsY[i]+nsL[i] - ewY[j];
					min = Math.min(Math.min(Math.min(a1, a2),a3),a4);
					max = Math.max(max, min);
				}
			}
		
		out.println(max);		
	}
}
