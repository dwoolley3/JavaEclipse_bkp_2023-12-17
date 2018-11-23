package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R267_Div2_B //Name: Fedor and New Game
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R267_Div2_B().run();
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
		int k = in.nextInt();
		
		int[] x = new int[m];
		for (int i = 0; i < m; i++) 
			x[i] = in.nextInt();
		int f = in.nextInt();
		
		int cnt = 0;
		for (int xi : x)
		{
			int dif = 0;
			for (int i = 0; i < n; i++)
				if ((xi >> i) % 2 != (f >> i) % 2)
					dif++;
			if (dif <= k) cnt++;
		}
		out.println(cnt);
		
		//Alternate method:
//		int[] a = new int[22];
//		int[] b = new int[22];
//		for (int i = 0; i < 21; i++)
//		{
//			a[i] = x[m] % 2;
//			x[m] /= 2;
//		}
//		int cnt = 0;
//		for (int j = 0; j < m; j++)
//		{
//			int dif = 0;
//			for (int i = 0; i < 21; i++)
//			{
//				b[i] = x[j] % 2;
//				x[j] /= 2;
//				if (b[i] != a[i]) dif++;
//			}
//			if (dif <= k) cnt++;
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
