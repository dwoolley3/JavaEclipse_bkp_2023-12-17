package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R915_Div2_C
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R915_Div2_C().run();
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
		// Wrong answer
		
		int t = in.nextInt();
		for (int T = 0; T < t; T++) {
			int n = in.nextInt();
			String s = in.next();
			char[] c = s.toCharArray();
			Arrays.sort(c);
			boolean[] used = new boolean[n];
			
			int j = n-1;
			for (int i = 0; i < n; i++) {
				if (s.charAt(i) == c[j]) {
					used[i] = true;
					//out.print(c[j]);
					j--;
				} 
			}
			if (!used[n-1] && s.charAt(n-1) < c[j]) {
				used[n-1] = true;
				//out.print(s.charAt(n-1));
				j--;
			}
			//out.print(" ");
			int backward = n-1 - j;
			int forward = 0;
			j = 0; 
			for (int i = 0; i < n && j < n; i++) {
				if (!used[i]) {
					while (j < n && s.charAt(i) != c[j]) j++;
					if (j < n) {
						forward++;
						//out.print(c[j]);
					}
				}
			}

			//out.println(backward + " " + forward);
			if (backward + forward == n) {
				if (s.charAt(n-1) == s.charAt(n - backward)) {
					out.println(0);
				} else {
					out.println(backward - 1);
				}
			} else {
				out.println(-1);
			}
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
