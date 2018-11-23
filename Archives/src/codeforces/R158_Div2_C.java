package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R158_Div2_C
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R158_Div2_C().run();
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
		int x = in.nextInt();
		
		long[] a = new long[n+1];
		long min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) 
		{
			a[i+1] = in.nextInt();
			min = Math.min(min, a[i+1]);
		}
		
        //if more than 1 min, then choose index closest to x
        int mini = 1; ;
        for (int i = x; i >= x - n; i--)
        {
            mini = (i <= 0) ? (i + n) : i;
            if (a[mini] == min) break;
        }

        for (int j = 1; j <= n; j++)
            if (j != mini) a[j] -= min;

        int inc = x - mini; if (inc < 0) inc += n;
        a[mini] = a[mini] * n + inc;

        if (x < mini) x += n;
        int ind;
        for (int j = mini + 1; j <= x; j++)
        {
            ind = (j > n) ? j - n : j;
            a[ind]--;
        }

        for (int i = 1; i < n; i++)
        	out.print(a[i] + " ");
        out.println(a[n]);
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
