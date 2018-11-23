package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R341_Div2_B
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R341_Div2_B().run();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	

	static int count(int[][] a, int r, int c, int rInc, int cInc)
	{
		int cnt = 0, row = r, col = c, n = a.length - 1;		
		for (int i = 0; i < n; i++)
		{
			cnt += a[row][col];
			row += rInc;
			col += cInc;
			if (row < 1 || col < 1 || row > n || col > n)
				break;
		}
		return cnt * (cnt - 1) / 2;
	}
	
	void solve()
	{
		int n = in.nextInt();
		
		int[][] a = new int[1001][1001];
		for (int i = 0; i < n; i++) 
			a[in.nextInt()][in.nextInt()]++;
		
		long sum = 0;
		for (int r = 1000; r >= 1; r--)
			sum += count(a, r, 1, +1, +1);
		
		for (int c = 2; c <= 1000; c++)
			sum += count(a, 1, c, +1, +1);
		
		for (int r = 1; r <= 1000; r++)
			sum += count(a, r, 1, -1, +1);
		
		for (int c = 2; c <= 1000; c++)
			sum += count(a, 1000, c, -1, +1);		
		
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
