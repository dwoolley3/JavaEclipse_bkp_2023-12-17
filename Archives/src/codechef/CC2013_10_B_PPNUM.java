package codechef;
//import java.io.*;
import java.util.Scanner;

class CC2013_10_B_PPNUM {
	
	static long MOD = 1000000007;

    public static void main(String[] args)
    {
    	Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();  //Integer.parseInt(sc.next());
        for (int t = 0; t < T; t++)
        {
            //String[] s = sc.nextLine().split(" ");
            int L = sc.nextInt(); // Integer.parseInt(s[0]);
            int R = sc.nextInt(); // Integer.parseInt(s[1]);
            long ans = calc(L, R);
            System.out.println(ans);
        }
        sc.close();
    }

    static long calc(int l, int r)
    {
        int llen = (l+"").length();
        int rlen = (r+"").length();
        long cnt = 0, sum = 0;
        int[] nine = new int[] {-1, 9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999 };
        for (int i = llen; i <= rlen; i++)
        {
            if (i == llen && i == rlen)
            {
                sum = count(l,r);
            }
            else if (i == llen)
            {
                sum = count(l, nine[i]);
            }
            else if (i == rlen)
            {
                sum = count(nine[i - 1] + 1, r);
            }
            else
            {
                sum = count(nine[i - 1] + 1, nine[i]);
            }
            sum = sum * i;
            sum = sum % MOD;
            cnt += sum;
            cnt = cnt % MOD;
        }
        return cnt;
    }
    static long count(long a, long b)
    {
        //sum a to b
        long sum = ((a + b) * (b - a + 1) / 2);
        return sum;
    }
}
