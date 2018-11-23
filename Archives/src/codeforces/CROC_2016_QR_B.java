package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class CROC_2016_QR_B
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new CROC_2016_QR_B().run();
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
		int b = in.nextInt();
		
		long tim = 0, timBeforeQ = 0;
		int[] qt = new int[n+1];
		int[] qd = new int[n+1];
		int qfirst = 0, qlast = -1;
		for (int i = 0; i < n; i++) 
		{
			int t = in.nextInt();
			int d = in.nextInt();
			while (qfirst <= qlast && timBeforeQ <= t)
			{
				timBeforeQ += qd[qfirst];
				qfirst++;				
			}
			if (qfirst > qlast)
			{
				if (t >= tim)	
				{
					tim = t + d;
					out.print(tim + " ");
					timBeforeQ = t;
				}
				else // t < tim
				{
					qlast++;
					qt[qlast] = t;
					qd[qlast] = d;
					tim += d;					
					out.print(tim + " ");
					timBeforeQ = t;
				}				
			}
			else if (qlast - qfirst + 1 < b)
			{
				qlast++;
				qt[qlast] = t;
				qd[qlast] = d;
				tim += d;
				out.print(tim + " ");
			}
			else
				out.print("-1 ");
		}	
		while (qfirst <= qlast)
		{
			timBeforeQ += qd[qfirst];
			qfirst++;				
			//out.print(tim + " ");
		}
		out.println();		
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
