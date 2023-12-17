package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R845_Div2_C
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R845_Div2_C().run();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	// Close, but WA, for example
	// 1
	// 6 3
	// 3 6 32 33 63 68
	// Answer should be 33-32 = 1, but is 68-63 = 5 in my pgm
	
	void solve()
	{
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] fact = new ArrayList[100_001];
		for (int i = 1; i <= 100_000; i++) {
			fact[i] = new ArrayList<Integer>();
			for (int j = 1; j*j <= i; j++) {
				if (i % j == 0) {
					fact[i].add(j);
					fact[i].add(i/j);
				}				
			}
		}
		
		int t = in.nextInt();
		for (int T = 0; T < t; T++) {
			int n = in.nextInt();
			int m = in.nextInt();
			
			int[] a = new int[n];
			for (int i = 0; i < n; i++) 
				a[i] = in.nextInt();
			
			Arrays.sort(a);
			int[] cnt = new int[m+1];
			HashSet<Integer> hs = new HashSet<>();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < fact[a[i]].size(); j++) {
					int x = fact[a[i]].get(j);
					if (x <= m) {
						hs.add(x);
						cnt[x]++;
					}
				}
			}			
			
			int ans = -1;
			if (hs.size() == m) {
				boolean zeroCnt = false;
				int en = n-1;
				int st = 0;
				for (st = 0; st < n; st++) {
					for (int j = 0; j < fact[a[st]].size(); j++) {
						int x = fact[a[st]].get(j);
						if (x <= m) {
							cnt[x]--;
							if (cnt[x] == 0) zeroCnt = true;
						}
					}
					if (zeroCnt) {
						//ans = en - st;
						//restore last cnt
						for (int j = 0; j < fact[a[st]].size(); j++) {
							int x = fact[a[st]].get(j);
							if (x <= m) {
								cnt[x]++;
							}
						}
						break;
					}
				}
				zeroCnt = false;
				for (en = n-1; en >= st; en--) {
					for (int j = 0; j < fact[a[en]].size(); j++) {
						int x = fact[a[en]].get(j);
						if (x <= m) {
							cnt[x]--;
							if (cnt[x] == 0) zeroCnt = true;
						}
					}
					if (zeroCnt) {
						ans = a[en] - a[st];
						break;
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
