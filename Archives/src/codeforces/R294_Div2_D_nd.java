package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R294_Div2_D_nd
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R294_Div2_D_nd().run();
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
		int[] x = new int[26];
		for (int i = 0; i < 26; i++) 
			x[i] = in.nextInt();
		
		String s = in.next();
		int n = s.length();
		
		@SuppressWarnings("unchecked")
		HashMap<Long, Long>[] hm = new HashMap[26];
        for (int i = 0; i < 26; i++)
            hm[i] = new HashMap<Long, Long>();
        
        long sum = 0, cnt = 0;
		for (int i = 0; i < n; i++)
		{
			int letInd = s.charAt(i)-'a';
			cnt += hm[letInd].getOrDefault(sum, 0L);
			sum += x[letInd];
			hm[letInd].put(sum, hm[letInd].getOrDefault(sum, 0L) + 1);
		}
		
		out.println(cnt);
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
