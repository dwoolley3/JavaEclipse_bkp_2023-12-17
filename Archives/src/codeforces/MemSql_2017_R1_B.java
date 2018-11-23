package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class MemSql_2017_R1_B
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new MemSql_2017_R1_B().run();
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
		
		int ans = 4; //n == 1
		int length = 1, blocks = 1;
		boolean extendLength = true;
		while (blocks < n) {
			blocks += length;
			ans += 2;
			if (extendLength) {
				length++;
				extendLength = false;
			}
			else
				extendLength = true;
		}		
		out.println(ans);		
		
//		//Alternative #1
//		int a = (int)Math.sqrt(n);
//		int b = n/a;
//		int c = 0;
//		if (a*b == n)
//			c = 2 * (a+b);
//		else 
//			c = 2*(a+b+1);
//		out.println(c);
//		
//		//Alternative #2
//		a = (int) Math.ceil(Math.sqrt(n));
//		b = (int) Math.ceil(1.0*n/a);
//		out.println(2*(a+b));
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
