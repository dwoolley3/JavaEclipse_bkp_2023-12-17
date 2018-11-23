package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R333_Ed2_C_WA
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R333_Ed2_C_WA().run();
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
		int n = s.length();
		int[] a = new int[26];
		for (int i = 0; i < n; i++)
			a[s.charAt(i)-'a']++;
		
		int numOfOdds = 0;
		for (int i = 1;i < 26; i++)
			if (a[i] % 2 == 1) numOfOdds++;
		
		//int x = numOfOdds / 2;		
		//boolean isAodd = (a[0] % 2 == 1);
		for (int i = 25; i > 0; i--)
			if (a[i] % 2 == 1)
				if (numOfOdds / 2 > 1 || (numOfOdds == 1 && a[0] % 2 == 1))
				{
					a[0]++; //Add a
					a[i]--; //Make even
					numOfOdds--;
				}
		
		char oddchar = ' ';
		for (int i = 0;i < 26; i++)
			if (a[i] % 2 == 1) oddchar = (char)('a' + i);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0;i < 26; i++)
			if (a[i] > 0)
				for (int j = 0; j < a[i]/2; j++)
				{
					sb.append((char)('a' + i));
					if (sb.length() == n/2)
						break;
				}		
		
		if (n%2 == 1)
			sb.append(oddchar);
		for (int i = n/2 - 1; i >= 0; i--)
			sb.append(sb.charAt(i));
		
		out.println(sb);		
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
