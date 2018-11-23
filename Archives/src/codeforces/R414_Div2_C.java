package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R414_Div2_C
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R414_Div2_C().run();
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
		int n = s.length();
		int[] sa = new int[26];
		int[] ta = new int[26];
		for (int i = 0; i < n; i++) 
		{
			sa[s.charAt(i)-'a']++;
			ta[t.charAt(i)-'a']++;
		}
		
		int cnt = 0, numLet = n/2 + (n%2), saWorstInd = 0;
		for (int i = 0; i < 26; i++)
		{
			cnt += sa[i];
			if (cnt >= numLet)
			{
				sa[i] -= (cnt - numLet);
				saWorstInd = i;
				break;
			}
		}
		
		cnt = 0; 
		numLet = n/2;
		int taWorstInd = 0;
		for (int i = 25; i >= 0; i--)
		{
			cnt += ta[i];
			if (cnt >= numLet)
			{
				ta[i] -= (cnt - numLet);
				taWorstInd = i;
				break;
			}
		}
		int sind = 0, tind = 25;
		while (sa[sind] == 0) sind++;
		while (ta[tind] == 0) tind--;

		StringBuilder sbBegin = new StringBuilder();
		StringBuilder sbEnd = new StringBuilder();
		for (int i = 0; i < n; i++)
		{
			if (i % 2 == 0)
			{				
				if (sind <= taWorstInd)
				{
					sbBegin.append((char)('a' + sind));
					sa[sind]--;
					if (i < n-2)
						while (sa[sind] == 0) sind++;
				}
				else
				{
					sbEnd.append((char)('a' + saWorstInd));
					sa[saWorstInd]--;
					if (i < n-2)
						while (sa[saWorstInd] == 0) saWorstInd--;
				}
			}
			else
			{
				if (tind >= saWorstInd)
				{
					sbBegin.append((char)('a' + tind));
					ta[tind]--;
					if (i < n-2)
						while (ta[tind] == 0) tind--;
				}
				else
				{
					sbEnd.append((char)('a' + taWorstInd));
					ta[taWorstInd]--;
					if (i < n-2)
						while (ta[taWorstInd] == 0) taWorstInd--;
				}			
			}			
		}
		
		out.print(sbBegin);
		out.println(sbEnd.reverse());	
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
