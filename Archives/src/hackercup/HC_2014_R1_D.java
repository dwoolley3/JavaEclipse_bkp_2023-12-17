package hackercup;
import java.io.*;
import java.util.*; //Scanner;


public class HC_2014_R1_D
{
	public static void main(String[] args) throws IOException
	{
		Scanner      in = new Scanner(new FileReader("src/D_input.txt"));
		PrintWriter out = new PrintWriter("src/D_output.txt");

		int T = in.nextInt();  

		for (int tc = 1; tc <= T; tc++)
		{
			int n = in.nextInt();
			int k = in.nextInt();
			
			int[] a = new int[n];
			int sumOfAges = 0, numOfZero = 0;
			for (int i = 0; i < n; i++)
			{
				a[i] = in.nextInt();
				sumOfAges += a[i];
				if (a[i] == 0) numOfZero++;
			}
			
			Arrays.sort(a);
			for (int i = 0; i < n; i++)
			{
				if (a[i] % k > 0)
					a[i] = a[i] + k - (a[i] % k);
				if (i != 0 && i < numOfZero)  //allow 1 zero on a[0] 
					a[i] = k;
			}

			boolean changed = false;
			do {
				changed = false;
				for (int i = 0; i < n-1; i++)
					for (int j = i+1; j < n; j++)
						while (GCD(a[i],a[j]) > k) 
						{
							if (a[i] == 0) 
								a[i] = k;
							else
								a[j] += k;
							changed = true;
						}
			} while (changed);

			int sumOfNewAges = 0;
			for (int i = 0; i < n; i++)
				sumOfNewAges += a[i];
			
			int dif = sumOfNewAges - sumOfAges;

			out.println("Case #" + tc + ": " + dif);
		}

		out.close();
		in.close();
	}
    static int GCD(int a, int b)
    {
        if (b == 0) return a;
        return GCD(b, a % b);
    }

}