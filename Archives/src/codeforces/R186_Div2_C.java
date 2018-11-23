package codeforces;
import java.util.*; //Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter; //PrintWriter

public class R186_Div2_C //Name: Ilya and Matrix
{
	public static void main(String[] args) throws IOException {
		//Scanner      in = new Scanner(System.in);
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter   out = new PrintWriter(System.out);
		solve(in, out);
		out.close();
		in.close();	
	}
	
	public static void solve(BufferedReader in, PrintWriter out) throws IOException
	{
		int n = Integer.parseInt(in.readLine());
		
		int[] a = new int[n];
		long total = 0;
		String[] s = in.readLine().split(" ");
		for (int i = 0; i < n; i++)
		{
			a[i] = Integer.parseInt(s[i]);
			total += a[i];
		}
		
		Random rnd = new Random();
		int ra, temp;
		for (int i = 0; i < n; i++) {
			ra = rnd.nextInt(i + 1);
			temp = a[i];
			a[i] = a[ra];
			a[ra] = temp;
		}		
        Arrays.sort(a);
        
        int num = 1;
        int prod = 1;
        while (prod < n)
        {
            num++;
            prod *= 4;
        }

        long sum = 0;
        prod = 1;
        for (int i = 0; i < num-1; i++)
        {
            for (int j = n-1; j >= n - prod; j--)
                sum += a[j];
            prod *= 4;
        }
        sum += total;
		
		out.println(sum);		
	}
}
