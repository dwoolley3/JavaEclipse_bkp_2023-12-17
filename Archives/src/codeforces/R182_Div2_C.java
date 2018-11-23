package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R182_Div2_C //Name: Yaroslav and Sequence
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
		int n = in.nextInt();	
        int last = 2 * n - 1;
        int[] a = new int[last];

        int neg = 0, sum = 0;
        for (int i = 0; i < last; i++)
        {
            a[i] = in.nextInt();
            if (a[i] < 0)
            {
                neg++;
                a[i] = -a[i];
            }
            sum += a[i];                
        }

        Arrays.sort(a);
        if (n % 2 == 0 && (neg % n) % 2 == 1) 
            sum -= a[0]*2;
		
		out.println(sum);		
	}
}
