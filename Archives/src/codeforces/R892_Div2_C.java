package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R892_Div2_C
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R892_Div2_C().run();
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
		for (int T = 0; T < t; T++) {
			int n = in.nextInt();
			if (n == 2) {
				out.println(2);
			} else {
				int maxans = 0;
				for (int mid = 1; mid <= n; mid++) {
					int ans = 0;
					int x, max = 0;			
					for (int i = 1; i <= mid; i++) {
						x = i*i;
						ans += x;
						max = Math.max(max, x);
					}
					for (int i = mid+1; i <= n; i++) {
						x = i*(n- (i-(mid+1)));
						ans += x;
						max = Math.max(max, x);
					}
					ans -= max;
					maxans = Math.max(maxans, ans);
				}

				out.println(maxans);
			}
			
//			int[] per = generateInitialPermutation(n);  //Initial = 0,1,...n-1
//			int maxsum = 0, maxi = 0;
//			do {
//				int cnt = 0, sum = 0, max = 0;
//				for (int i = 0; i < n; i++) {
//					out.print(per[i] + " ");
//					sum += ((per[i]+1) * (i+1));
//					max = Math.max(max, (per[i]+1) * (i+1));
//				}
//				sum -= max;
//				if (sum > maxsum) {
//					maxsum = sum;									
//				}
//				out.println(sum);
//				if (sum == 303) break;
//			} while (next_permutation(per));  //next in lexicographical order
//						
//			out.println("maxsum = " + maxsum);
		}
	}
	
	public int[] generateInitialPermutation(int size)
	{
		int[] p = new int[size];
		for (int i = 0; i < size; i++) p[i] = i;
		return p;
	}
	
	public boolean next_permutation(int[] p) 
	{
		// 0,1,2 -> 0,2,1 -> 1,0,2 -> 1,2,0 -> 2,0,1 -> 2,1,0
		int t, n = p.length;
		for (int i = n - 2; i >= 0; i--)
		    if (p[i] < p[i + 1])
		    	for (int j = n - 1;; j--)
		    		if (p[j] > p[i]) 
		    		{
		    			t = p[i]; p[i] = p[j];  p[j] = t;
				        for (i++, j = n - 1; i < j; i++, j--) 
				        {
				        	t = p[i]; p[i] = p[j]; p[j] = t;
				        }
				        return true;
		    		}
		 return false;  //p is last lexicographically, e.g. -> 2, 1, 0
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
