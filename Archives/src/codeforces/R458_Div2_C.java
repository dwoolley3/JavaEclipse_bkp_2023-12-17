package codeforces;

import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R458_Div2_C
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R458_Div2_C().run();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	
	static int MOD = (int)(1e9 + 7);
	
	//up to n = 500
    public static long[][] generateBinomialCoefficients(int n) {
        long[][] nCr = new long[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
        	nCr[i][0] = 1;
            for (int j = 1; j <= i; j++) {
            	nCr[i][j] = nCr[i - 1][j - 1] + nCr[i - 1][j];
            	nCr[i][j] = nCr[i][j] % MOD;
            }
        }
        return nCr;
    }
	
	void solve()
	{
		String n = in.next();
		int k = in.nextInt();
		
		if (k == 0) {
			out.println(1);
			return;
		}		
		
		int nlen = n.length();
		int[] a = new int[nlen+1];
		for (int i = 1; i <= nlen; i++) {
			int x = i;
			int red = 1;
			while (x > 1) 
			{
				red++;
				int bits = Integer.bitCount(x);
				x = bits;
			}
			a[i] = red;
			//out.println(i + " " + a[i]);
		}
		
		long ans = 0;
		int MOD = (int)(1e9 + 7);
		long[][] nCr = generateBinomialCoefficients(nlen+5);
		for (int i = 1; i <= nlen; i++) {
			if (a[i] != k) continue;
			//how many ways to place a[i] bits such that it is <= n
			//add nlen-1 C a[i]			
			//out.println("i=" + i);
			long x = nCr[nlen][i];
			//out.println(x + " = " + nlen + " " + i);
			
			int cnt = 0;
			for (int j = 0; j < nlen; j++) {
				cnt++;
				if (n.charAt(j) == '0') {
					int r = i - cnt;
					if (r > 0) {
						long x2 = nCr[nlen-cnt][r];
						x -= x2;
						if (x < 0) x += MOD;
					}
					cnt--;
				}
			}
			ans += x;
			ans = ans % MOD;
		}
		out.println(ans);		
	}

	//-----------------------------------------------------
	void runWithFiles() {
		in = new FastReader(new File("input.txt"));
		try {
			out = new PrintWriter(new File("output.txt"));
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		solve();
		out.close();
	}
	
	class FastReader
	{
	    BufferedReader br;
	    StringTokenizer tokenizer;
	    
	    public FastReader(InputStream stream)
	    {
	        br = new BufferedReader(new InputStreamReader(stream));
	        tokenizer = null;
	    }
		public FastReader(File f) {
			try {
				br = new BufferedReader(new FileReader(f));
				tokenizer = null;
			}
			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	    
	    private String next() {
	        while (tokenizer == null || !tokenizer.hasMoreTokens())
	            try {
	            	tokenizer = new StringTokenizer(br.readLine());
	            }
	            catch (IOException e) {
	                throw new RuntimeException(e);
	            }
	        return tokenizer.nextToken();
	    }
		public String nextLine() {
			try	{
				return br.readLine();
			}
			catch(Exception e) {
				throw(new RuntimeException());
			}
		}

	    int nextInt() {
	        return Integer.parseInt(next());
	    }
	    long nextLong() {
	        return Long.parseLong(next());
	    }
	    double nextDouble() {
	        return Double.parseDouble(next());
	    }	    
	    BigInteger nextBigInteger() {
	        return new BigInteger(next());
	    }
	    BigDecimal nextBigDecimal() {
	        return new BigDecimal(next());
	    }
	}
}
