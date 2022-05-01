package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R712_Div2_B
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R712_Div2_B().run();
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
			String b1 = in.next();
			String b2 = in.next();
			if (n%2 == 1) {
				if (b1.charAt(n-1) != b2.charAt(n-1)) {
					out.println("NO");
					continue;
				}
				n--; // make even
			}
			
			int[] a = new int[n/2];
			int[] cnt = new int[n/2];
			boolean ok = true;
			for (int i = 0; i < n && ok; i+=2) {
				if(b1.charAt(i) == b2.charAt(i) && b1.charAt(i+1) == b2.charAt(i+1))
					a[i/2] = 0;
				else if (b1.charAt(i) != b2.charAt(i) && b1.charAt(i+1) != b2.charAt(i+1))
					a[i/2] = 1;
				else
					ok = false;
				
				cnt[i/2] = b1.charAt(i)-'0' + b1.charAt(i+1)-'0';	
				if (i > 1) {
					cnt[i/2] += cnt[(i-2)/2];
				}
			}
			if (!ok) {
				out.println("NO");
				continue;
			}
//			for (int i = 0; i < n/2; i++) {
//				out.print(cnt[i] + " ");
//			}
//			out.println();
//			for (int i = 0; i < n/2; i++) {
//				out.print(a[i] + " ");
//			}
//			out.println();

			int flip = 0;
			for (int i = n/2 - 1; i >= 0 && ok; i--) {
				if (a[i] == 1 && flip == 1) continue;				
				if (a[i] == 1 && flip == 0 && cnt[i] * 2 != (i+1)*2) ok = false;
				if (a[i] == 0 && flip == 0) continue;
				if (a[i] == 0 && flip == 1 && cnt[i] * 2 != (i+1)*2) ok = false;
				flip = 1 - flip;
			}
			out.println(ok ? "YES" : "NO");
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
