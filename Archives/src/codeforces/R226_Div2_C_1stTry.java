package codeforces;


//import java.util.*; //Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter; //PrintWriter
import java.util.ArrayList;

public class R226_Div2_C_1stTry //Name: Bear and Prime Numbers
{
	public static void main(String[] args) throws IOException {
		//Scanner      in = new Scanner(System.in);
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter   out = new PrintWriter(System.out);
		solve(in, out);
		out.close();
		in.close();	
	}
	
	static int lastPrime = 0;
	public static void solve(BufferedReader in, PrintWriter out) throws IOException
	{
		boolean[] prime = seive(10_000_000);	
		ArrayList<Integer> pr = new ArrayList<Integer>();
		for (int i = 0; i < 10_000_000; i++)
			if (prime[i]) pr.add(i);
		int lastPrime = pr.get(pr.size()-1);
		
		int[] num = new int[10_000_000];
		
		int n = Integer.parseInt(in.readLine());		
		String[] s = in.readLine().split(" ");
		int x;
		for (int i = 0; i < n; i++) 
		{
			x = Integer.parseInt(s[i]);
			if (pr.contains(x))
				num[x]++;
			else
				for (int j = 0; j < pr.size() && pr.get(j)*2 <= x; j++)
					if (x % pr.get(j) == 0) num[pr.get(j)]++;
		}
		long[] f = new long[pr.size()];
		f[0] = pr.get(0);
		for (int i = 1; i < pr.size(); i++)
			f[i] = f[i-1] + num[pr.get(i)];
		
		int m = Integer.parseInt(in.readLine());
		int l, r;
		for (int i = 0; i < m; i++) 
		{
			s = in.readLine().split(" ");
			l = Integer.parseInt(s[0]);
			r = Integer.parseInt(s[1]);
			if (r > lastPrime) r = lastPrime;
			
			long sum = 0; 
			//long sum = f[r];
			for (int j = 0; j < pr.size(); j++)
				if (pr.get(j) >= l && pr.get(j) <= r)
					sum += num[pr.get(j)];			
			out.println(sum);
		}
	}
	
    static boolean[] seive(int n)
    {
        //Return all primes between 0 and n using Seive of Eratosthenes
    	boolean[] prime = new boolean[n + 1];
        for (int i = 0; i <= n; i++) prime[i] = true;  //15% longer to initialize
        prime[0] = false;
        prime[1] = false;
        for (int i = 2; i * i <= n; i++)
            if (prime[i])
                for (int k = i * i; k <= n; k += i)
                    prime[k] = false;
        
        return prime;
    }
}
