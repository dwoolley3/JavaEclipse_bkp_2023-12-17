package codeforces;


import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R565_Div3_C
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R565_Div3_C().run();
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
		//int[] num = new int[] {4,8,15,16,23,42};
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] al = new ArrayList[6];		
		for (int i = 0; i < 6; i++) {
			al[i] = new ArrayList<>();
		}
		int n = in.nextInt();	
		int[] a = new int[n];
		for (int i = 0; i < n; i++) { 
			a[i] = in.nextInt();
			al[getPos(a[i])].add(i+1);
		}
		int[] pos = new int[6];
		int goodCnt = 0;
		
		boolean ok = true;	
		while (ok && pos[0] < al[0].size()) {	
			for (int i = 0; i < 5 && ok; i++) {
				if (pos[i] >= al[i].size()) 
					ok = false;
				else {
					while (pos[i+1] < al[i+1].size() 
							&& al[i].get(pos[i]) > al[i+1].get(pos[i+1])) {
						pos[i+1]++;
					}
				}
				if (pos[i+1] >= al[i+1].size()) ok = false;
				pos[i]++;
			}
			if (ok) goodCnt += 6;
		}
		
		out.println(n - goodCnt);		
		
		// *** Someone else's elegant, correct answer
		
	    for (int i = 0; i < n; i++) {
	    	a[i] = getPos(a[i]);
	    }

	    int[] cnt = new int[6];
	    for (int i = n - 1; i >= 0; i--) {
	      if (a[i] == 5) cnt[5]++;
	      else if (cnt[a[i] + 1] >= 1) {
	        cnt[a[i]]++;
	        cnt[a[i] + 1]--;
	      }
	    }

	    out.println(n - 6 * cnt[0]);
	}
	
	int getPos(int n) {
		if (n == 4) return 0;
		if (n == 8) return 1;
		if (n == 15) return 2;
		if (n == 16) return 3;
		if (n == 23) return 4;
		if (n == 42) return 5;
		return -1;
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
