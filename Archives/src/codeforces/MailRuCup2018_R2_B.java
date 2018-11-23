package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class MailRuCup2018_R2_B
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new MailRuCup2018_R2_B().run();
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
		int n = in.nextInt(); // num of hairs
		int m = in.nextInt(); // num of requests
		int l = in.nextInt(); // max length of hair
		
		long[] a = new long[n+1];
		boolean[] cut = new boolean[n+2];
		for (int i = 1; i <= n; i++) 
		{
			a[i] = in.nextInt();
			if (a[i] > l) cut[i] = true;
		}
		int numCuts = 0;
		boolean needCut = false;
		for (int i = 1; i <= n; i++) {
			if (cut[i]) {
				if (!needCut) {
					needCut = true;
					numCuts++;
				}
			}
			else { //cut[i] == false
				needCut = false;
			}
		}
		//System.out.println(numCuts);
		
		
		for (int i = 0; i < m; i++) {
			int t = in.nextInt();
			if (t == 1) {
				int p = in.nextInt();
				int d = in.nextInt();
				a[p] += d;
				if (a[p] > l && !cut[p]) {
					cut[p] = true;
					if (cut[p-1] && cut[p+1]) {
						numCuts--;
					}
					else if (!cut[p-1] && !cut[p+1]) {
						numCuts++;
					}
				}
			}
			else { //t == 0
				out.println(numCuts);
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
