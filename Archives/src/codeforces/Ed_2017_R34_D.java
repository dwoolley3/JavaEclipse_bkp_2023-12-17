package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class Ed_2017_R34_D
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new Ed_2017_R34_D().run();
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
		HashMap<Integer, Integer> hm = new HashMap<>();		
		int[] a = new int[n];
		long sum = 0;
		for (int i = 0; i < n; i++) 
		{
			a[i] = in.nextInt();
			int cnt = hm.containsKey(a[i]) ? cnt = hm.get(a[i]) : 0;
			hm.put(a[i], cnt+1);
			sum += a[i];
		}
		BigInteger ans = BigInteger.ZERO;
		
		for (int i = 0; i < n-1; i++)
		{
			sum -= a[i];
			hm.put(a[i], hm.get(a[i]) - 1);
			long sum2 = sum;
			int tot = n-1-i;
			for (int j = -1; j <= 1; j++)
			{		
				if (hm.containsKey(a[i] + j)) {
					int x = hm.get(a[i] + j);				
					sum2 -= (1L * x * (a[i]+j));
					tot -= x;
				}
			}
			long partSum = sum2 - 1L * a[i] * tot;
			BigInteger bi = new BigInteger(partSum+"");
			ans = ans.add(bi);
		}
		
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
