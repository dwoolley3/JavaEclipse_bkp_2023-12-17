package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R506_Div3_C_1st
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R506_Div3_C_1st().run();
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
		
		int[] l = new int[n];
		int[] r = new int[n];
		int maxl = -1, minr = Integer.MAX_VALUE;
		int maxl2 = -1, minr2 = Integer.MAX_VALUE;
		int maxlind = 0, minrind = 0; //maxl2ind = 0, minr2ind = 0;
		for (int i = 0; i < n; i++) { 
			l[i] = in.nextInt();
			r[i] = in.nextInt();
			if (l[i] > maxl || (l[i] == maxl && r[i] <= minr))
			{
				maxl2 = maxl;
				//maxl2ind = maxlind;
				
				maxl = l[i];
				maxlind = i;					
			}
			else if (l[i] > maxl2)
			{				
				maxl2 = l[i];
				//maxl2ind = i;				
			}
			
			if (r[i] < minr || (r[i] == minr && l[i] >= maxl)) 
			{
				minr2 = minr;
				//minr2ind = minrind;
				
				minr = r[i];
				minrind = i;				
			}
			else if (r[i] < minr2) {
				minr2 = r[i];
				//minr2ind = i;
			}
		}

		int ans = 0;
		if (r[maxlind] == minr) 
			ans = minr2 - maxl2;
		else
			ans = minr2 - maxl;
		
		int ans2 = 0;
		if (l[minrind] == maxl) 
			ans2 = minr2 - maxl2;
		else
			ans2 = minr2 - maxl;
		
		ans = Math.max(ans, ans2);
		if (ans < 0) ans = 0;
		
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
