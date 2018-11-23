package hackercup;
import java.io.*;
import java.util.*; //Scanner;


public class HC_2014_RQ_A
{
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(new FileReader("src/input_A.txt"));
		PrintWriter pw = new PrintWriter("src/output_A.txt");

		int t = sc.nextInt();  

		for (int tc = 1; tc <= t; tc++)
		{
			int n = sc.nextInt();
            int minr = 21, maxr = -1, minc = 21, maxc = -1, cnt = 0;
            for (int i = 0; i < n; i++)
            {
                String s = sc.next();                
                for (int j = 0; j < n; j++)
                    if (s.charAt(j) == '#')
                    {
                    	cnt++;
                        minr = Math.min(i, minr);
                        maxr = Math.max(i, maxr);
                        minc = Math.min(j, minc);
                        maxc = Math.max(j, maxc);
                    }
            }

            String ans = "YES";
            int height = maxr - minr + 1;
            int width = maxc - minc + 1;
            if (height != width || height * width != cnt)
                ans = "NO";

			pw.println("Case #" + tc + ": " + ans);
		}

		pw.close();
		sc.close();
	}
}