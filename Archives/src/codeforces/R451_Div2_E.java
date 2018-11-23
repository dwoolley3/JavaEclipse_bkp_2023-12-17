package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R451_Div2_E
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R451_Div2_E().run();
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
		
		int[] a = new int[n];
		int[] sq = new int[n];
		int makeNonsq1 = 0;
		int sqcnt = 0;
		long sum = 0;
		for (int i = 0; i < n; i++) 
		{
			a[i] = in.nextInt();
			int x = (int)Math.sqrt(a[i]);
			int min = Math.abs(x*x - a[i]);
			x++;
			min = Math.min(min, Math.abs(x*x - a[i]));
			
			sq[i] = min;
			if (min == 0) {
				if (a[i] > 0)  //else takes 2 when a[i] == 0
					makeNonsq1++;
				sqcnt++;
			}
		}
		
		if (sqcnt > n/2) {
			int dif = sqcnt - n/2;
			sum = Math.min(dif, makeNonsq1);
			dif -= sum;
			if (dif > 0) sum += dif * 2; 
		}
		else {
			Arrays.sort(sq);
			for (int i = 0; i < n; i++)
				if (sq[i] == 0) continue;
				else
				{
					if (sqcnt < n/2) {
						sum += sq[i];
						sqcnt++;
					}
				}
		}
		out.println(sum);
	
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
