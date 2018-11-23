package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R239_Div2_B //Name: Garland
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R239_Div2_B().run();
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
		String s1 = in.next();
		String s2 = in.next();
		int n = s1.length();
		int m = s2.length();
		int[] c1 = new int[26];
		int[] c2 = new int[26];
		for (int i = 0; i < n; i++)
			c1[s1.charAt(i)-'a']++;
		for (int i = 0; i < m; i++)
			c2[s2.charAt(i)-'a']++;
		
		int cnt = 0;
		for (int i = 0; i < 26; i++)
			if (c2[i] > 0 && c1[i] == 0)
			{
				out.println(-1);
				return;
			}
			else if (c2[i] <= c1[i])
				cnt += c2[i];
			else //c2[i] > c1[i]
				cnt += c1[i];
//			{
//				for (int j = c1[i]; j >= 1; j--)
//					if (c2[i] % j == 0)
//					{
//						cnt += j;
//						break;
//					}
//			}
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
