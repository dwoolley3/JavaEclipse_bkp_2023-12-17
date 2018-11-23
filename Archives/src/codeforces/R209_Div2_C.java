package codeforces;
import java.util.*; //Scanner;

public class R209_Div2_C  //Name: R212_Div2_A
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
        int x = sc.nextInt();
        int MOD = 1_000_000_007;

        int[] a = new int[n];
        long[] p = new long[n];
        long sum = 0;
        for (int i = 0; i < n; i++)
        {
            a[i] = sc.nextInt();
            sum += a[i];
        }            

        for (int i = 0; i < n; i++)
            p[i] = sum - a[i];
        Arrays.sort(p);
         
        //Determine the number of identical exponents that sum to a higher power
        //e.g. 2^2 + 2^2 = 2^3, 3^4 + 3^4 + 3^4 = 3^5
        long pow = p[0];
        long curPow = p[0];
        int samePcnt = 1, addPow;

        if (sum == 0)
        {
        	System.out.println(1);
            sc.close();
            return;
        }

        for (int i = 1; i <= n; i++)
        {
            if (i < n && p[i] == curPow) 
                samePcnt++;
            else
            {
                if (samePcnt > 0 && samePcnt % x == 0)
                {
                    addPow = samePcnt / x;
                    pow++;
                    samePcnt = addPow;

                    i--; //look in rest of array for higher power
                    curPow++;
                    if (curPow == sum) break;
                }
                else
                    break;
            }
        }

        long ans = GetBigPowerMod(x, pow, MOD);
		
		System.out.println(ans);
		sc.close();
	}
	
    static long GetBigPowerMod(long b, long n, int m)
    {
        //num will be b^n mod m; for n, m up to 1e10
        long num = 1;
        while (n > 0)
        {
            if (n % 2 == 1)
                num = (num * b) % m;
            b = (b * b) % m;
            n /= 2;
        }
        return num;
    }
}
