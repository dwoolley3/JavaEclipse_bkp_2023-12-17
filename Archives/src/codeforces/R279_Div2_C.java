package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R279_Div2_C
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R279_Div2_C().run();
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
		//BigInteger functions are not fast enough, so simulate division.
		
		String s = in.next();
		int a = in.nextInt();
		int b = in.nextInt();
		int n = s.length();
		
		int[] rema = new int[n];
		int[] remb = new int[n];
		
		rema[0] = (s.charAt(0)-'0') % a;
		for (int i = 1; i < n; i++)
			rema[i] = (rema[i-1] * 10 + (s.charAt(i)-'0')) % a;
		
		remb[n-1] = (s.charAt(n-1)-'0') % b;
		int powTen = 10;
		for (int i = n-2; i >= 0; i--)
		{
			remb[i] = (((s.charAt(i)-'0') * powTen) % b + remb[i+1] % b) % b;
			powTen *= 10;
			powTen %= b;
		}
			
		for (int i = 0; i < n-1; i++)
			if (rema[i] == 0 && remb[i+1] == 0 && s.charAt(i+1) != '0')
			{
				out.println("YES");
				out.println(s.substring(0,i+1));
				out.println(s.substring(i+1));
				return;
			}		
		out.println("NO");
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
