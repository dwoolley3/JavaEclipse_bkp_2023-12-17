package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class CoderStrike_2014_R2_C //Name: Jeopardy!
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new CoderStrike_2014_R2_C().run();
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
		int m = in.nextInt();
		
		int[] a = new int[n+1];
		for (int i = 1; i <= n; i++) 
			a[i] = in.nextInt();
		
		int[] b = new int[m];
		int[] auc = new int[m];
		for (int i = 0; i < m; i++) 
		{
			b[i] = in.nextInt();
			auc[i] = a[b[i]];
		}
		long sum = 0;
		
		for (int i = 1; i <= n; i++)
		{			
			boolean unique = true;
			for (int j = 0; j < m; j++)
				if (b[j] == i) unique = false;
			if (unique)
				sum += a[i];
		}

		Arrays.sort(auc);
		for (int i = m-1; i>=0; i--)
			if (auc[i] <= sum) sum += sum;
			else sum += auc[i];
		
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
