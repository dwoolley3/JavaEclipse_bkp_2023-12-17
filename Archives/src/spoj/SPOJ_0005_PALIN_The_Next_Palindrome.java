package spoj;

import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList

//****  for SPOJ, class must be called M a i n

public class SPOJ_0005_PALIN_The_Next_Palindrome
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new SPOJ_0005_PALIN_The_Next_Palindrome().run();
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
		int t = in.nextInt();  
		for (int T = 1; T <= t; T++) {			
			String s = in.next();
			int n = s.length();
			int[] a = new int[n];
			boolean all9 = true;
			for (int i = 0; i < n; i++) {			
				a[i] = s.charAt(i) - '0';
				if (a[i] != 9) all9 = false;
			}
			
			//Change number with all 9's: 99 --> 101, 9 --> 11, 999 --> 1001
			if (all9) {
				out.print(1);
				for (int i = 0; i < n-1; i++)
					out.print(0);
				out.println(1);
				continue;
			}
				
			int mid = n/2;
			
			int lastIndLess = -1, lastIndGreater = -1;
			for (int i = 0; i < mid; i++)
			{
				if (a[i] < a[n-1 -i]) lastIndLess = i;
				if (a[i] > a[n-1 -i]) lastIndGreater = i;
			}
			boolean isPal = (lastIndLess == -1 && lastIndGreater == -1);

			if (lastIndGreater < lastIndLess || isPal)
			{
				//Need to add 1 to middle
				int st = mid;
				if (n%2 == 0) 
					st = mid-1;
				a[st]++;
				while (a[st] == 10) {
					a[st] = 0;
					st--;
					a[st]++;
				}
			}
			//Duplicate left-half on right-half
			for (int i = 0; i < mid; i++)
				a[n-i -1] = a[i];
			
			//Display entire palindrome
			for (int i = 0; i < n; i++)
				out.print(a[i]);
			out.println();	
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
