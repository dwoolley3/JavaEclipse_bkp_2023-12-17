package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R314_Div2_D
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R314_Div2_D().run();
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
		int k = in.nextInt(); //number of ships
		int a = in.nextInt(); //size of each ship
		
		int m = in.nextInt();
		int maxFit = (n+1) / (a+1);
		TreeSet<Integer> ts = new TreeSet<Integer>(); 
		ts.add(0); ts.add(n+1);
		for (int i = 0; i < m; i++) 
		{
			int x1 = in.nextInt();
			ts.add(x1);
			int x0 = ts.floor(x1-1);
			int x2 = ts.ceiling(x1+1);
			int before = (x2 - x0) / (a+1);
			int after = (x2 - x1) / (a+1) + (x1 - x0) / (a+1);
			maxFit -= (before - after);
			//out.println((i+1) + " " + maxFit);
			if (maxFit < k)
			{
				out.println(i+1);
				return;
			}
		}
			
		out.println(-1);		
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
