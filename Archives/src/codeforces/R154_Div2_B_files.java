package codeforces;

import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R154_Div2_B_files
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R154_Div2_B_files().runWithFiles();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	
	void runWithFiles() {
		//in = new FastReader(new File("src/input.txt"));
		in = new FastReader(new File("input.txt"));
		try {
			//out = new PrintWriter(new File("src/output.txt"));
			out = new PrintWriter(new File("output.txt"));
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		solve();
		out.close();
	}
	
	void solve()
	{
		int n = in.nextInt();
		
		int[] a = new int[5001];
		int[] c = new int[n];
		for (int i = 0; i < n; i++)
		{
			c[i] = in.nextInt();
			a[c[i]]++;
		}
		int[] sum = new int[5001];
		for (int i = 1; i <= 5000; i++)
			sum[i] = sum[i-1] + a[i];
				
        int min = Integer.MAX_VALUE, tot = 0;
        for (int i = 0; i <= 5000; i++)
            for (int j = 5000; j >= i; j--)
                if (a[i]>0 && a[j]>0 && j <= 2 * i)
                {
                	tot = sum[i-1] + (sum[5000] - sum[j]);
                    min = Math.min(min, tot);
                    break;
                }
		
		System.out.println(min);
		out.println(min);
	}

	//-----------------------------------------------------

	
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
