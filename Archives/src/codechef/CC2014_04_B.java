package codechef;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


//For Code Chef, do not precede class Program with "public"
class CC2014_04_B //Name: BiCo Gaming Grid, not working in some cases
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new CC2014_04_B().run();
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
		long[][] a = new long [1000001][51];
		for (int n = 1; n < 100; n++)
			for (int r = 1; r <= Math.min(n,50); r++)
				a[n][r] = binomial(n,r);
		
		for (int n = 1; n < 1000001; n++)
			for (int r = 1; r <= 8; r++)
				a[n][r] = binomial(n,r);
			
        int T = in.nextInt();
        for (int t = 0; t < T; t++)
        {
			@SuppressWarnings("unused")
			int R = in.nextInt();
			int C = in.nextInt();	
			long G = in.nextLong();	
			long priorA = (long)1e12 + 1;
			
			StringBuilder sb = new StringBuilder();
			
			int i = C;
			for (i = C; i > 1 && G > 0; i--)
			{
				int nInd = i;
				while (a[nInd][i] <= G && a[nInd][i] != 0 && a[nInd][i] <= priorA) nInd++;
				nInd--;
				sb.append(a[nInd][i] + " ");
				//out.println("** " + nInd + " " + i);
				G -= a[nInd][i];
				priorA = a[nInd][i];
			}
			if (G > 0) { sb.append(G); i--; }
			out.println(C - i);			
			out.println(sb.toString());	
        }	
	}

    static public long binomial(long n, long r)
    {
        //Maximum value for n is 66; (67,30..67,37 will overflow long)
        double p = 1.0;
        for (int i = 0; i < r; i++)
            p = p * (n-i) / (i+1);
        if (p > 1e12)
            return 0;
        return (long)p;
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
