package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class Ed_2017_R26_C
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new Ed_2017_R26_C().run();
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
		int a = in.nextInt();
		int b = in.nextInt();
				
		int[] x = new int[n];
		int[] y = new int[n];
		for (int i = 0; i < n; i++) {
			x[i] = in.nextInt();
			y[i] = in.nextInt();
		}
		
		int maxarea = 0;
		for (int i = 0; i < n-1; i++) {
			for (int j = i+1; j < n; j++)
				if ((x[i]+x[j] <= a && Math.max(y[i],y[j]) <= b)
				||  (x[i]+y[j] <= a && Math.max(y[i],x[j]) <= b)
				||  (y[i]+y[j] <= a && Math.max(x[i],x[j]) <= b)
				||  (y[i]+x[j] <= a && Math.max(x[i],y[j]) <= b))
					maxarea = Math.max(maxarea, x[i]*y[i] + x[j]*y[j]);	
			
				else if((x[i]+x[j] <= b && Math.max(y[i],y[j]) <= a)
				||  (x[i]+y[j] <= b && Math.max(y[i],x[j]) <= a)
				||  (y[i]+y[j] <= b && Math.max(x[i],x[j]) <= a)
				||  (y[i]+x[j] <= b && Math.max(x[i],y[j]) <= a))
					maxarea = Math.max(maxarea, x[i]*y[i] + x[j]*y[j]);	
		}

		out.println(maxarea);	
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
