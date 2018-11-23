package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R244_Div2_E
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R244_Div2_E().run();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	
	static int m;
	void solve()
	{
		int n = in.nextInt();
		m = in.nextInt();
		
		int[] a = new int[n];
		for (int i = 0; i < n; i++) 
			a[i] = in.nextInt();
			
		long first = dist(a,a[0]);
		long last = dist(a,a[n-1]);
		long min = Math.min(first,  last);
		
		int right =  a[n-1], left = a[0];

        //while (left <= right)
        {
    		int mid = (right + left) / 2;
        	long val = dist(a, mid);
        	
        	if (val < min) 
        	{
        		min = val;
        		right = mid - 1;
        	}
        	//if (val > min) left = mid + 1;
        }
		
		out.println(min);		
	}
	
	private static long dist(int[] a, int pos)
	{
		int n = a.length;
		int car = 0;
		long sum = 0;
		for (int i = 0; i < n; i++)
		{
			while ( i < n && a[i] <= pos && car <= m)
			{
				car++; 
				sum += (pos - a[i]) * 2;
				i++;
			}
		}
		for (int i = n-1; i > 0; i--)
		{
			while (i > 0 && a[i] > pos && car <= m)
			{
				car++; 
				sum += (a[i] - pos) * 2;
				i--;
			}
		}
		
		return sum;
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
