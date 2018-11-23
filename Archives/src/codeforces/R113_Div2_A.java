package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList

//* Alternatively, create a point and sort it
import java.awt.Point;
@SuppressWarnings("unused")

public class R113_Div2_A
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R113_Div2_A().run();
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
		int k = in.nextInt();
		
		int[] p = new int[n];
		for (int i = 0; i < n; i++)
			p[i] = in.nextInt() * 100 - in.nextInt();
		
		Arrays.sort(p);
		
		int cnt = 0;
		for (int i = 0; i < n; i++)
			if (p[i] == p[n-k]) cnt++;
		
		out.println(cnt);
		
//		k--;
//		int[] t = new int[n];
//		for (int i = 0; i < n; i++)
//		{
//			p[i] = in.nextInt();
//			t[i] = in.nextInt();
//		}
//		
//		for (int i = 0; i < n; i++)
//			for (int j = i+1; j < n; j++)
//				if (p[i] < p[j] || (p[i] == p[j] && t[i] > t[j]))
//				{
//					int temp = p[i]; p[i] = p[j]; p[j] = temp;
//					temp = t[i]; t[i] = t[j]; t[j] = temp;
//				}
		
//		int cnt = 0;
//		for (int i = 0; i < n; i++)
//			if (p[i] == p[k] && t[i] == t[k]) cnt++;
		
//		out.println(cnt);		
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
