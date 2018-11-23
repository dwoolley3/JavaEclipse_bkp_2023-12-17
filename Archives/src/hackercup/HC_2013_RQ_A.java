package hackercup;
import java.io.*;
import java.util.*; //Scanner;

public class HC_2013_RQ_A
{
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(new FileReader("src/input_A_ex.txt"));
		PrintWriter pw = new PrintWriter("src/output_A_ex.txt");

		int t = sc.nextInt();
		sc.nextLine();

		for (int tc = 1; tc <= t; tc++)
		{
			String line = sc.nextLine();
            int sum = 0;
            int[] a = new int[26];
            for (int i = 0; i < line.length(); i++)
            {
                char c = line.charAt(i);
                if (c >= 'a' && c <= 'z')
                    a[c - 'a']++;
                else if (c >= 'A' && c <= 'Z')
                    a[c - 'A']++;
            }
            Arrays.sort(a);
            for (int i = 25; i >= 0; i--)
                sum += a[i] * (i+1);
            
			pw.println("Case #" + tc + ": " + sum);
		}

		pw.close();
		sc.close();
	}
}