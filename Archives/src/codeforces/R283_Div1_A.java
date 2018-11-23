package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R283_Div1_A
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R283_Div1_A().run();
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
		int m = in.nextInt();
		StringBuilder[] sb= new StringBuilder[n];
		for (int i = 0; i < sb.length; i++) 
		    sb[i] = new StringBuilder("");
		
		String[] s = new String[n];
		for (int i = 0; i < n; i++)
			s[i] = in.next();
		
		int cnt = 0, lastInd = -1;
		for (int c = 0; c < m; c++)
		{
			boolean ok = true;
			lastInd++;
			for (int r = 0; r < n && ok; r++)
			{
				sb[r].append(s[r].charAt(c));
				if (r > 0) {
					String s1 = sb[r-1].toString();
					String s2 = sb[r].toString();
					if (s1.compareTo(s2) > 0)
					{
						//out.println(s1 + " " + s2);
						cnt++;
						ok = false;
						for (int rr=0; rr <= r; rr++)
							sb[rr].deleteCharAt(lastInd);
						lastInd--;
					}
				}
			}
		}
		
		out.println(cnt);		
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
