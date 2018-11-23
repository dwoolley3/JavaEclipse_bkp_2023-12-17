package codeforces;
import java.util.*; //Scanner;

public class R205_Div2_B  //Name: Two Heaps
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

        int[] a = new int[2*n];
        int[] b = new int[2 * n];
        int[] d = new int[100];
        boolean[] tb = new boolean[100];
        boolean top = true;
        for (int i = 0; i < n*2; i++)
        {
            a[i] = sc.nextInt();
            d[a[i]]++;
        }

        int cnt = 0, tbcnt = 0;
        for (int i = 10; i <= 99; i++)
        {
            if (d[i] > 0) cnt++;
            if (d[i] > 1 && d[i] % 2 == 1)
            {
                tb[i] = top;
                top = !top;
                tbcnt++;
            }
        }
        int st = 1;
        for (int i = 10; i <= 99; i++)
        {
            if (d[i] > 1)
            {
                if (tb[i]) st = 1; else st = 2;
                for (int j = 0; j < n*2; j++)
                {
                    if (a[j] == i)
                    {
                        b[j] = st;
                        st = 3 - st;  //2 --> 1, 1 --> 2
                    }
                }
            }
        }
        if (tbcnt % 2 == 0) st = 1; else st = 2;
        for (int j = 0; j < n * 2; j++)
        {
            if (d[a[j]] == 1)
            {
                b[j] = st;
                st = 3 - st;
            }
        }

        int[] t = new int[n];
        int[] b2 = new int[n];
        int tcnt = 0, b2cnt = 0;
        for (int j = 0; j < n * 2; j++)
            if (b[j] == 1) t[tcnt++] = a[j]; else b2[b2cnt++] = a[j];

        //cnt = t.Distinct().Count() * b2.Distinct().Count();

		System.out.println(cnt);
        for (int j = 0; j < n * 2; j++)
        {
            if (j > 0)
            	System.out.print(" ");
            System.out.print(b[j]);
        }

		System.out.println();
		sc.close();
	}
}
