package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R284b_GoodBye_B
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R284b_GoodBye_B().run();
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
		
		int[] p = new int[n];
		for (int i = 0; i < n; i++) 
			p[i] = in.nextInt();
		
		StringBuilder[] m = new StringBuilder[n];
		for (int i = 0; i < n; i++) 
			m[i] = new StringBuilder(in.next());

	    for (int i = 0; i < n; i++) 
	        for (int j = 0; j < n; j++) 
	            if (m[i].charAt(j) == '1') 
	                for (int k = 0; k < n; k++) 
	                    if (m[i].charAt(k) == '1')
	                        m[k].setCharAt(j,'1');

	    for (int i = 0; i < n; i++) 
	        for (int j = i + 1; j < n; j++)
	        	if (m[i].charAt(j) == '1' && p[i] > p[j])
				{
					int t = p[i]; p[i] = p[j]; p[j] = t;
				}    
		
		for (int i = 0; i < n; i++)	
			out.print(p[i] + " ");
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
