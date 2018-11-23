package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R229_Div2_C //Name: Inna and Candy Boxes
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R229_Div2_C().run();
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
		int w = in.nextInt();
		
		String st = in.next();
		int[] a = new int[n+1];
		for (int i = 0; i < n; i++)
			a[i+1] = st.charAt(i) - '0';

		int[][] b = new int[k+1][n+1];
		for (int i = 1; i <= k; i++)
			for (int j = i; j <= n; j += k)
				if (j == i) 
					b[i][j] = a[j];
				else
					b[i][j] = b[i][j-k] + a[j];
						
		int l,r;
		for (int i = 0; i < w; i++) 
		{
			l = in.nextInt();
			r = in.nextInt();
			long sum = 0;
			for (int j = 1; j <= k-1; j++)
			{
				int x = (r-k+j) % k;
				if (x==0) x = k;
				sum += b[x][r-k+j];
				if (l-1-k+j > 0)
					sum -= b[x][l-1-k+j];
			}
			int x = (r) % k;
			if (x==0) x = k;
			sum += ((r-l+1)/k - (b[x][r] - b[x][l-1]));
			
			out.println(sum);	
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
