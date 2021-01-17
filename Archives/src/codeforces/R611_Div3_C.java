package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R611_Div3_C
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R611_Div3_C().run();
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
		
		boolean[] has = new boolean[n+1];
		int[] f = new int[n];
		for (int i = 0; i < n; i++) {
			f[i] = in.nextInt();
			has[f[i]] = true;
		}
		ArrayList<Integer> missing = new ArrayList<>(); 
		for (int i = 1; i <= n; i++) {
			if (!has[i]) missing.add(i);
		}
		int mInd = 0;
		for (int i = 0; i < n; i++) {
			if (f[i] == 0) {
				if (i + 1 == missing.get(mInd)) {
					// swap
					if (mInd + 1 == missing.size()) {
						int t = missing.get(mInd);
						missing.set(mInd, missing.get(mInd - 1));
						missing.set(mInd - 1,  t);
					} else {
						int t = missing.get(mInd);
						missing.set(mInd, missing.get(mInd + 1));
						missing.set(mInd + 1,  t);
					}
				}
				mInd++;
			}
		}

		mInd = 0;
		for (int i = 0; i < n; i++) {
			if (f[i] == 0) {
				f[i] = missing.get(mInd++);
			}
		}
		
		for (int i = 0; i < n; i++) {		
			out.print(f[i] + " ");
		}
		out.println();
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
