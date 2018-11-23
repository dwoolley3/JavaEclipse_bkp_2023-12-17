import java.io.*;

public class program_br_pw_HC
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader(new FileReader("src/A_input_ex.txt"));
		PrintWriter   out = new PrintWriter("src/A_output_ex.txt");

		int T = Integer.parseInt(in.readLine());

		for (int tc = 1; tc <= T; tc++)
		{
			int n = Integer.parseInt(in.readLine());
			String[] st = in.readLine().split(" ");
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
			{
				a[i] = Integer.parseInt(st[i]);
			}

			String[] s = in.readLine().split(" ");
			int aa = Integer.parseInt(s[0]);
			int bb = Integer.parseInt(s[1]);
			int nn = Integer.parseInt(s[2]);
			String line = in.readLine();
			out.println(aa + bb + nn + line);

			String ans = "";
			out.println("Case #" + tc + ": " + ans);
		}

		in.close();
		out.close();
	}
}