package hackercup;
import java.io.*;
import java.util.*; //Scanner;


public class HC_2014_R1_C
{
	public static void main(String[] args) throws IOException
	{
		Scanner      in = new Scanner(new FileReader("src/C_input_ex.txt"));
		PrintWriter out = new PrintWriter("src/C_output_ex.txt");

		int T = in.nextInt();  

		for (int tc = 1; tc <= T; tc++)
		{
			int n = in.nextInt();
			int m = in.nextInt();

			char[][] c = new char[n][m];
			for (int i = 0; i < n; i++)
				c[i] = in.next().toCharArray();
			
			for (int d1 = 0; d1 < n; d1++)
				for (int r1 = 0; r1 < m; r1++)
					for (int u1 = 0; u1 < n; u1++)
						for (int d2 = 0; d2 < n; d2++);

			String ans = "";
			out.println("Case #" + tc + ": " + ans);
		}

		out.close();
		in.close();
	}
}