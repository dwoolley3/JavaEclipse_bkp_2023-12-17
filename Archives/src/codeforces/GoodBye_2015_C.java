package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class GoodBye_2015_C
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new GoodBye_2015_C().run();
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
		int h = in.nextInt();
		int w = in.nextInt();
		
		char[][] c = new char[h][w];
		for (int i = 0; i < h; i++) 
			c[i] = in.next().toCharArray();
		
		int[][] a = new int[h][w];
		for (int i = 0; i < h; i++)
			for (int j = 0; j < w; j++)
			{
				if (i == 0 && j == 0) continue;
				if (i > 0) a[i][j] += a[i-1][j];		
				if (j > 0) a[i][j] += a[i][j-1];
				if (i > 0 && j > 0) a[i][j] -= a[i-1][j-1];
				if (i > 0 && c[i][j] == '.' && c[i-1][j] == '.') 
					a[i][j]++;
				if (j > 0 && c[i][j] == '.' && c[i][j-1] == '.') 
					a[i][j]++;
			}
		
		int n = in.nextInt();
		long sum = 0;
		for (int i = 0; i < n; i++)
		{
			int r1 = in.nextInt()-1;
			int c1 = in.nextInt()-1;
			int r2 = in.nextInt()-1;
			int c2 = in.nextInt()-1;
			
			sum = a[r2][c2];
			if (r1 > 0) {
				sum -= a[r1-1][c2];
				for (int j = c1; j <= c2; j++)
					if (c[r1-1][j] == '.' && c[r1][j] == '.')
						sum--;
			}
			if (c1 > 0) { 
				sum -= a[r2][c1-1];
				for (int j = r1; j <= r2; j++)
					if (c[j][c1-1] == '.' && c[j][c1] == '.')
						sum--;
			}
			if (r1 > 0 && c1 > 0) sum += a[r1-1][c1-1];
			out.println(sum);			
		}
		
//		int cnt = 0;
//		for (int i = 0; i < h; i++)
//		{
//			for (int j = 0; j < w; j++)
//				out.print(a[i][j] + " ");
//			out.println();
//		}		
//		out.println(cnt);	
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
