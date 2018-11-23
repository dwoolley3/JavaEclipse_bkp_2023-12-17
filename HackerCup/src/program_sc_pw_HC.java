import java.io.*;
import java.util.*; //Scanner;


public class program_sc_pw_HC
{
	public static void main(String[] args) throws IOException
	{
		Scanner      in = new Scanner(new FileReader("src/A_input_ex.txt"));
		PrintWriter out = new PrintWriter("src/A_output_ex.txt");

		int T = in.nextInt();  
		in.nextLine(); //use after a nextInt() and prior to reading another in.nextLine()

		for (int tc = 1; tc <= T; tc++)
		{
			int n = in.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
			{
				a[i] = in.nextInt();
			}

			int aa = in.nextInt();
			int bb = in.nextInt();
			int nn = in.nextInt();

			String line = in.nextLine();
			char[] ch = in.next().toCharArray();
			char[] chs = in.nextLine().toLowerCase().toCharArray();
			out.println(aa + bb + nn + line + ch[0] + chs[0]);

			String ans = "";
			out.println("Case #" + tc + ": " + ans);
		}

		out.close();
		in.close();
	}
}