package codeforces;

import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class Lyft_Level5_2018_FR_B_best
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new Lyft_Level5_2018_FR_B_best().run();
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
		int n = in.nextInt();  //riders
		int m = in.nextInt();  //tax drivers
		
		int[] x = new int[n+m];
		for (int i = 0; i < n + m; i++) 
			x[i] = in.nextInt();
		
		int[] tLeft = new int[n+m];
		int[] tRight = new int[n+m];
		tLeft[0] = -1; tRight[n+m-1] = -1;
		int[] t = new int[n+m];
		for (int i = 0; i < n + m; i++) {
			t[i] = in.nextInt();
			if (t[i] == 1) {
				tLeft[i] = i;
			} else if (i > 0) {
				tLeft[i] = tLeft[i-1];
			}			
		}
		for (int i = n + m - 1; i >= 0; i--) {
			if (t[i] == 1) {
				tRight[i] = i;
			} else if (i < n+m-1) {
				tRight[i] = tRight[i+1];
			}	
		}
		
		int[] cnt = new int[n+m];

		for (int i = 0; i < n + m; i++) {
			if (t[i] == 0) { //needs a ride; which taxi is closest?
				int difLeft = x[i] - (tLeft[i] > -1 ? x[tLeft[i]] : -(int)1e9);
				int difRight = (tRight[i] > -1 ? x[tRight[i]] : (int)2e9) - x[i];
				int indTaxi = (difLeft <= difRight) ? tLeft[i] : tRight[i];
				cnt[indTaxi]++;	
			}
		}	

		for (int i = 0; i < n+m; i++) {
			if (t[i] == 1) {
				out.print(cnt[i] + " " );
			}
		}			
		out.println();
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
