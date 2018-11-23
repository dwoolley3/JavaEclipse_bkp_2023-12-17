package spoj;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList

//****  for SPOJ, class must be called M a i n

public class SPOJ_0346_COINS_Bytelandian_gold_coins
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new SPOJ_0346_COINS_Bytelandian_gold_coins().run();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	
	HashMap<Integer, Long> hm = new HashMap<Integer, Long>();
	
	void solve()
	{
		int t = 10;  
		for (int T = 1; T <= t; T++) {
			String s = in.nextLine();
			if (s == null || s.equals("")) break;
			int n = Integer.parseInt(s);
			long ans = f(n);
			out.println(ans);
		}
	}

	private long f(int n) {
		if (n == 0) return 0;
		if (hm.containsKey(n)) return hm.get(n); //memo
		long sum = f(n/2) + f(n/3) + f(n/4);
		long best = Math.max(n, sum);
		hm.put(n, best);
		return best;
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
