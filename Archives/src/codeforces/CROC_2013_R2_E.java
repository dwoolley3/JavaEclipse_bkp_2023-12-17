package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class CROC_2013_R2_E
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new CROC_2013_R2_E().run();
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
		long n = in.nextLong();
        int cnt = 0;

        if (n % 3 == 0)
        {
            n /= 3;
            ArrayList<Long> f = new ArrayList<Long>();
            long s = (int)Math.sqrt(n);
            for (long i = 1; i <= s; i++)
                if (n % i == 0) f.add(i);

            int t = f.size();
            for (int i = 0; i < t; i++)
                for (int j = i; j < t; j++)
                {
                    long c = n / (f.get(i) * f.get(j));
                    if (f.get(i) * f.get(j) * c == n)
                    {
                        long a = f.get(i), b = f.get(j);
                        if ((a + b + c) % 2 == 1) continue;
                        if (a + b <= c) continue;
                        if (c < b) continue;
                        {
                            if (a == b && b == c)
                                cnt++;
                            else if (a == b || b == c || a == c)
                                cnt += 3;
                            else
                                cnt += 6;
                        }
                    }
                }                    
        }
		
		out.println(cnt);		
	}
	
    static boolean IsSquare(long d)
    {
        long x = (long)Math.sqrt(d + 0.1);
        return x * x == d;
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
