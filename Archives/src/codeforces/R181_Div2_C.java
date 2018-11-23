package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R181_Div2_C //Name: Beautiful Numbers
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R181_Div2_C().run();
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
		int a = in.nextInt();
		int b = in.nextInt();
		int n = in.nextInt();
		
        ArrayList<Integer> ind = new ArrayList<Integer>();
        for (int i = 0; i <= n; i++)
        {
            int sum = a * i + b * (n - i);
            String sumS = String.valueOf(sum);
            boolean good = true;
            for (int j = 0; j < sumS.length(); j++)
            {
                int d = sumS.charAt(j) - '0';
                if (d != a && d != b)
                {
                    good = false;
                    break;
                }
            }
            if (good)
                ind.add(i);
        }

        GenerateFactorials();

        long ans = 0;
        for (int i = 0; i < ind.size(); i++)
        {
            ans += nCk(n, ind.get(i));
            ans = ans % MOD;
        }

        out.println(ans);	
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
