package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R355_Div2_C
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R355_Div2_C().run();
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
		String s = in.next();
		int n = s.length();
		String b64 = "";
		for (int i = 0; i <= 9; i++) b64 += i + "";
		for (char c = 'A'; c <= 'Z'; c++) b64 += c;
		for (char c = 'a'; c <= 'z'; c++) b64 += c;
		b64 += "-" + "_";
		
//		HashMap<Character,Integer> hm = new HashMap<>();
//		for (int i = 0; i < 64; i++)
//		{
//			char c = b64.charAt(i);		
//			hm.put(c,i);
//		}
		
		int[] cnt = new int[64];
		for (int j = 0; j < 64; j++)
			for (int k = 0; k < 64; k++)
				cnt[(k & j)]++;
		
		long prod = 1;
		for (int i = 0; i < n; i++)
		{
			char c = s.charAt(i);
			//int ind = hm.get(c);
			
			int ind = b64.indexOf(c);
//			int cnt = 0;
//			for (int j = 0; j < 64; j++)
//				for (int k = 0; k < 64; k++)
//					if ((k & j) == ind) cnt++;
			
			prod *= cnt[ind];
			prod %= 1_000_000_007;
		}
		out.println(prod);			
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
