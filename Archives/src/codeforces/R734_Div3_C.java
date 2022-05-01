package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R734_Div3_C
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R734_Div3_C().run();
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
			int k = in.nextInt();
			
			int[] a = new int[n];
			int[] c = new int[n];
			HashMap<Integer,Integer> hm = new HashMap<>();
			
			int cnt = 0;
			ArrayList<Integer> u = new ArrayList<>();
			
			@SuppressWarnings("unchecked")
			ArrayList<Integer>[] al = new ArrayList[n+1]; 
			for (int i=0;i<=n;i++) al[i] = new ArrayList<Integer>();
			
			for (int i = 0; i < n; i++) {				
				a[i] = in.nextInt();
				if (hm.containsKey(a[i])) {
					cnt = hm.get(a[i]) + 1;	
				} else {
					cnt = 1;
					u.add(a[i]);
				}
				hm.put(a[i], cnt);
				al[a[i]].add(i);
			}
			
			int tot = 0, empty = 0;
			int color = 1, placed = 0;
			for (int x : u) {
				int num = hm.get(x);
				if (num > k) {
					empty += (num - k);
				}
			}
			tot = n - empty;
			tot = (tot / k) * k;
			//out.println(tot);
			
			for (int x : u) {
				int num = hm.get(x);
				for (int i = 0; i < num && i < k && placed < tot; i++) {
					c[al[x].get(i)] = color;
					placed++;
					color++;
					if (color > k) color = 1;
				}
			}
			
			for (int i = 0; i < n; i++) {
				out.print(c[i] + " ");					
			}
			out.println();
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
