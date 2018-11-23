package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R202_Div2_B //Name: Color the Fence
{
	public static void main(String[] args) {
		Scanner      in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		solve(in, out);
		out.close();
		in.close();	
	}
	
	public static void solve(Scanner in, PrintWriter out)
	{
		int v = in.nextInt();	

		int[] a = new int[10];
        int min = Integer.MAX_VALUE, mini = 0;
        for (int i = 1; i <= 9; i++)
        {
            a[i] = in.nextInt();
            if (a[i] <= min)
            {
                min = a[i];
                mini = i;
            }
        }

        int d1 = v / min;
        int avail = v % min;

        if (d1 == 0)
        {
            out.println(-1);
            return;
        }

        StringBuilder sb = new StringBuilder();
        boolean gotOne = true;
        int lastHi = 9;
        while (gotOne && d1 > 0)
        {
            avail += min;  //assume
            gotOne = false;
            for (int i = lastHi; i > mini; i--)
            {
                if (avail >= a[i])
                {
                    sb.append(i + "");
                    avail -= a[i];
                    lastHi = i;
                    d1--;
                    gotOne = true;
                }
            }
        }
        for (int i = 0; i < d1; i++)
            sb.append(mini + "");
		
		out.println(sb);		
	}
}
