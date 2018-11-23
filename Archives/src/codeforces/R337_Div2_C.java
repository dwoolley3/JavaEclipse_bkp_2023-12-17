package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R337_Div2_C
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R337_Div2_C().run();
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
		int k = in.nextInt();
		if (k == 0)
		{
			out.println("+");
			return;
		}
		int sz = 1;
		for (int i = 0; i < k; i++) sz *= 2;
		char[][] a = new char[sz][sz];
		a[0][0] = '+'; a[0][1] = '+';
		a[1][0] = '+'; a[1][1] = '*';
		
		int dim = 1;
		for (int i = 2; i <= k; i++)
		{
			dim *= 2;
			//duplicate to bottom-left
			for (int r = dim; r < dim*2; r++)
				for (int c = 0; c < dim; c++)
					a[r][c] = a[r-dim][c];
			
			//duplicate to top-right
			for (int r = 0; r < dim; r++)
				for (int c = dim; c < dim*2; c++)
					a[r][c] = a[r][c-dim];
			
			//copy & negate bottom-right
			for (int r = dim; r < dim*2; r++)
				for (int c = dim; c < dim*2; c++)
					if (a[r-dim][c-dim] == '*')
						a[r][c] = '+';
					else
						a[r][c] = '*';
		}

		for (int i = 0; i < sz; i++)
		{
			for (int j = 0; j < sz; j++)				
				out.print(a[i][j]);
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
