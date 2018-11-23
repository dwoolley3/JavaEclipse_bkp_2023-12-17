package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R293_Div2_B
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R293_Div2_B().run();
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
		String s = in.next();
		String t = in.next();
		int ns = s.length();
		int nt = t.length();
		int y = 0, w = 0;
		
		int[] cntS = new int[52];
		int[] cntT = new int[52];
		for (int i = 0; i < ns; i++) 
		{
			char c = s.charAt(i);
			if (c >= 'a' && c <= 'z') cntS[c-'a']++;
			else 
				if (c >='A' && c <= 'Z') cntS[c-'A' + 26]++;
		}
		for (int i = 0; i < nt; i++) 
		{
			char c = t.charAt(i);
			if (c >= 'a' && c <= 'z') cntT[c-'a']++;
			else 
				if (c >='A' && c <= 'Z') cntT[c-'A' + 26]++;
		}
		
		for (int i = 0; i < 26; i++) 
		{
			int cLow = Math.min(cntS[i], cntT[i]);
			int cUp = Math.min(cntS[i+26], cntT[i+26]);
			//int max = Math.max(cUp, cLow);
			y += (cLow + cUp);
			w += Math.min(cntS[i] + cntS[i+26] - (cLow+cUp),
					cntT[i] + cntT[i+26] - (cLow + cUp));
			//y += max;
			//w += (cntS[i] + cntS[i+26] - max);
		}
		
		out.println(y + " " + w);		
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
