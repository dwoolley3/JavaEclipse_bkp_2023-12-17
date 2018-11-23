package codechef;
import java.io.*;	 // .BufferedReader, .InputStreamReader
import java.util.*;  // .Scanner

public class CC2013_11_C_NEXTNUM
{
    public static void main(String[] args) throws Exception
    {            
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        for (int t = 0; t < T; t++)
        {
            String s = in.readLine();
            int n = s.length();
            int[] d = new int[n];
            ArrayList<Character> c = new ArrayList<Character>();
            int[] a = new int[10];
            int[] rankDig = new int[10];
            for (int i = 0; i < n; i++)
            {
                d[i] = s.charAt(i) - '0';
                a[d[i]]++;
                if (!c.contains(s.charAt(i))) c.add(s.charAt(i));
            }

            int rank = 0;
            for (int i = 0; i < 10; i++)
                if (a[i] > 0) rankDig[i] = ++rank;

            long sum = 0;
            for (int i = 0; i < n; i++)
            {
                a[d[i]]--;
                rank = 0;
                for (int j = 0; j < 10; j++)
                    if (a[j] > 0) rankDig[j] = ++rank;

                int tRank = rank;
                long prod = 1;
                for (int j = 0; j < n - i - 1; j++)
                {
                    prod *= tRank;
                    if (tRank > 1) tRank--;
                }
                sum += (prod * (rankDig[d[i]] - 1));
            }
            sum++;

            System.out.println(sum);
        }
    }
}
