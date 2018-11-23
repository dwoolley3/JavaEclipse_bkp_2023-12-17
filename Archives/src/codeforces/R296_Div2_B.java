package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R296_Div2_B
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R296_Div2_B().run();
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
		String s = in.next();
		String t = in.next();

		int[][] a = new int[26][26];
		int cnt = 0;
		for (int i = 0; i < n; i++) 
		{
			char sc = s.charAt(i), tc = t.charAt(i);
			if (sc != tc)
			{
				cnt++;
				a[sc-'a'][tc-'a'] = i+1;
			}
		}
		
		int maxDec = 0, indi = -1, indj = -1;
		for (int i = 0; i < 26 && maxDec < 2; i++)
			for (int j = 0; j < 26 && maxDec < 2; j++)
			{
				if (a[i][j] > 0 && a[j][i] > 0)
				{
					indi = a[i][j]; indj = a[j][i];
					maxDec = 2;
				}
				else if (a[i][j] > 0)
				{
					for (int k = 0; k < 26; k++)
						if (a[j][k] > 0)
						{
							maxDec = 1;
							indi = a[i][j]; indj = a[j][k];
						}
				}
			}
	
		out.println(cnt - maxDec);
		out.println(indi + " " + indj);		
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
