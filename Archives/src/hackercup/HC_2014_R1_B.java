package hackercup;
import java.io.*;
import java.util.*; //Scanner;


public class HC_2014_R1_B
{
	public static void main(String[] args) throws IOException
	{
		Scanner      in = new Scanner(new FileReader("src/B_input.txt"));
		PrintWriter out = new PrintWriter("src/B_output.txt");

		int T = in.nextInt();  

		for (int tc = 1; tc <= T; tc++)
		{
			int n = in.nextInt();
			int k = in.nextInt();
			int c = in.nextInt();

			int nu = n, num, ave, min = Integer.MAX_VALUE;
			while (nu > 0)
			{
				ave = k / nu;
				if (ave > 0)
				{				
					num = c;
					if (ave * nu < c) num += nu;
					num += (n - nu); //add number of 0 buckets
					min = Math.min(min, num);
				}
				nu--;				
			}

			out.println("Case #" + tc + ": " + min);
		}

		out.close();
		in.close();
	}
}