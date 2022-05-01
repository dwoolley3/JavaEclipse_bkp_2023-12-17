package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R729_Div2_C
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R729_Div2_C().run();
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
		int[] a = new int[] {2,3,4,5,7,8,9,11,13,16,17,19,23,25,27};
		int la = a.length;
		long pr = 1;
		for (int i = 0; i < la; i++) {
			pr *= a[i];
		}
		//System.out.println(pr);
		

			
		
		//int min = 2;
		//int[] f = new int[100];
//		for (int i = 1; i < 100; i++) {
//			min = 2;
//			while (i % min == 0) min++;
//			f[i] = min;
//			System.out.println(i + "=" + min);
//		}
		int MOD = (int)(1e9 + 7);
		
		int t = in.nextInt();
		for (int T = 0; T < t; T++) {
			long n = in.nextLong();
			
			long sum = ((n+1) / 2) * 2;
			long prod = pr;
			for (int i = la-1; i >= 1; i--) {
				long x = n / prod / a[i];
				sum += (x * a[i-1]);
				sum = sum % MOD;
				prod /= a[i];
			}
			
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
