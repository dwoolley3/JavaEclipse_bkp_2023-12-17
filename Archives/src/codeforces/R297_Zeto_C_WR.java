package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R297_Zeto_C_WR
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R297_Zeto_C_WR().run();
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
		int c = in.nextInt();
		int hr = in.nextInt();
		int hb = in.nextInt();
		int wr = in.nextInt();
		int wb = in.nextInt();
		
		long maxr = (c / wr) * hr + ((c % wr) / wb) * hb;
		int rmaxInd = (c/wr);
		long maxb = (c / wb) * hb + ((c % wb) / wr) * hr;
		int bmaxInd = c/wb;
		
		if (maxr > maxb)
		{
			int rInd = rmaxInd;			
			long happy = maxr+1;
			while (rInd >= 0 && happy >= maxr)
			{				
				happy = rInd * hr + ((c-rInd*wr) / wb) * hb;
				maxr = Math.max(happy,maxr);
				rInd--;
			}
			out.println(maxr);
		}
		else if (maxr < maxb)
		{
			int bInd = bmaxInd;			
			long happy = maxb+1;
			while (bInd >= 0 && happy >= maxb)
			{				
				happy = bInd * hb + ((c-bInd*wb) / wr) * hr;
				maxb = Math.max(happy,maxb);
				bInd--;
			}
			out.println(maxb);
		}
		else //maxr == maxb
		{
			int rInd = rmaxInd;			
			long happy = maxr+1;
			while (rInd >= 0 && happy >= maxr)
			{				
				happy = rInd * hr + ((c-rInd*wr) / wb) * hb;
				maxr = Math.max(happy,maxr);
				rInd--;
			}
			int bInd = bmaxInd;			
			happy = maxb+1;
			while (bInd >= 0 && happy >= maxb)
			{				
				happy = bInd * hb + ((c-bInd*wb) / wr) * hr;
				maxb = Math.max(happy,maxb);
				bInd--;
			}
			out.println(Math.max(maxb,  maxr));
		}
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
