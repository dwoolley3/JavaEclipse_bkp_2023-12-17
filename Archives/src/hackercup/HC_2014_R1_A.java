package hackercup;
import java.io.*;
import java.util.*; //Scanner;


public class HC_2014_R1_A
{
	public static void main(String[] args) throws IOException
	{
		Scanner      in = new Scanner(new FileReader("src/A_input.txt"));
		PrintWriter out = new PrintWriter("src/A_output.txt");

		int T = in.nextInt();  
		in.nextLine(); //use after a nextInt() and prior to reading another in.nextLine()

		for (int tc = 1; tc <= T; tc++)
		{
			char[] c = in.next().toCharArray();
			int L = c.length;
			long n = in.nextLong();
			
			long prod = 1, sum = 0, numLet = 1, ntemp = n;
			while (ntemp - (prod * L) > 0 && (prod * L > 0))
			{
				numLet++;
				prod *= L;
				ntemp -= prod;
				sum += prod;
			}
			
			long rem = n - sum - 1;
			
			StringBuilder sb = new StringBuilder();
			int lettersAdded = 0;
			while (rem > 0 && prod > 0)
			{
				int ind = (int)(rem / prod);
				sb.append(c[ind]);
				rem -= (ind * prod);
				prod /= L;
				lettersAdded++;
			}			
			
			//if (lettersAdded > numLet) lettersAdded = numLet;
			
			for (int i = 0; i < (numLet - lettersAdded); i++) sb.append(c[0]);
			
			System.out.println(sb);
			out.println("Case #" + tc + ": " + sb);
		}

		out.close();
		in.close();
	}
}