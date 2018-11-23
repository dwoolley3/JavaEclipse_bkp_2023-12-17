package hackerRank;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList

public class HR_101_Hack_44_4
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new HR_101_Hack_44_4().run();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	
	void solve()
	{

		int n = in.nextInt();
		int q = in.nextInt();
		String s = in.next();
		char[] sa = s.toCharArray();
		int[] cnt = new int[26];
		for (int i = 0; i < n; i++)
			cnt[sa[i]-'a']++;
		
		//int[] a = new int[n];
		long ans = 0;

		for (int i = 0; i < q; i++)
		{
			int type = in.nextInt();
			int ii = in.nextInt();
			int jj = in.nextInt();
			if (type == 2)
			{
				//out.println(1);
				for (int j = 0; j < 26; j++) cnt[j] = 0;
				for (int j = ii; j <= jj; j++)
					cnt[sa[j]-'a']++;
				for (int j = 0; j < 26; j++) 
					for (int k = 1; k <= cnt[j]; k++)
					{
						ans += nCk(cnt[j], k);
						ans %= MOD;
					}
				out.println(ans);
			}
			else //type = 1
			{
				int t = in.nextInt();
				t = t % 26;
				for (int j = ii; j <= jj; j++)
					sa[j] = (char)('a' + (sa[j] - 'a' + t) % 26);
				//for (int j = 0; j < n; j++)
				//	out.print(sa[j]);
				//out.println();
			}
		}	
		
	}
	
	long MOD = 1_000_000_007;
    long[] fact = new long[1000001];
    void GenerateFactorials()
    {
        fact[0] = 1L;
        for (int i = 1; i < 1000001; i++)
            fact[i] = fact[i - 1] * i % MOD;
    } 
    long nCk(int n, int k) {
        long f = fact[n];
        long f1 = BigInteger.valueOf(fact[k]).modInverse(BigInteger.valueOf(MOD)).longValue();
        long f2 = BigInteger.valueOf(fact[n - k]).modInverse(BigInteger.valueOf(MOD)).longValue();
        long nCk = (f * f1 % MOD) * f2 % MOD ;
        return nCk;
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
