package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R257_Div2_B //Name: Jzzhu and Sequences
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R257_Div2_B().run();
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
		int[] f = new int[9];
		f[1] = in.nextInt();
		f[2] = in.nextInt();
		int n = in.nextInt();
		int ind = ((n-1) % 6) + 1;
		
		for (int i = 3; i <= 8; i++)
			f[i] = f[i-1] - f[i-2];

//		for (int i = 1; i < 9; i++)
//			out.print((f[i] + " "));
//		out.println();
		
		int ans = f[ind];
		
		while (ans < 0) ans += 1_000_000_007;
		ans = ans % 1_000_000_007;
		
		//Alternatively, to make a negative ans a positive modulo 1_000_000_007
		//ans = ans % 1_000_000_007;
		//if (ans < 0) ans += 1_000_000_007;

		out.println(ans);		
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
