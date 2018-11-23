package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

//******* This program is not yet functional in Java; Method DivMod needs work.

public class R191_Div2_C //Name: Magic Five
{
	public static void main(String[] args) {
		Scanner      in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		solve(in, out);
		out.close();
		in.close();	
	}
	
	static int MOD = 1_000_000_007;
	
	public static void solve(Scanner in, PrintWriter out)
	{
        String a = in.next();
        long k = in.nextLong();
        long n = a.length();

        long cnt = 0;
        for (int i = 0; i < a.length(); i++)
        {
            if (a.charAt(i) == '5' || a.charAt(i) == '0')
            {
                cnt = (cnt + GetBigPowerMod(2, i, MOD)) % MOD;
                long dif = GetBigPowerMod(2, n * k, MOD) - GetBigPowerMod(2, n, MOD);
                if (dif < 0) dif += MOD;
                long p = MulMod(GetBigPowerMod(2, i, MOD),dif);
                //p = DivMod(p, (GetBigPowerMod(2, n, MOD) - 1));
                cnt = (cnt + p) % MOD;
            }
        }
		
		out.println(cnt);		
	}

    static long GetBigPowerMod(long b, long n, int m)
    {
        //num will be b^n mod m; for n, m up to 1e10
        //long num = 1
        //for (int i = 0; i < n; i++)
        //    num = (num * b) % m;

        long num = 1;
        while (n > 0)
        {
            if (n % 2 == 1)
                num = (num * b) % m;
            b = (b * b) % m;
            n /= 2;
            //Console.WriteLine("{0} {1} {2}", num, b, n);
        }
        return num;
    }
    
//    static long GCDex(long a, long b, ref long nx, ref long ny)
//    {
//        if (b == 0)
//        {
//            nx = 1;
//            ny = 0;
//            return a;
//        }
//        long x = 0, y = 0;
//        long d = GCDex(b, a % b, ref x, ref y);
//        nx = y;
//        ny = x - (a / b) * y;
//        return d;
//    }
//    static long ModInv(long a)
//    {
//        long f = 0, g = 0;
//        if (GCDex(a, MOD, ref f, ref g) != 1)  //MOD must be prime
//            throw new System.ArgumentException("No Inverse");
//        f %= MOD;
//        f += MOD;
//        f %= MOD;
//        if (MulMod(a, f) != 1)
//            throw new System.ArgumentException("No Inverse");
//        return f;
//    }
//    static long DivMod(long a, long b)
//    {
//        return MulMod(a, ModInv(b));
//    }
    static long MulMod(long x, long y)
    {
        return (x * y) % MOD;
    }
}
