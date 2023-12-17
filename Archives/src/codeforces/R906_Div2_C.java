package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R906_Div2_C
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R906_Div2_C().run();
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
			String s = in.next();
			boolean good = false;
			ArrayList<Integer> al = new ArrayList<>();
			if (isEqual0and1(s)) { // n must be even
				StringBuilder sb = new StringBuilder(s);
				al = new ArrayList<>();
				for (int i = 0; i < n/2; i++) {
					char c = sb.charAt(i);
					if (c == sb.charAt(n-1-i)) {
						if (c == '0') {
							sb.insert(n-i, "01");
							al.add(n-i);
							n += 2;
						} else {
							sb.insert(i, "01");
							al.add(i);
							n += 2;
						}
						//System.out.println(sb);
					}
				}
				
				good = true;
			}

			if (!good) {
				out.println(-1);
			} else {
				out.println(al.size());
				for (int i : al) {
					out.print(i + " ");
				}
				if (al.size() > 0) out.println();
			}
		}
	}
	
	boolean isEqual0and1 (String s) {
		int n = s.length(), zero = 0;
		for (int i = 0; i < n; i++)
			if (s.charAt(i) == '0') zero++;
		
		return zero == (n - zero);
	}
	
	boolean isComplement(String s) {
        int n = s.length();
        for (int i = 0; i < n/2; i++)
            if (s.charAt(i) == s.charAt(n - i - 1)) return false;
        return true;

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
