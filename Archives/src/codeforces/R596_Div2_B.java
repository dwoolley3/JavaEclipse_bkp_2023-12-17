package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R596_Div2_B
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R596_Div2_B().run();
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
			int k = in.nextInt();
			int d = in.nextInt();
			
			int[] cnt = new int[k+1];
			int[] a = new int[n];
			HashSet<Integer> hs = new HashSet<>();	
			for (int i = 0; i < n; i++) {
				a[i] = in.nextInt();
			}
			for (int i = 0; i < d; i++) {
				cnt[a[i]]++;
				hs.add(a[i]);
			}
			int min = hs.size();
			for (int i = d; i < n; i++) {
				cnt[a[i-d]]--;
				if (cnt[a[i-d]] == 0) {
					hs.remove(a[i-d]);
				}
				cnt[a[i]]++;
				hs.add(a[i]);
				if (hs.size() < min) {
					min = hs.size();
				}
			}

			out.println(min);	
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
