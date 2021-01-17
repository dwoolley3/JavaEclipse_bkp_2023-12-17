package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R621_Div2_B
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R621_Div2_B().run();
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
		int t = in.nextInt();
		for (int tt = 0; tt < t; tt++) {
			int n = in.nextInt();
			int x = in.nextInt();
			
			int[] a = new int[n];			
			HashSet<Integer> hs = new HashSet<>();
			int max = 0, ans = 0;
			for (int i = 0; i < n; i++) {
				a[i] = in.nextInt();
				if (a[i] == x) ans = 1;
				hs.add(a[i]);
				max = Math.max(a[i],max);
			}
			
			if (ans == 0) {						
				ans = x / max;		
				if (x % max != 0) {
					int dif = 0;
					if (ans == 0) 
						dif = x;
					else {
						ans--;
						dif = x - ans * max;
					}
					// find 2 nums that sum to dif
					boolean ok = false;
					for (int i = 0; i < n & !ok; i++) {
						if (hs.contains(dif - a[i])) {
							ans += 2;
							ok = true;
						}
					}
					if (!ok && max > x) {
						ans+=2;
					} else if (!ok) {
						ans += 2;
					} 
				}
			}

			out.println(ans);	
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
